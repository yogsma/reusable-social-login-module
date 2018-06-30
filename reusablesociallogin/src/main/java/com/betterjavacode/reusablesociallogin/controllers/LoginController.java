package com.betterjavacode.reusablesociallogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(Model model)
    {
        return "login";
    }

    @RequestMapping(value ="/socialloginhome", method = RequestMethod.GET)
    public String socialloginhome(Model model)
    {
        return "socialloginhome";
    }

    @RequestMapping(value="/socialloginsuccess", method= RequestMethod.GET)
    public String socialloginsuccess(Model model)
    {
        return "socialloginsuccess";
    }
}
