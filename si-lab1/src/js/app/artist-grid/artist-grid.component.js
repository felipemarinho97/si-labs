'use strict';

angular.module('artistGrid').
component('artistGrid', {
  templateUrl: '/templates/artist-grid.html',
  controller: function(Data, $scope, $rootScope) {
    // $scope.list = $rootScope.list;
    var artists;
    // Data.query(function(data) {
    //   console.log(data);
    //   artists = data;
    // })
    //
    //
    // Data.put(data, function(data) {
    //   console.log(data);
    // })


    var list = [{
        name: "Jethro Tull",
        imagemSrc: "http://www.prog-sphere.com/wp-content/uploads/2017/05/Jethro-Tull.jpg",
        albums: {
          "Aqualung": {
            name: "Aqualung",
            artist: "Jethro Tull",
            musics: {
              "Aqualung": {
                name: "Aqualung",
                artist: "Jethro Tull",
                album: "Aqualung",
                anoDeLancamento: "02/02/169",
                duracao: "600"
              },
              "Cross-Eyed Mary": {
                name: "Cross-Eyed Mary",
                artist: "Jethro Tull",
                album: "Aqualung",
                anoDeLancamento: "02/02/169",
                duracao: "600"
              },
              "Cheap Day Return": {
                name: "Cheap Day Return",
                artist: "Jethro Tull",
                album: "Aqualung",
                anoDeLancamento: "02/02/169",
                duracao: "600"
              },
              "Up To Me": {
                name: "Up To Me",
                artist: "Jethro Tull",
                album: "Aqualung",
                anoDeLancamento: "02/02/169",
                duracao: "600"
              },
              "Hymn 43": {
                name: "Hymn 43",
                artist: "Jethro Tull",
                album: "Aqualung",
                anoDeLancamento: "02/02/169",
                duracao: "600"
              }
            }
          },
          "Thick as a Brick": {
            name: "Thick as a Brick",
            artist: "Jethro Tull",
            musics: {
              "Thick as a Brick": {
                name: "Thick as a Brick",
                artist: "Jethro Tull",
                album: "Thick as a Brick",
                anoDeLancamento: "02/02/169",
                duracao: "600"
              }
            }
          },
          lenght: 3
        },
        musicQtd: 15
      },
      {
        name: "Pink Floyd",
        imagemSrc: "https://upload.wikimedia.org/wikipedia/en/d/d6/Pink_Floyd_-_all_members.jpg",
      }, {
        name: "Serginho Groisman",
        imagemSrc: "https://upload.wikimedia.org/wikipedia/commons/2/2c/Serginho_Groisman_%282012%29_cropped.jpg"
      }, {
        name: "asasdasda6sdas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      }, {
        name: "asasda6sddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      }, {
        name: "aertesasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdaiouiosdas",
        imageSrc: ""
      }, {
        name: "asasdkjkiua6sddas",
        imageSrc: ""
      }, {
        name: "asasdasdadasddas",
        imageSrc: ""
      }, {
        name: "asasdadadasdasdas",
        imageSrc: ""
      }, {
        name: "asasda6sddas",
        imageSrc: ""
      }, {
        name: "asasdasfasdasdas",
        imageSrc: ""
      }, {
        name: "asasdgf6hfasddas",
        imageSrc: ""
      }, {
        name: "asas6dasddas",
        imageSrc: ""
      }, {
        name: "asasdas6dasdas",
        imageSrc: ""
      }, {
        name: "asasdasd6das",
        imageSrc: ""
      }, {
        name: "asasdasdasd6as",
        imageSrc: ""
      }, {
        name: "a6sasdasddas",
        imageSrc: ""
      }, {
        name: "asasdask6jlkjddas",
        imageSrc: ""
      }, {
        name: "asasda54654sdasdas",
        imageSrc: ""
      }, {
        name: "asa45645sdasddas",
        imageSrc: ""
      }, {
        name: "asasda6sdasdas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      }, {
        name: "asas6dasddas",
        imageSrc: ""
      }, {
        name: "asadas655555sdas",
        imageSrc: ""
      }, {
        name: "asa6sdasddas",
        imageSrc: ""
      }, {
        name: "a666sasdasdasdas",
        imageSrc: ""
      }, {
        name: "asasdas6ddas",
        imageSrc: ""
      }, {
        name: "asasdasddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas",
        imageSrc: ""
      }, {
        name: "as66asdasdda66666666666s",
        imageSrc: ""
      }, {
        name: "asasdas6987dasdas",
        imageSrc: ""
      }, {
        name: "asas6dasddas",
        imageSrc: ""
      }, {
        name: "asasda666sddas",
        imageSrc: ""
      }, {
        name: "asasdasdasdas66",
        imageSrc: ""
      }
    ];
    // $scope.list = list;
    $scope.list = Data.queryArtists();
    $scope.limit = 20;

    $scope.onSearchChange = function() {
      $scope.limit = 20;
    }

    $scope.infiniteScroll = function() {
      $scope.limit += 10;
    }
  }
});
