'use strict';

angular.module('artistBox').
  component('artistBox', {
    templateUrl: '/templates/artist-box.html',
    controller: function($scope) {
      this.nome = '@'
    }
  });
