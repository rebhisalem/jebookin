'use strict';
 
App.factory('ContactService', ['$http', '$q', function($http, $q){
 
    return {
         
            send: function(name, subject, email, msg) {
                    return $http.get('http://localhost:8082/project/service/contact?name='+name+'&email='+email+"&subject="+subject+"&msg="+msg)
                            .then(
                                    function(response){
                                        return response.data;
                                    }
                            );
            }
    };
 
}]);