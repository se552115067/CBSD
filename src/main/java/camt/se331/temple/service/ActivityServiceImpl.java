package camt.se331.temple.service;

import camt.se331.temple.dao.ActivityDao;
import camt.se331.temple.entity.Image;
import camt.se331.temple.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityDao activityDao;
    @Override
    public List<Activity> getActivities() {
        return activityDao.getActivities();
    }



    @Override
    public Activity getActivity(Long id) {
        return activityDao.getActivity(id);
    }

    @Override
    public Activity addActivity(Activity activity) {
        return activityDao.addActivity(activity);
    }

    @Override
    public Activity deleteActivity(Long id) {
        Activity activity = getActivity(id);
        return activityDao.deleteActivity(activity);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityDao.updateActivity(activity);
    }

    @Override
    public List<Activity> getActivitiesByName(String name) {
        return activityDao.getActivitiesByName(name);
    }

    @Override
    @Transactional
    public Activity addImage(Activity activity, Image image) {
        activity.getImages().add(image);
        activityDao.updateActivity(activity);
        return activity;
    }
}
