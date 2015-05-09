package camt.se331.temple.controller;

import camt.se331.temple.config.security.SecurityUser;
import camt.se331.temple.entity.Activity;
import camt.se331.temple.entity.SelectedProduct;
import camt.se331.temple.entity.QA;
import camt.se331.temple.service.QAService;
import camt.se331.temple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

/**
 * Created by Dto on 4/6/2015.
 */
@RestController
@RequestMapping("/qa")
@SessionAttributes({"currentQA"})
 public class QAController {

    @ModelAttribute("currentQA")
    public QA getCurrentQA(){
        QA qa = new QA();
        qa.setPurchaseDate(Calendar.getInstance().getTime());
        return qa;
    }
    @RequestMapping(value="/addToCart",method = RequestMethod.POST)
    public QA addProduct(@ModelAttribute("currentQA") QA qa,@RequestBody Activity activity, BindingResult bindingResult,Model model){

                return qaService.addSelectedProduct(qa, activity);
    }

    @RequestMapping(value="/updateCart",method = RequestMethod.POST)
    public QA updateCart(@RequestBody QA qa, BindingResult bindingResult,Model model){
        model.addAttribute("currentQA",qa);
        return qa;
    }

    @RequestMapping(value="/removeProduct",method = RequestMethod.POST)
    public QA removeProduct(@ModelAttribute("currentQA") QA qa,@RequestBody Activity activity, BindingResult bindingResult,Model model){
        SelectedProduct toRemove = null;
        for(SelectedProduct selectedProduct:qa.getSelectedProducts()){
            if (selectedProduct.getActivity().equals(activity)){
                toRemove = selectedProduct;
                break;
            }
        }
        qa.getSelectedProducts().remove(toRemove);
        return qa;
    }

    @Autowired
    UserService userService;

    @RequestMapping(value="/saveCart",method = RequestMethod.POST)
    public QA saveCart(@RequestBody QA qa){
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        qa = userService.addQA(securityUser, qa);
        return qa;
    }

    @RequestMapping(value="/emptyCart",method = RequestMethod.GET)
    public QA empty(Model model){
        model.addAttribute("currentQA",new QA());
        return new QA();
    }

    @Autowired
    QAService qaService;
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public QA getQA(@PathVariable("id") Long id){
        return qaService.findById(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public QA updateQA(@PathVariable("id")Long id,@RequestBody QA cart, BindingResult bindingResult){
        return qaService.addQA(cart);
    }


}
