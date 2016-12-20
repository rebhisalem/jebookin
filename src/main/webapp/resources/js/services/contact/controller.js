'use strict';
 
App.controller('ContactController', ['$scope', 'ContactService', '$cookieStore', function($scope, ContactService, cookies) {
          var self = this;
		  
          
		  self.send = function(){
			  var name = $scope.name;
			  var subject = $scope.subject;
			  var msg = $scope.msg;
			  var email = $scope.email;
			  if(email==undefined || msg==undefined||name==undefined||subject==undefined){
				  alert('Tous les champs sont obligatoires');
				  //alert(username+" "+password+" "+firstname+" "+lastname+" "+email+" "+phone);
			  }
			  else{
				ContactService.send(name, subject, email, msg)
					  .then(
							   function(d) {
								   alert(d.response);
								   if(d.response=="Merci pour nous contacter, nous vous conterons le plus tot possible.") location.href="/project/index";
							   },
							   function(errResponse){
									console.error('Error while fetching');
								}
						);
			  }
          };
		  
      }]);