angular.module('brasileiraoApp')

.controller('DashCtrl', function($scope, $localForage) {
    //$localForage.setItem('teste', {id:1, nome:'leo souza bh'});
    
    $scope.times = [
        {id:1, nome:'Palmeiras', j:36, vit:22, emp:8,  der:6,  gp:59, gc:31, sg:28, pt:74},
        {id:2, nome:'Santos',    j:36, vit:21, emp:5,  der:10, gp:58, gc:33, sg:25, pt:68},
        {id:3, nome:'Flamengo',  j:36, vit:19, emp:10, der:7,  gp:50, gc:35, sg:15, pt:67},
        {id:4, nome:'Palmeiras', j:36, vit:22, emp:8,  der:6,  gp:59, gc:31, sg:28, pt:74},
        {id:5, nome:'Santos',    j:36, vit:21, emp:5,  der:10, gp:58, gc:33, sg:25, pt:68},
        {id:6, nome:'Flamengo',  j:36, vit:19, emp:10, der:7,  gp:50, gc:35, sg:15, pt:67}        
    ]
    
})

.controller('ChatsCtrl', function($scope, Chats) {
    // With the new view caching in Ionic, Controllers are only called
    // when they are recreated or on app start, instead of every page change.
    // To listen for when this page is active (for example, to refresh data),
    // listen for the $ionicView.enter event:
    //
    //$scope.$on('$ionicView.enter', function(e) {
    //});

    $scope.chats = Chats.all();
    $scope.remove = function(chat) {
        Chats.remove(chat);
    };
})

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
    $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
    $scope.settings = {
        enableFriends: true
    };
});