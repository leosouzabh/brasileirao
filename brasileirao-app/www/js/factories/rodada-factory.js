angular.module('brasileiraoApp')
    
.factory('Rodada', function($resource, API_URL) {        
    var prefix = API_URL + 'rodada';
    return $resource(prefix + '/:id', { id: '@id' }, {});
});