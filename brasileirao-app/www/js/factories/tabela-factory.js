angular.module('brasileiraoApp')
    
    .factory('Tabela', function($resource, API_URL) {
        
        var prefix = API_URL + 'tabela';

        function customEvents() {
            return {
                'patch': {
                    method: 'PATCH'
                }
            }
        }
        
        return $resource(prefix + '/:id', { id: '@id' }, customEvents());
    });