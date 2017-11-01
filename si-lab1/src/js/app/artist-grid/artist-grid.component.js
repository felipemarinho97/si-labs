'use strict';

angular.module('artistGrid').
component('artistGrid', {
  templateUrl: '/templates/artist-grid.html',
  controller: function($scope, $rootScope) {
    // $scope.list = $rootScope.list;

    var list = [{
        name: "asdas",
        imageSrc: ""
      },
      {
        name: "asasdasdasdas",
        imageSrc: ""
      },
      {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      },
      {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      },
      {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      },
      {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      },
      {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      },
      {
        name: "asasdasddas",
        imageSrc: ""
      },
      {
        name: "asadassdas",
        imageSrc: ""
      }
    ];
    // $scope.list = $rootScope.list;
    $scope.list = list;
  }
});
