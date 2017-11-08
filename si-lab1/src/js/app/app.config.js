'use strict';

angular.module('musicoteca').
    config(
        function(
          $stateProvider,
          $urlRouterProvider
          ){

          $stateProvider.
              state("home", {
                  url: "/",
                  component: "artistGrid"
              }).
              state("artist", {
                  url: "/artists",
                  component: "artistInput"
              }).
              state("music", {
                  url: "/music",
                  template: "<music-input></music-input>"
              }).
              state("profile", {
                  url: "/artist/:name",
                  template: "<artist-profile></artist-profile>",
                  resolve: {
                    artista: ($stateParams) => {
                      // recupera o artista $stateParams.name
                    }
                  }
              }).
              state("profile.albums", {
                url: "/albums",
                component: "artistInput"
              }).
              state("search", {
                    url: "/search",
                  template: "<artist-grid></artist-grid>"
              }).
              state("404", {
                    url: "/404",
                  template: "Not Found"
              });

          // $urlRouterProvider.otherwise("/404");

});
