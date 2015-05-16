/**
 * Created by P-OniSawa on 15/5/2558.
 */
'use strict'
var historyService = angular.module('historyServices',['ngResource']);

historyService.factory('historyService',function($resource){
    return $resource('/history/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})
