'use strict';
var activityMainController = angular.module('activityMainControllers', ['activityServices']);
activityMainController.controller('addActivityController', ['$scope', '$http', '$location', '$rootScope','activityService',
    function ($scope, $http, $location, $rootScope,activityService) {
        $scope.product = {};
        $scope.add = true;
        $scope.edit = false;
        $scope.addProduct = function () {
            activityService.save($scope.activity,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var Activityid = data.id;
                // set location
                //flowFiles.opts.target = '/activityImage/add';
                //flowFiles.opts.testChunks = false;
                //flowFiles.opts.query ={Activityid:Activityid};
                //flowFiles.upload();

                $rootScope.addSuccess = true;
                $location.path("List");

                $scope.$apply();


            });
        };



    }]);

activityMainController.controller('listActivityController', ['$scope', '$http', '$rootScope','activityService','$route',
    function ($scope, $http, $rootScope,activityService,$route) {

        activityService.query(function(data){

            $scope.activities = data;
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
zz
activityMainController.controller('editActivityController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','activityService',
    function ($scope, $http, $routeParams, $location, $rootScope,activityService) {
        $scope.add = false;
        $scope.edit = true;
        var id = $routeParams.id;
        $http.get("/activity/" + id).success(function (data) {
            $scope.activity = data;
        });

        $scope.editActivity = function (flowFiles) {
            //$http.put("/product", $scope.product).then(function () {
            activityService.update({id:$scope.activity.id},$scope.activity,function(data){
                var Activityid = data.id;
                flowFiles.opts.target = '/activityImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={Activityid:Activityid};
                flowFiles.upload();
                $rootScope.editSuccess = true;
                $location.path("ListActivity");
                $scope.$apply();
            });
        }
    }]);