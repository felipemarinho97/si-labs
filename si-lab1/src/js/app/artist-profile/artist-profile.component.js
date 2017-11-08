'use strict';

angular.module('artistProfile').
  component('artistProfile', {
    templateUrl: '/templates/artist-profile.html',
    controller: function(Data, $stateParams, $scope) {
      $scope.name = $stateParams.name;
      $scope.artist = Data.getArtist($stateParams.name);
    }
  });
