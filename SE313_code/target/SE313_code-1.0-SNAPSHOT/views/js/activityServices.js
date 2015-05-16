'use strict'
var activityService = angular.module('activityServices',['ngResource']);

activityService.factory('activityService',function($resource){
    return $resource('/activity/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})
<<<<<<< HEAD
activityService.factory('deleteImgService',function($resource){
    return $resource('/imgcontrol/:id/:imgid', { id: '@_id',imgid: '@_imgid' }, {
        update: {
            method: 'DELETE' // this method issues a PUT request
        }});

})
=======
>>>>>>> 4e641d249dfedc80ad3a8e9e290e54f041169748
activityService.factory('queryActivityService',function($resource){
    return $resource('/getActivity/?name=:name',
        {query:{method:'GET',params:{name:''},isArray:true}

        });
})



