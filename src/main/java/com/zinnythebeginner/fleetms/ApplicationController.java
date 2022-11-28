package com.zinnythebeginner.fleetms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApplicationController {
    @GetMapping("/index")
    public String home() {
        return "index";
    }
    @GetMapping("/hr")
    public String hr(){
        return"/hr/index";
    }
    @GetMapping("/accounts")
    public String account(){
        return "/account/index";
    }
    @GetMapping("/fleet")
    public String fleet(){
        return "/fleet/index";
    }
    @GetMapping("/payroll")
    public String payroll(){
        return "/payroll/index";
    }
    @GetMapping("/parameters")
    public String parameters(){
        return "/parameters/index";
    }
    @GetMapping("/helpdesk")
    public String helpdesk(){
        return "/helpdesk/index";
    }
    @GetMapping("/reports")
    public String report(){
        return "/report/index";
    }
    @GetMapping("/security")
    public String security(){
        return "/security/index";
    }



}
