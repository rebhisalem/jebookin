'use strict';
 
App.controller('BookController', ['$scope', 'BookService', function($scope, BookService) {
          var self = this;
		  $scope.items = null;
          self.book={bookID:null,nbCopieVendu:0,prix:0,publish_date:'',theme:'',title:'',url:'',description:'',stock:0, quantity:1};
          self.books=[];
		  
          self.themes=[];
          
          self.fetchAllBooks = function(id){
			  if(id==""){
				  BookService.fetchAllBooks()
					  .then(
								   function(d) {
										self.books = d;
								   },
									function(errResponse){
										console.error('Error while fetching Currencies');
									}
						   );
			  }else{
				  BookService.fetchBooksbyTheme(id)
					  .then(
								   function(d) {
										self.books = d;
								   },
									function(errResponse){
										console.error('Error while fetching Currencies');
									}
						   );
			  }
          };
		  
		  self.fetchBooksbyTitle = function(id){
			  BookService.fetchBooksbyTitle(id)
					  .then(
								   function(d) {
										self.books = d;
								   },
									function(errResponse){
										console.error('Error while fetching Currencies');
									}
						   );
          };
		  self.getBook = function(id){
              BookService.getBook(id)
                  .then(
                               function(d) {
                                    self.book = d;
									self.book.quantity=1;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
		  
		  self.fetchFeaturedBooks = function(){
              BookService.fetchFeaturedBooks()
                  .then(
                               function(d) {
                                    self.books = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
		  
		  self.getAllThemes = function(){
              BookService.getAllThemes()
                  .then(
                               function(d) {
                                    self.themes = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
		  
		  self.fetchRecentBooks = function(){
              BookService.fetchRecentBooks()
                  .then(
                               function(d) {
                                    self.books = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
		  
		  self.verifQuantity = function(){
			 var qt = $scope.ctrl.book.quantity;
			 if(qt=="") return false;
			 if(self.book.stock<qt){
				 alert('Quantité supérieure au stock');
				 $scope.ctrl.book.quantity = 1;
				 angular.copy($scope.initial, $scope.datas);
				 return false;
			 }

		  }
 
      }]);