'use strict';
var activityMainController = angular.module('activityMainController', ['activityServices']);
activityMainController.controller('addActivityController', ['$scope', '$http', '$location', '$rootScope','activityService.js',
    function ($scope, $http, $location, $rootScope,activityService) {
        $scope.product = {};
        $scope.add = true;
        $scope.edit = false;
        $scope.addProduct = function (flowFiles) {
            activityService.save($scope.activity,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var productid = data.id;
                // set location
                flowFiles.opts.target = '/activityImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={Activityid:Activityid};
                flowFiles.upload();

                $rootScope.addSuccess = true;
                $location.path("ListActivity");

                $scope.$apply();


            });
        };


    }]);

activityMainController.controller('listActivityController', ['$scope', '$http', '$rootScope','activityService.js','$route','queryActivityService',
    function ($scope, $http, $rootScope,activityService,$route,queryActivityService) {

        activityService.query(function(data){

            $scope.activity = data;
        });


        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteActivity = function (id) {
            var answer = confirm("Do you want to delete the Activity?");
            if (answer) {
                activityService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }



    }]);

activityMainController.controller('editActivityController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','activityService.js',
    function ($scope, $http, $routeParams, $location, $rootScope,activityService) {
        $scope.add = false;
        $scope.edit = true;
        var id = $routeParams.id;
        $http.get("/activity/" + id).success(function (data) {
            $scope.activity = data;
        });

        $scope.editActivity = function (flowFiles) {
            //$http.put("/product", $scope.product).then(function () {
            ActivityService.update({id:$scope.activity.id},$scope.activity,function(data){
                var activityid = data.id;
                flowFiles.opts.target = '/activityImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={productid:productid};
                flowFiles.upload();
                $rootScope.editSuccess = true;
                $location.path("ListActivity");
                $scope.$apply();
            });
        }
    }]);