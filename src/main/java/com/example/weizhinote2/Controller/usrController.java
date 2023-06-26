package com.example.weizhinote2.Controller;

import com.example.weizhinote2.Bean.usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.weizhinote2.Service.userService;

import java.util.List;

@RestController
@RequestMapping("/usr")
public class usrController {

    private userService usrService;
    @Autowired
    public usrController(userService usrService) {
        this.usrService = usrService;
    }

    @GetMapping("/login")
    public usr getUsr(){
        System.out.println("usrController getUsr");
        return usrService.getUsrById();
    }
}
