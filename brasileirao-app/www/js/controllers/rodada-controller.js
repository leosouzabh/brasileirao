angular.module('brasileiraoApp')

.controller('RodadaController', function($scope, LocalStorage, StartApp, $state, $ionicBackdrop, $timeout, $localForage) {
    
    init();
    
    $scope.next = function(){
        $scope.rodadaAtual++;
    }
    $scope.back = function(){
        $scope.rodadaAtual--;
    }
    
    $scope.$watch('rodadaAtual', function(){
        if ($scope.todasRodadas){            
            $scope.rodadas = $scope.todasRodadas.filter(function(rodadaItm){
                return rodadaItm.rodada == $scope.rodadaAtual;
            });
        }
        
    })
        
    
    function init(){
        
        LocalStorage.getRodada()
            .then(function(rodadas){
                $scope.todasRodadas = rodadas;
                return LocalStorage.getRodadaAtual();
            })
            .then(function(rodadaAtual){
                $scope.rodadaAtual = rodadaAtual;
            })
    }
    
    
})
