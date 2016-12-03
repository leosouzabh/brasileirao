// Ionic Starter App
// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('brasileiraoApp', [
    'ionic',
    'LocalForageModule',
    'ngResource'
])

// constants for app
.constant('API_URL', '../www/api/')

.config(function($localForageProvider) {
    $localForageProvider.config({
        name        : 'brasileirao', // name of the database and prefix for your data, it is "lf" by default
        version     : 1.0, // version of the database, you shouldn't have to use this
        storeName   : 'keyvaluepairs'
    });
})

.run(function($ionicPlatform) {
    $ionicPlatform.ready(function() {
        // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard for form inputs)
        if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
            cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
            cordova.plugins.Keyboard.disableScroll(true);
        }
        if (window.StatusBar) {
            StatusBar.styleDefault();
        }
    });
})



.config(function($stateProvider, $ionicConfigProvider, $urlRouterProvider) {
    
    
    $ionicConfigProvider.tabs.position('bottom'); //bottom
    
    $stateProvider
    
    .state('splash', {
        url: '/splash',
        templateUrl: 'templates/splash.html',
        controller: 'SplashController'        
    })
    
    .state('tab', {
        url: '/tab',
        abstract: true,
        templateUrl: 'templates/tabs.html'
    })
    
    .state('tab.tabela', {
        url: '/tab/tabela',
        views: {
            'tab-tabela': {
                templateUrl: 'templates/tab-tabela.html',
                controller: 'TabelaController'        
            }
        }
    })
    
    .state('tab.rodada', {
        url: '/tab/rodada',
        views: {
            'tab-rodada': {
                templateUrl: 'templates/tab-rodada.html',
                controller: 'RodadaController'        
            }
        }
    })
    
    // if none of the above states are matched, use this as the fallback
    $urlRouterProvider.otherwise('/splash');

});