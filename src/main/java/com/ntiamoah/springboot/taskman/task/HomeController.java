package com.ntiamoah.springboot.taskman.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dntiamoah on 17/05/2018.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
