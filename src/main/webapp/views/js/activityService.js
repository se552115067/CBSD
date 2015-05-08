'use strict'
var activityService = angular.module('activityServices',['ngResource']);

activityService.factory('activityService',function($resource){
    return $resource('/activity/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

activityService.service('totalCalService',function() {
    this.getTotalNetPrice = function (activities) {
        var output = 0.0;

        for (var index = 0; index < activities.length;index++) {
            var activity = activities[index];
            output += parseFloat(activity.netPrice);
        }
        return output;
    }
})

activityService.factory('queryActivityService',function($resource){
    return $resource('/getActivity/?name=:name',
        {query:{method:'GET',params:{name:''},isArray:true}

        });
})