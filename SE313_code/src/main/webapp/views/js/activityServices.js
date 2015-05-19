'use strict'
var activityService = angular.module('activityServices',['ngResource']);

activityService.factory('activityService',function($resource){
        return $resource('/wat/activity/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

activityService.factory('deleteImgService',function($resource){
    return $resource('/wat/imgcontrol/:id/:imgid', { id: '@_id',imgid: '@_imgid' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})


activityService.factory('queryActivityService',function($resource){
    return $resource('/wat/getActivity/?name=:name',
        {query:{method:'GET',params:{name:''},isArray:true}

        });
})



