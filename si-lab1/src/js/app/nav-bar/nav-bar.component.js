'use strict';

angular.module('navBar').
  component('navBar', {
    templateUrl: '/templates/nav-bar.html',
    controller: function($scope) {
      var items =  [{
        title: "Artistas",
        id: 0
      },
      {
        title: "Músicas",
        id: 1
      },
      {
        title: "Playlists",
        id: 2
      },
      {
        title: "Pesquisar",
        id: 3
      }];

      $scope.items = items;

    }
  });
