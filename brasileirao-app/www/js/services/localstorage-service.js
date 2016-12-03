angular.module('brasileiraoApp')
    
.service('LocalStorage', function($localForage, $q) {
    var OBJECT_NAMES = {
        TABELA: 'tabela',
        RODADA: 'rodada',
        RODADA_ATUAL: 'rodada_atual'
    };

    function get(objectName) {
        var deferred = $q.defer();
        $localForage.getItem(objectName)
            .then(function(data) {
                deferred.resolve(data);
            })
            .catch(function() {
                deferred.reject();
            });
        return deferred.promise;
    }
    
    function set(objectName, value){
        $localForage.setItem(objectName, value);
    }

    return {
        getTabela: function() {
            return get(OBJECT_NAMES.TABELA);
        },
        setTabela: function(tabela) {
            return set(OBJECT_NAMES.TABELA, tabela);
        },
        
        getRodada: function() {
            return get(OBJECT_NAMES.RODADA);
        },
        setRodada: function(tabela) {
            return set(OBJECT_NAMES.RODADA, tabela);
        },
        
        getRodadaAtual: function() {
            return get(OBJECT_NAMES.RODADA_ATUAL);
        },
        setRodadaAtual: function(rodadaAtual) {
            return set(OBJECT_NAMES.RODADA_ATUAL, rodadaAtual);
        }
    }
});
