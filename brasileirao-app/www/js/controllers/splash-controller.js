angular.module('brasileiraoApp')

.controller('SplashController', function($scope, $rootScope, LocalStorage, StartApp, $state) {
    
    $scope.$on('$ionicView.enter', function(){
        console.log('ok');
        init();
    });
    
    
    function init(){
        StartApp.start().then(
            function(rodadaAtual){
                //$rootScope.rodadaAtual = rodadaAtual;
                $state.go('tab.tabela')
            }
        );
    }
})
