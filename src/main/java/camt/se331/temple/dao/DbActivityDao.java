package camt.se331.temple.dao;

import camt.se331.temple.entity.Activity;
import camt.se331.temple.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dto on 2/9/2015.
 */

@Repository
public class DbActivityDao implements ActivityDao {
    @Autowired
    ActivityRepository activityRepository;
    @Override
    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    @Override
    public List<Activity> getActivitiesByName(String name) {
        return activityRepository.findByNameOrDescriptionContainingIgnoreCase(name,name);
    }


    @Override
    public Activity getActivity(Long id) {
        return activityRepository.findOne(id);
    }

    @Override
    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity deleteActivity(Activity activity) {
        activityRepository.delete(activity);
        activity.setId(null);
        return activity;
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityRepository.save(activity);
    }
}
