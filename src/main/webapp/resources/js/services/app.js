'use strict';
 
var App = angular.module('myApp',['ngCookies']);
// html filter (render text as html)
App.filter('html', ['$sce', function ($sce) { 
    return function (text) {
        return $sce.trustAsHtml(text);
    };    
}])