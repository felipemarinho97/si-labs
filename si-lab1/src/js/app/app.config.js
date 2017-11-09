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
                  component: "artistProfile",
                  resolve: {
                    artista: ($stateParams) => {
                      // recupera o artista $stateParams.name
                    }
                  }
              }).
              state("profile.albums", {
                url: "",
                component: "albumGrid"
              }).
              state("profile.music", {
                url: "/:album",
                template: "albumList"
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
