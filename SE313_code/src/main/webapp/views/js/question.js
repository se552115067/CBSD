/**
 * Created by Punjasin on 5/15/2015.
 */
'use strict';
var questionMainController = angular.module('questionMainControllers', ['questionServices']);
questionMainController.controller('addquestionController', ['$scope', '$http', '$location', '$rootScope','questionService',
    function ($scope, $http, $location, $rootScope,activityService) {
        $scope.question = {};
        $scope.add = true;
        $scope.edit = false;
        $scope.addQuestion = function () {
            questionService.save($scope.question,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var Activityid = data.id;
                // set location

                $rootScope.addSuccess = true;
                $location.path("question");

                $scope.$apply();


            });
        };


    }]);

questionMainController.controller('listquestionController', ['$scope', '$http', '$rootScope','questionService','$route',
    function ($scope, $http, $rootScope,activityService,$route) {

        activityService.query(function(data){

            $scope.question = data;
        });


        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.add = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteQuestion = function (id) {
            var answer = confirm("Do you want to delete the question?");
            if (answer) {
                activityService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }



    }]);

activityMainController.controller('editActivityController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','activityService',
    function ($scope, $http, $routeParams, $location, $rootScope,activityService) {
        $scope.add = false;
        $scope.edit = true;
        var id = $routeParams.id;
        $http.get("/wat/activity/" + id).success(function (data) {
            $scope.activity = data;
        });

        $scope.editActivity = function (flowFiles) {
            //$http.put("/product", $scope.product).then(function () {
            activityService.update({id:$scope.activity.id},$scope.activity,function(data){
                var Activityid = data.id;
                flowFiles.opts.target = '/wat/activityImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={Activityid:Activityid};
                flowFiles.upload();
                $rootScope.editSuccess = true;
                $location.path("ListActivity");
                $scope.$apply();
            });
        }
    }]);