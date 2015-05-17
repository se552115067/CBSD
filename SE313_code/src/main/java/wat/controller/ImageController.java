package wat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wat.entity.Activity;
import wat.entity.Image;
import wat.service.ImageService;

/**
 * Created by Punjasin on 5/15/2015.
 */
@RestController
public class ImageController {
    @Autowired
    ImageService imageService;
    @RequestMapping(value = "imgcontrol/{id}/{imgid}",method = RequestMethod.DELETE)
    public Image deleteimage(@PathVariable("id") Long id,@PathVariable("imgid") long imgid){

//        List<Image> temp=new ArrayList<Image>();
//        for (Image str : activityService.getActivity(id).getImages()) {
//            temp.add(str);
//        }
//        for(int i=0;i<temp.size();i++){
//            if(temp.get(i)==imageService.getImg(imgid)){
//
//                temp.set(i, null);
//                activityService.getActivity(id).getImages().clear();
//                activityService.getActivity(id).setImages(new HashSet<Image>(temp));
//                imageService.delete(imgid);
//            }
//        }

        return imageService.delete(imgid,id);
    }
    @RequestMapping(value = "historycontrol/{imgid}",method = RequestMethod.DELETE)
    public Image deletehistoryimage(@PathVariable("imgid") Long imgid){

//        List<Image> temp=new ArrayList<Image>();
//        for (Image str : activityService.getActivity(id).getImages()) {
//            temp.add(str);
//        }
//        for(int i=0;i<temp.size();i++){
//            if(temp.get(i)==imageService.getImg(imgid)){
//
//                temp.set(i, null);
//                activityService.getActivity(id).getImages().clear();
//                activityService.getActivity(id).setImages(new HashSet<Image>(temp));
//                imageService.delete(imgid);
//            }
//        }

        return imageService.deleteHistoryImg(imgid);
    }
}
