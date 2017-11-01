'use strict';

angular.module('musicoteca').
    config(
        function(
          $locationProvider,
          $routeProvider
          ){
          $locationProvider.html5Mode({
              enabled:true
            })

          $routeProvider.
              when("/0", {
                  template: "<artist-input></artist-input>"
              }).
              when("/1", {
                  template: "<artist-grid></artist-grid>"
              }).
              otherwise({
                  template: "Not Found"
              })

});
