'use strict';

angular.module('artistInput').
  component('artistInput', {
    templateUrl: '/templates/artist-input.html',
    styleUrls: ['/css/artist-input.component.css'],
    controller: function(Data, $scope, $rootScope) {

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
          alert("Nome do artista obrigatório");
        } else if (Data.getArtist($scope.artist.name)) {
          alert("Artista já existe");
        } else {
          Data.putArtist(clone($scope.artist));

          $('#alert-placeholder').append('<div id="alertdiv" class="alert alert-success alert-dismissable" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><span>'+$scope.artist.name+' adiciondo com sucesso!</span></div>');

          $scope.artist.name = "";
          $scope.artist.imagemSrc = "/images/blank_artist.png";

        }
      }
    }
  });
