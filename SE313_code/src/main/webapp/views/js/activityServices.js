'use strict'
var activityService = angular.module('activityServices',['ngResource']);

activityService.factory('activityService',function($resource){
    return $resource('/activity/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})
activityService.factory('queryActivityService',function($resource){
    return $resource('/getActivity/?name=:name',
        {query:{method:'GET',params:{name:''},isArray:true}

        });
})



