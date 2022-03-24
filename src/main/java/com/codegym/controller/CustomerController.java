package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.insertWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
}
//package com.codegym.controller;
//
//import com.codegym.model.Customer;
//import com.codegym.service.ICustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class CustomerController {
//    @Autowired
//    private ICustomerService customerService;
//    @GetMapping("/customers/create")
//    public ModelAndView showCreateForm(){
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        Customer customer = new Customer();
//        modelAndView.addObject("customer",customer);
//        return modelAndView;
//    }
//    @PostMapping("/customers/create")
//    public ModelAndView create(@ModelAttribute("customer") Customer customer){
////        ModelAndView modelAndView = new ModelAndView("/customer/create");
////        String message="";
////        if(!customerService.insertWithStoredProcedure(customer)){
////            message = "Created successfully!";
////        } else {
////            message = "Create failed";
////        }
////        modelAndView.addObject("message",message);
//        customerService.insertWithStoredProcedure(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("message", "New customer created successfully");
//        return modelAndView;
//    }
//}
