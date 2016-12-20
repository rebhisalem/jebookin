'use strict';

App.controller('CartController', ['$http', '$scope', '$cookieStore', 'CartService', function($http, $scope, cookies, CartService) {
	
		var itemsCookie ='';
		var self = this;
		self.book={bookID:null,title:'',quantity:0,price:0,image:'',stock:0};
        self.books=[];
		self.init = function(){
			if(!(cookies.get(self.itemsCookie) instanceof Array)){
				cookies.put(self.itemsCookie, [], {path: '/project'});
			}
		},
		
		self.addItem = function(item){
			 var quantity = $scope.ctrl.book.quantity;
			 if(quantity=="") return;
			if(quantity == undefined){
				quantity = 1;
			}
			
			var items = cookies.get(self.itemsCookie);
			var trouve = false;
			for(var i = 0; i< items.length; i++){
				if(items[i].bookID == item.bookID){
					if(parseInt(items[i].quantity) + parseInt(quantity)>item.stock){
						alert('Quantité supérieure au stock');
						return;
					}
					else{
						items[i].quantity = parseInt(items[i].quantity) + parseInt(quantity);
						trouve = true;
					}
				}
			}
			if(!trouve){
				items.push({
					bookID : item.bookID,
					title: item.title,
					quantity : quantity,
					price : item.prix,
					image : item.url,
					stock: item.stock
				});
			}
			alert('Element ajouté au panier');
			cookies.put(self.itemsCookie, items);
			angular.copy($scope.initial, $scope.datas);
		},
		
		self.getItemByIndex = function(index){
			var items = cookies.get(self.itemsCookie);
			return items[index];
		},
		
		self.updateQuantity = function(index){
			var items = cookies.get(self.itemsCookie);
			var q = $scope.cart.books[index].quantity;
			if(q == 0) self.removeItem(index);
			else if(q>items[index].stock){
				alert('Quantité supérieure au stock');
				$scope.cart.books[index].quantity = items[index].quantity
				return;
			}
			else{
				items[index].quantity = q;
				alert('Panier mis à jour');
			}
			cookies.put(self.itemsCookie, items);
			angular.copy($scope.initial, $scope.datas);
		},
		
		self.removeItem = function(index){
			var items = cookies.get(self.itemsCookie);
			$scope.cart.books.splice(index, 1);
			items.splice(index, 1);
			
			cookies.put(self.itemsCookie, items, {path: '/'});
		},
		
		self.getItems = function(){
			var items = cookies.get(self.itemsCookie);
			self.books = items;
		},
		
		self.getTotal = function(){
			var items = cookies.get(self.itemsCookie);
			var t = 0;
			for(var i = 0; i<items.length; i++){
				t = t + items[i].quantity * items[i].price;
			}
			return t;
		},
		
		self.checkout = function(){
			var items = cookies.get(self.itemsCookie);
			if(items.length>0 && cookies.get("username")!=undefined){
				var str = "?login="+cookies.get("username")+"&products="+items[0].bookID;
				for (var i = 1; i<items.length; i++){
					str = str + ","+items[0].bookID;
				}
				str = str + "&quantities="+items[0].quantity;
				for (var i = 1; i<items.length; i++){
					str = str + ","+items[0].quantity;
				}
				CartService.checkout(str);
				cookies.put(self.itemsCookie, [], {path: '/project'});
				alert("Commande ajoutée avec succès");
				location.href="/project/books/cart";
			}
		}
		
}]);