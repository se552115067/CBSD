'use strict'
var qaServices = angular.module('qaServices',['ngResource']);
qaServices.factory('qaService',function($resource){
    return $resource('/qa/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})


qaServices.factory('cartManagement',function($resource) {
    return $resource('/qa/:action', {}, {
        addToCart: {
            method: 'POST',
            params: {'action': 'addToCart'}
        },
        updateCart: {
            method: 'POST',
            params: {'action': 'updateCart'}
        },
        removeProduct: {
            method: 'POST',
            params: {'action': 'removeProduct'}
        },
        saveCart: {
            method: 'POST',
            params: {'action': 'saveCart'}
        },
        emptyCart: {
            method: 'GET',
            params: {'action': 'emptyCart'}
        }
})
})