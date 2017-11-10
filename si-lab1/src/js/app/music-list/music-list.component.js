'use strict';

angular.module('musicList').
  component('musicList', {
    templateUrl: '/templates/music-list.html',
    styleUrls: ['/css/artist-input.css'],
    controller: function(Data, $scope, $stateParams, $compile) {

      $scope.album = Data.getAlbum($stateParams.albumName, $stateParams.name);
      $scope.musics = Data.queryMusics($stateParams.name, $stateParams.albumName);
      $scope.playlists = Data.queryPlaylists();
    }
  });
