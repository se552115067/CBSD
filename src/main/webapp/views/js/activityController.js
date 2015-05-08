'use strict';

var activityMainController = angular.module('activityMainController', ['activityServices','shoppingCartServices']);
activityMainController.controller('addActivityController', ['$scope', '$http', '$location', '$rootScope','activityService',
    function ($scope, $http, $location, $rootScope,activityService) {
        $scope.activity = {};
        $scope.addPerson = true;
        $scope.editPerson = false;
        $scope.addActivity = function (flowFiles) {


            activityService.save($scope.activity,function(data){
                // after adding the object, add a new picture
                // get the activity id which the image will be addded
                var activityid = data.id;
                // set location
                flowFiles.opts.target = '/activityImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={activityid:activityid};
                flowFiles.upload();

                $rootScope.addSuccess = true;
                $location.path("listActivity");
                $scope.$apply();
            });
        };


    }]);

activityMainController.controller('listActivityController', ['$scope', '$http', '$rootScope','activityService','$route','totalCalService','queryActivityService','cartManagement','$location',
    function ($scope, $http, $rootScope,activityService,$route,totalCalService,queryActivityService,cartManagement,$location) {
    //$http.get("/activity/").success(function (data) {
        var data = activityService.query(function(){
           // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
            $scope.activities = data;
        });


        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteActivity = function (id) {
            var answer = confirm("Do you want to delete the activity?");
            if (answer) {
                activityService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }

        $scope.searchActivity = function(name){
           queryActivityService.query({name:name},function(data) {
                $scope.activities = data;
            });
        }

        $scope.addToCart = function(activity){
            activity.images = null;
            cartManagement.addToCart(activity,function(shoppingCart){
                            //success event
                            $rootScope.shoppingCart = shoppingCart;
                $location.path("shoppingCart")

            },function(event){
                                // fail event
                                            })

                    }


    }]);

activityMainController.controller('editActivityController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','activityService',
    function ($scope, $http, $routeParams, $location, $rootScope,activityService) {
        $scope.addPerson = false;
        $scope.editPerson = true;
        var id = $routeParams.id;
        $http.get("/activity/" + id).success(function (data) {
            $scope.activity = data;
        });

        $scope.editActivity = function () {
            //$http.put("/activity", $scope.activity).then(function () {
            activityService.update({id:$scope.activity.id},$scope.activity,function(){
                $rootScope.editSuccess = true;
                $location.path("listActivity");
            });
        }
    }]);