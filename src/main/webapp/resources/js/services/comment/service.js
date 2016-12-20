'use strict';
 
App.factory('CommentService', ['$http', '$q', function($http, $q){
 
    return {
         
            fetchAllComments: function() {
                    return $http.get('http://localhost:8082/project/service/comments/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching comments');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			fetchAllBookComments: function(id) {
                    return $http.get('http://localhost:8082/project/service/comments?id='+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching comments');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			postComment: function(id, name, email, content) {
                    return $http.get('http://localhost:8082/project/service/comment/add?id='+id+'&name='+name+'&email='+email+'&content='+content)
                            .then(
                                    function(){
                                        return 'Commentaire ajouté';
                                    }
                            );
            }
         
    };
 
}]);