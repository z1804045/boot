package itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class QuickController {

    //@RequestMapping("/quick")
    //@ResponseBody
    @GetMapping("/quick")
    public String quick(){
        return "nihao springBoot";
    }
}
