'use strict';

angular.module('artistProfile').
  component('artistProfile', {
    templateUrl: '/templates/artist-profile.html',
    controller: function(Data, $routeParams, $scope) {
      $scope.name = $routeParams.name;
      $scope.artist = Data.getArtist($routeParams.name);
    }
  });
