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
                  abstract: true,
                  url: "/artist",
                  template: "<artist-profile></artist-profile><div ui-view></div>",
                  resolve: {
                    artista: ($stateParams) => {
                      // recupera o artista $stateParams.name
                    }
                  }
              }).
              state("artistProfileAlbums", {
                url: "/artist/:name/albums",
                parent: "profile",
                component: "artistGrid"
              }).
              state("search", {
                    url: "/search",
                  template: "<artist-grid></artist-grid>"
              }).
              state("404", {
                    url: "/404",
                  template: "Not Found"
              });

          $urlRouterProvider.otherwise("/404");

});
