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
              when("/artist", {
                  template: "<artist-input></artist-input>"
              }).
              when("/music", {
                  template: "<music-input></music-input>"
              }).
              when("/artist/:name", {
                  template: "<artist-profile></artist-profile>"
              }).
              when("/search", {
                  template: "<artist-grid></artist-grid>"
              }).
              otherwise({
                  template: "Not Found"
              })

});
