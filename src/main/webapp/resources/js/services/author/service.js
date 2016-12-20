'use strict';
 
App.factory('AuthorService', ['$http', '$q', function($http, $q){
 
    return {
         
            fetchAllAuthors: function() {
                    return $http.get('http://localhost:8082/project/service/authors/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching authors');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			fetchAllBookAuthors: function(id) {
                    return $http.get('http://localhost:8082/project/service/authorsB/?id='+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching authors');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			getAuthor: function(id) {
                    return $http.get('http://localhost:8082/project/service/author?id='+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching author');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);