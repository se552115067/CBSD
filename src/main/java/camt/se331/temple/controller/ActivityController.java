package camt.se331.temple.controller;

import camt.se331.temple.entity.Activity;
import camt.se331.temple.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@RestController
@RequestMapping("/")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "activity",method = RequestMethod.GET)
    public  List<Activity> list(){
        return activityService.getActivities();
    }


    @RequestMapping(value = "getActivity",method = RequestMethod.GET)
    public  List<Activity> getListByName(@RequestParam("name")String name){
        return activityService.getActivitiesByName(name);
    }
    @RequestMapping(value = "activity",method = RequestMethod.POST)
    public @ResponseBody Activity add(@RequestBody Activity activity, BindingResult bindingResult){
        return activityService.addActivity(activity);
    }

    @RequestMapping(value = "activity/{id}",method = RequestMethod.GET)
    public  Activity getActivity(@PathVariable("id") Long id){
        return activityService.getActivity(id);
    }

    @RequestMapping(value = "activity/{id}",method = RequestMethod.PUT)
    public  Activity edit(@PathVariable("id") Long id,@RequestBody Activity activity, BindingResult bindingResult){
        return activityService.updateActivity(activity);
    }

    @RequestMapping(value = "activity/{id}",method = RequestMethod.DELETE)
    public  Activity edit(@PathVariable("id") Long id){
        return activityService.deleteActivity(id);
    }
}
