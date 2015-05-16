'use strict';

// Declare app level module which depends on views, and components
var watApp = angular.module('watApp', [
    'ngRoute',
    'ngAnimate',
    'homeControllers',
    'securityControllers',
    'flow',
    'activityMainControllers',
    'questionMainControllers'
])
watApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/home',{
                templateUrl: 'template/home.html',
                controller: 'homeController'
            }).
            when('/List',{
                templateUrl: 'template/acitivitylist.html',
                controller: 'listActivityController'
            }).when('/activity/:id',{
                templateUrl: 'template/activity.html',
                controller: 'editActivityController'
            }).when('/add',{
                templateUrl: 'template/addActivity.html',
                controller: 'addActivityController'
            }).when('/edit/:id',{
                templateUrl: 'template/addActivity.html',
                controller: 'editActivityController'
            }).when('/question',{
                templateUrl: 'template/questionList.html',
                controller: 'listQuestionController'
            }).when('/question/:id',{
            templateUrl: 'template/answerQuestion.html',
            controller: 'editQuestionController'
        }).
            otherwise({redirectTo: '/home'});
    }]);


watApp.config(['$locationProvider', '$httpProvider', function($locationProvider, $httpProvider){
    /* Register error provider t    hat shows message on failed requests or redirects to login page on
     * unauthenticated requests */
    $httpProvider.interceptors.push(function($q,$rootScope,$location){
        return {
            'responseError': function(rejection){
                var status = rejection.status;
                var config = rejection.config;
                var method = config.method;
                var url = config.url;

                if (status == 401){
                    $location.path("/home");
                }else{
                    $rootScope.error = method + " on " + url + " failed with status " + status;
                }
                return $q.reject(rejection);
            }
        }
    });

    /* Registers auth token interceptor, auth token is either passed by header or by query parameter
     * as soon as there is an authenticated user */
    var exampleAppConfig = {
        /* When set to false a query parameter is used to pass on the auth token.
         * This might be desirable if headers don't work correctly in some
         * environments and is still secure when using https. */
        useAuthTokenHeader: true
    };

    $httpProvider.interceptors.push(function ($q,$rootScope,$location){
        return {
            'request' : function(config){
                if (angular.isDefined($rootScope.authToken)){
                    var authToken = $rootScope.authToken;
                    if (exampleAppConfig.useAuthTokenHeader){
                        config.headers['X-Auth-Token'] = authToken;
                    }else{
                        config.url = config.url + "?token=" + authToken;
                    }
                }
                return config || $q.when(config);
            }

        }
    })

}]).run(function($rootScope,$location,$cookieStore,UserService){
    $rootScope.$on('$viewContentLoaded',function(){
        delete $rootScope.error;
    });

    $rootScope.hasRole = function(role) {
        if ($rootScope.user == undefined){
            return false;
        }

        if ($rootScope.user.roles[role] == undefined){
            return false;
        }

        return $rootScope.user.roles[role];
    }

    $rootScope.logout = function() {
        delete $rootScope.user;
        delete $rootScope.authToken;
        $cookieStore.remove('authToken');
        $location.path("/home")
    }

    /* Try getting valid user from cookie or go to login page */
    var originalPath = $location.path();
    $location.path("/home");
    var authToken = $cookieStore.get('authToken');
    if (authToken != undefined){
        $rootScope.authToken = authToken;
        UserService.get(function(user){
            $rootScope.user = user;
            $location.path(originalPath);
        })
    }
    $rootScope.initialized = true;
});
watApp.config(['flowFactoryProvider', function (flowFactoryProvider) {
    flowFactoryProvider.defaults = {
        target: '',
        permanentErrors: [ 500, 501],
        maxChunkRetries: 1,
        chunkRetryInterval: 5000,
        simultaneousUploads: 4,
        singleFile: false
    };
    flowFactoryProvider.on('catchAll', function (event) {
        console.log('catchAll', arguments);
    });
    // Can be used with different implementations of Flow.js
    // flowFactoryProvider.factory = fustyFlowFactory;
}]);