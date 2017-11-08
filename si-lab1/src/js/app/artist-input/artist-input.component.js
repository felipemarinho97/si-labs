'use strict';

angular.module('artistInput').
  component('artistInput', {
    templateUrl: '/templates/artist-input.html',
    styleUrls: ['/css/artist-input.component.css'],
    controller: function(Data, $scope, $rootScope, $compile) {

      function clone(obj) {
          if (null == obj || "object" != typeof obj) return obj;
          var copy = obj.constructor();
          for (var attr in obj) {
              if (obj.hasOwnProperty(attr)) copy[attr] = obj[attr];
          }
          return copy;
      }

      $scope.artist = {
        name: "",
        imagemSrc: "",
        albums: {lenght:0},
        musicQtd: 0
      }

      $scope.hide = function(element) {
        $(element).hide();
      }

      $scope.createNewArtist = function() {
        if ($scope.artist.name === '') {
          angular.element($("#alert-placeholder")).append($compile("<alert type='alert-dangertava' message='Nome do artista obrigatório!'></alert>")($scope));
        } else if (Data.getArtist($scope.artist.name)) {
          angular.element($("#alert-placeholder")).append($compile("<alert type='alert-warning' message='"+$scope.artist.name+" já existe!'></alert>")($scope));
        } else {
          Data.putArtist(clone($scope.artist));

          angular.element($("#alert-placeholder")).append($compile("<alert type='alert-success' message='"+$scope.artist.name+" adicionado com sucesso!'></alert>")($scope));

          $scope.artist.name = "";
          $scope.artist.imagemSrc = "/images/blank_artist.png";

        }
      }
    }
  });
