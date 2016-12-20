'use strict';
 
App.factory('CustomerService', ['$http', '$q', function($http, $q){
 
    return {
         
            connect: function(login, pwd) {
                    return $http.get('http://localhost:8082/project/service/customer/login?login='+login+'&password='+pwd)
                            .then(
                                    function(response){
                                        return response.data;
                                    }
                            );
            },
			
			register: function(login, pwd, fname, lname, email, phone) {
                    return $http.get('http://localhost:8082/project/service/customer/register?login='+login+'&password='+pwd+"&firstname="+fname+"&lastname="+lname+"&email="+email+"&phone="+phone)
                            .then(
                                    function(response){
                                        return response.data;
                                    }
                            );
            },
			
    };
 
}]);