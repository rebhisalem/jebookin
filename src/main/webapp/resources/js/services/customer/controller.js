'use strict';
 
App.controller('CustomerController', ['$scope', 'CustomerService', '$cookieStore', function($scope, CustomerService, cookies) {
          var self = this;
		  
          self.login = function(){
			  var username = $scope.login;
			  var password = $scope.passwd;
			   CustomerService.connect(username, password)
					  .then(
							   function(d) {
								   if(d.response != "")	alert(d.response);
								   else{
									   cookies.put("username", username);
									   location.href="/project/index";
								   }
							   },
							   function(errResponse){
									console.error('Error while fetching');
								}
						);
          };
		  
		  self.register = function(){
			  var username = $scope.username;
			  var password = $scope.passwd;
			  var firstname = $scope.firstname;
			  var lastname = $scope.lastname;
			  var phone = $scope.phone;
			  var email = $scope.email;
			  if(email==undefined || username==undefined||password==undefined||firstname==undefined||lastname==undefined||phone==undefined){
				  alert('Tous les champs sont obligatoires');
				  //alert(username+" "+password+" "+firstname+" "+lastname+" "+email+" "+phone);
			  }
			  else{
				CustomerService.register(username, password, firstname, lastname, email, phone)
					  .then(
							   function(d) {
								   if(d.response != "")	alert(d.response);
								   else{
									   cookies.put("username", username);
									   location.href="/project/index";
								   }
							   },
							   function(errResponse){
									console.error('Error while fetching');
								}
						);
			  }
          };
		  
		  self.verif = function(){
			  if(cookies.get("username")!="" && cookies.get("username")!=undefined) location.href="/project/index";
          };
		  
		  self.logout = function(){
			  cookies.remove("username");
			  location.href="/project/index";
          };
		  
      }]);