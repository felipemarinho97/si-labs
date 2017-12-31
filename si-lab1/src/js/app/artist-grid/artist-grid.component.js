'use strict';

angular.module('artistGrid').
component('artistGrid', {
  templateUrl: '/templates/artist-grid.html',
  controller: function(Data, $scope) {

    Data.queryArtists().then((response) => {
      $scope.list = response.data;
    }).catch(() => {
      $scope.list = [];
      console.log("Não foi possível recuperar os artistas.")
    })
    $scope.limit = 20;

    $scope.onSearchChange = function() {
      $scope.limit = 20;
    }

    $scope.infiniteScroll = function() {
      $scope.limit += 10;
    }
  }
});
