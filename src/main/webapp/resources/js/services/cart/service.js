'use strict';

App.factory('CartService', ['$http', '$q', function($http, $q){
	return {
		checkout: function(id) {
					console.log('http://localhost:8082/project/service/customer/checkout'+id);
                    return $http.get('http://localhost:8082/project/service/customer/checkout'+id)
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
	}
}]);