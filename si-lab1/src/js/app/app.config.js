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
              otherwise({
                  template: "Not Found"
              })

});
