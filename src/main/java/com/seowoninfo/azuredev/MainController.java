package com.seowoninfo.azuredev;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * FileName    : IntelliJ IDEA
 * Author      : Seowon
 * Date        : 2025-02-24
 * Description :
 */
@Controller
public class MainController {

    @Value("${spring.profiles.active}") private String PROP;


    @GetMapping("/main")
    public String main(Model model) {

        model.addAttribute("prop", PROP);

        System.out.println("PROP================================= " + PROP);

        return "main";
    }

}
