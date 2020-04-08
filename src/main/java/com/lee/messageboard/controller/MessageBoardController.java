package com.lee.messageboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MessageBoardController {
    @RequestMapping("/ping")
    public String list(){
        return "pong";
    }
}
