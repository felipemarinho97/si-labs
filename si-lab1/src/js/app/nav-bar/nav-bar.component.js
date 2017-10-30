'use strict';

angular.module('navBar').
  component('navBar', {
    templateUrl: '/templates/nav-bar.html',
    controller: function($scope) {
      var items =  [{
        title: "Adicionar Artista",
        id: 0
      },
      {
        title: "Adicionar Música",
        id: 1
      },
      {
        title: "Pesquisar Artistas",
        id: 2
      },
      {
        title: "Adicionar Playlist",
        id: 3
      }];

      $scope.items = items;

    }
  });
