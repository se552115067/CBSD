'use strict';

var qaControllers = angular.module('qaControllers', ['qaServices']);

qaControllers.controller('showQAController',
    ['$scope', 'cartManagement', '$location', '$rootScope','$routeParams',
        function ($scope, cartManagement, $location, $rootScope,$rootParams) {
            if ($rootScope.qa != null){
            $scope.cart = $rootScope.qa;
        }else {
            var id = $rootParams.id;
            qaService.get({id: id}, function (data) {
                $scope.cart = data;
            })
        }

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.cartUpdateSuccess = false;

        });

            $scope.updateCart = function (cart) {
                cartManagement.updateCart(cart, function () {
                    $rootScope.cartUpdateSuccess = true;

                });
            }

            $scope.removeProduct = function (product) {
                cartManagement.removeProduct(product, function (newCart) {
                    $scope.cart = newCart;
                })
            }

            $scope.saveCart = function(cart){
                cartManagement.saveCart(cart,function(){
                                //success add cart
                                console.log("save cart success");
                })
            }





        $scope.totalEach = function(index){
            return $scope.cart.selectedProducts[index].product.totalPrice * $scope.cart.selectedProducts[index].amount;
        }

        $scope.total = function(){
            var total = 0;
            angular.forEach($scope.cart.selectedProducts, function(item) {
                total += item.amount * item.product.totalPrice;
            })

            return total;
        }
    }]);
