angular.module('brasileiraoApp')

.controller('TabelaController', function($scope, LocalStorage, StartApp, $state, $ionicBackdrop, $timeout) {
    
    init();
    
    $scope.doRefresh = function(){
        $timeout(function() {
            $scope.$broadcast('scroll.refreshComplete');
        }, 1000);
    }
    
    $scope.detalhes = function(time){
        console.log(time);
    }
    
    function init(){
        
        $ionicBackdrop.retain();
        $timeout(function() {
          $ionicBackdrop.release();
        }, 1000);
        
        LocalStorage.getTabela().then(function(tabela){
            $scope.tabela = tabela;
        })
    }
})
