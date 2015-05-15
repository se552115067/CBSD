package wat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wat.dao.ActivityDAO;
import wat.dao.ImageDAO;
import wat.entity.Image;
import wat.repository.ActivityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by Punjasin on 5/15/2015.
 */
@Service
@Transactional
public class imageServiceImpl implements ImageService {

    @Autowired
    ImageDAO imgdao;
    @Autowired
    ActivityRepository activityRepository;
    @Override
    public List<Image> getImages() {
        return imgdao.getImages();
    }

    @Override
    public Image getImg(Long id) {
        return imgdao.Get(id);
    }

    @Override
    public Image Update(Image img) {
        return imgdao.Update(img);
    }

    @Override
    public Image add(Image img) {
        return imgdao.add(img);
    }

    @Override
    public Image delete(Long imgid,Long activityid) {
        activityRepository.getOne(activityid).getImages().remove(imgdao.Get(imgid));
        Image temp=imgdao.Get(imgid);

        return imgdao.delete(temp);
    }
}
