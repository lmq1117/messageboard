package com.lee.messageboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageBoardController {
    @ResponseBody
    @RequestMapping("/ping")
    public String list(){
        return "pong";
    }

    @RequestMapping("/list")
    public String success(){
        return "list";
    }

}