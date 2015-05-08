package camt.se331.temple.controller;

import camt.se331.temple.config.security.SecurityUser;
import camt.se331.temple.entity.Activity;
import camt.se331.temple.entity.SelectedProduct;
import camt.se331.temple.entity.ShoppingCart;
import camt.se331.temple.service.ShoppingCartService;
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
@RequestMapping("/shoppingcart")
@SessionAttributes({"currentShoppingCart"})
 public class ShoppingCartController {

    @ModelAttribute("currentShoppingCart")
    public ShoppingCart getCurrentShoppingCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setPurchaseDate(Calendar.getInstance().getTime());
        return shoppingCart;
    }
    @RequestMapping(value="/addToCart",method = RequestMethod.POST)
    public ShoppingCart addProduct(@ModelAttribute("currentShoppingCart") ShoppingCart shoppingCart,@RequestBody Activity activity, BindingResult bindingResult,Model model){

                return shoppingCartService.addSelectedProduct(shoppingCart, activity);
    }

    @RequestMapping(value="/updateCart",method = RequestMethod.POST)
    public ShoppingCart updateCart(@RequestBody ShoppingCart shoppingCart, BindingResult bindingResult,Model model){
        model.addAttribute("currentShoppingCart",shoppingCart);
        return shoppingCart;
    }

    @RequestMapping(value="/removeProduct",method = RequestMethod.POST)
    public ShoppingCart removeProduct(@ModelAttribute("currentShoppingCart") ShoppingCart shoppingCart,@RequestBody Activity activity, BindingResult bindingResult,Model model){
        SelectedProduct toRemove = null;
        for(SelectedProduct selectedProduct:shoppingCart.getSelectedProducts()){
            if (selectedProduct.getActivity().equals(activity)){
                toRemove = selectedProduct;
                break;
            }
        }
        shoppingCart.getSelectedProducts().remove(toRemove);
        return shoppingCart;
    }

    @Autowired
    UserService userService;

    @RequestMapping(value="/saveCart",method = RequestMethod.POST)
    public ShoppingCart saveCart(@RequestBody ShoppingCart shoppingCart){
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        shoppingCart = userService.addShoppingCart(securityUser, shoppingCart);
        return shoppingCart;
    }

    @RequestMapping(value="/emptyCart",method = RequestMethod.GET)
    public ShoppingCart empty(Model model){
        model.addAttribute("currentShoppingCart",new ShoppingCart());
        return new ShoppingCart();
    }

    @Autowired
    ShoppingCartService shoppingCartService;
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ShoppingCart getShoppingCart(@PathVariable("id") Long id){
        return shoppingCartService.findById(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ShoppingCart updateShoppingCart(@PathVariable("id")Long id,@RequestBody ShoppingCart cart, BindingResult bindingResult){
        return shoppingCartService.addShoppingCart(cart);
    }


}
