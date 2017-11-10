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
              state("addArtist", {
                  url: "add/artists",
                  component: "artistInput"
              }).
              state("addMusic", {
                  url: "add/music",
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
                component: "albumGrid"
              }).
              state("addPlaylist", {
                url: "add/playlist",
                component: "playlistInput"
              }).
              state("profile.musicList", {
                url: "/:albumName",
                component: "musicList"
              }).
              state("search", {
                  url: "/search",
                  template: "<artist-grid></artist-grid>"
              }).
              state("artist", {
                  url: "/artist",
                  component: "artistGrid"
              }).
              state("music", {
                  url: "/music",
                  component: "musicGrid"
              }).
              state("playlist", {
                  url: "/playlist",
                  component: "playlistGrid"
              }).
              state("404", {
                  url: "/404",
                  template: "Not Found"
              });

          // $urlRouterProvider.otherwise("/404");

});
