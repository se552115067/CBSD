/**
 * Created by P-OniSawa on 15/5/2558.
 */
'use strict';
var historyController = angular.module('historyControllers', ['historyServices']);

historyController.controller('showHistoryController', ['$scope', '$http', '$rootScope','historyService','$route',
    function ($scope, $http, $rootScope,historyService,$route) {

        historyService.query(function(data){
            $scope.historys = data;
        });


    }]);

historyController.controller('editHistoryController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','historyService',
    function ($scope, $http, $routeParams, $location, $rootScope,historyService) {
        $scope.edit = true;
        var id = $routeParams.id;
        $http.get("/history/" + id).success(function (data) {
            $scope.history = data;
        });

        $scope.editHistory = function () {
            //$http.put("/product", $scope.product).then(function () {
            historyService.update({id:$scope.history.id},$scope.history,function(data){
                $rootScope.editSuccess = true;
                $location.path("history");
            });
        }
    }]);