'use strict';

angular.module('albumGrid').
component('albumGrid', {
  templateUrl: '/templates/album-grid.html',
  controller: function(Data, $scope, $stateParams) {
    // $scope.list = $rootScope.list;
    var artists;

    var toArray = function(obj) {
      return $.map(obj, function(value, index) {
        if (value.name) {
          return [value];
        }
      });
    }

    // $scope.list = toArray(list[0].albums);
    console.log($stateParams.name);
    $scope.list = Data.queryAlbums($stateParams.name);
    $scope.limit = 20;

    $scope.onSearchChange = function() {
      $scope.limit = 20;
    }

    $scope.infiniteScroll = function() {
      $scope.limit += 10;
    }
  }
});
