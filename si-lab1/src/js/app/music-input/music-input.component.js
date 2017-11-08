'use strict';

angular.module('musicInput').
  component('musicInput', {
    templateUrl: '/templates/music-input.html',
    styleUrls: ['/css/music-input.component.css'],
    controller: function(Data, $scope, $rootScope) {

      function clone(obj) {
          if (null == obj || "object" != typeof obj) return obj;
          var copy = obj.constructor();
          for (var attr in obj) {
              if (obj.hasOwnProperty(attr)) copy[attr] = obj[attr];
          }
          return copy;
      }

      $scope.music = {
        name: "",
        artist: "",
        album: "",
        anoDeLancamento: null,
        duracao: ""
      }

      var album = {
        musicas: {},
        addMusic: function(music) {
          this.musicas[name] = music;
        }
      }

      $scope.createNewMusic = function() {
        if ($scope.music.name === '') {
          alert("Nome da muisca obrigatório");
        } else if (Data.getMusic($scope.music)) {
          alert("Música já existe");
        } else {

          Data.putMusic(clone($scope.music));

          // $scope.artist.name = "";
          // $scope.artist.imagemSrc = "/images/blank_artist.png";

          alert("Adiconado!");
        }
      }
    }
  });
