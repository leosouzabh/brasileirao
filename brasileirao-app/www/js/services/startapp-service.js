angular.module('brasileiraoApp')

.factory('StartApp', function(Tabela, $q, LocalStorage, Rodada) {
    
    return {
        start: function() {            
            console.log('iniciando app');
            
            var deferred = $q.defer();
            
            var rodadaAtual = null;
            Tabela.query().$promise
                .then(function(result){
                    console.log('1');
                    LocalStorage.setTabela(result);
                })
                .then(function(){
                    console.log('2');
                    return Rodada.get().$promise;    
                })            
                .then(function(result){
                    console.log('3');
                    LocalStorage.setRodada(result.rodadas);
                    LocalStorage.setRodadaAtual(result.rodadaAtual);
                    rodadaAtual = result.rodadaAtual
                })
                .then(function(){
                    console.log('4');
                    deferred.resolve(rodadaAtual)
                })
            
            return deferred.promise;
        }
    };
});