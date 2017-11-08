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

      let alert = function(type, message) {
        if ($("#alert-placeholder alert").length >= 3) {
          $("#alert-placeholder alert").last().remove();
        }
        angular.element($("#alert-placeholder")).prepend($compile("<alert type='"+type+"' message='"+message+"'></alert>")($scope));
      }

      $scope.createNewArtist = function() {
        if ($scope.artist.name === '') {
          alert("danger", 'Nome do artista obrigatório!');
        } else if (Data.getArtist($scope.artist.name)) {
          alert("warning", $scope.artist.name+' já existe!');
        } else {
          Data.putArtist(angular.copy($scope.artist));

          alert("success",$scope.artist.name + " adicionado com sucesso!");

          $scope.artist.name = "";
          $scope.artist.imagemSrc = "/images/blank_artist.png";

        }
      }
    }
  });
