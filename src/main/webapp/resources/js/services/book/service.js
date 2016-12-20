'use strict';
 
App.factory('BookService', ['$http', '$q', function($http, $q){
 
    return {
         
            fetchAllBooks: function() {
                    return $http.get('http://localhost:8082/project/service/books/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching books');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			getAllThemes: function() {
                    return $http.get('http://localhost:8082/project/service/books/themes')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching themes');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			fetchBooksbyTheme: function(id) {
                    return $http.get('http://localhost:8082/project/service/books/cat?cat='+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching books');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			fetchBooksbyTitle: function(id) {
                    return $http.get('http://localhost:8082/project/service/books/title?search='+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching books');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			fetchFeaturedBooks: function() {
                    return $http.get('http://localhost:8082/project/service/books/featured')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching books');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			fetchRecentBooks: function() {
                    return $http.get('http://localhost:8082/project/service/books/recent')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching books');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
			
			getBook: function(id) {
                    return $http.get('http://localhost:8082/project/service/book?id='+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching books');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);