package camt.se331.temple.dao;

import camt.se331.temple.entity.Activity;

import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface ActivityDao {
    List<Activity> getActivities();
    List<Activity> getActivitiesByName(String name);
    Activity getActivity(Long id);
    Activity addActivity(Activity activity);
    Activity deleteActivity(Activity activity);
    Activity updateActivity(Activity activity);

}
