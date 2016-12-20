'use strict';
 
App.controller('AuthorController', ['$scope', 'AuthorService', function($scope, AuthorService) {
          var self = this;
		  $scope.items = null;
          self.author={authorID:null,firstname:'',lastname:'',url:''};
          self.authors=[];
          
          self.fetchAllAuthors = function(id){
			  if(id==null){
				AuthorService.fetchAllAuthors()
					  .then(
							   function(d) {
									self.authors = d;
							   },
							   function(errResponse){
									console.error('Error while fetching Currencies');
								}
						);
			  }
			  else{
				  AuthorService.fetchAllBookAuthors(id)
					  .then(
							   function(d) {
									self.authors = d;
							   },
							   function(errResponse){
									console.error('Error while fetching Currencies');
								}
						);
			  }
          };
		  self.getAuthor = function(id){
			  alert(id);
              AuthorService.getAuthor(id)
                  .then(
                               function(d) {
                                    self.author = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
      }]);