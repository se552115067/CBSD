package wat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wat.dao.ActivityDAO;
import wat.entity.Activity;
import wat.entity.Image;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService{
@Autowired
ActivityDAO activityDAO;
    @Override
    public List<Activity> getActivitys() {
        return activityDAO.getActivitys();
    }

    @Override
    public Activity getActivity(Long id) {
        return activityDAO.getActivity(id);
    }

    @Override
    public Activity addActivity(Activity activity) {
        return activityDAO.addActivity(activity);
    }

    @Override
    public Activity deleteActivity(Long id) {
        Activity activity=activityDAO.getActivity(id);
        return activityDAO.deleteActivity(activity);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityDAO.updateActivity(activity);
    }



    @Override

    public Activity addImage(Activity activity, Image image) {
        activity.getImages().add(image);
        activityDAO.updateActivity(activity);
        return activity;
    }
}
