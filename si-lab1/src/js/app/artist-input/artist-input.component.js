'use strict';

angular.module('artistInput').
  component('artistInput', {
    templateUrl: '/templates/artist-input.html',
    styleUrls: ['/css/artist-input.component.css'],
    controller: function($scope) {

      var list = new Array();

      $scope.artist = {
        name: "",
        imagemSrc: ""
      }

      $scope.createNewArtist = function() {
        if ($scope.artist.name === '') {
          alert("Nome do artista obrigatório");
        } else if (list[$scope.artist.name]) {
          alert("Artista já existe");
        } else {
          list[$scope.artist.name] = $scope.artist;

          $scope.artist.name = "";
          $scope.artist.imagemSrc = "";

          alert("Adiconado!");
        }
      }
    }
  });
