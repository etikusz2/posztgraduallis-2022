package edu.bbte.bibliospring.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
    @GetMapping("/helloview")
    public String helloView(){
        return "hello";
    }

    @GetMapping("/helloview2")
    public ModelAndView forwardtoView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2.html");
        modelAndView.addObject("message", "Hello view!");
        return modelAndView;
    }
}
