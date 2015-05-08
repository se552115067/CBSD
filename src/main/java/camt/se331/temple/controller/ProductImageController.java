package camt.se331.temple.controller;

import camt.se331.temple.entity.Image;
import camt.se331.temple.entity.Activity;
import camt.se331.temple.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by Dto on 4/27/2015.
 */
@Controller
@RequestMapping("/productImage")
public class ProductImageController {
    @Autowired
    ActivityService activityService;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Activity addImage(HttpServletRequest request,
                            HttpServletResponse response,@RequestParam("productid")Long productId){
        MultipartHttpServletRequest mRequest;
        Activity activity = activityService.getActivity(productId);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Image image = new Image();
                image.setFileName(multipartFile.getName());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());;
                image.setCreated(Calendar.getInstance().getTime());
                activityService.addImage(activity,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return activity;
    }
}
