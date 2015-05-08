package camt.se331.temple.service;

import camt.se331.temple.entity.Image;
import camt.se331.temple.entity.Activity;

import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface ActivityService {
    List<Activity> getActivities();
    Activity getActivity(Long id);
    Activity addActivity(Activity activity);
    Activity deleteActivity(Long id);
    Activity updateActivity(Activity activity);
    List<Activity> getActivitiesByName(String name);

    Activity addImage(Activity activity, Image image);
}
