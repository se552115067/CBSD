package wat.service;

import wat.entity.Activity;
import wat.entity.Image;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
public interface ActivityService {
    List<Activity> getActivitys();
    Activity getActivity(Long id);
    Activity addActivity(Activity activity);
    Activity deleteActivity(Long id);
    Activity updateActivity(Activity activity);


    Activity addImage(Activity activity, Image image);
}
