package com.lee.messageboard.controller;

import com.lee.messageboard.Message;
import com.lee.messageboard.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@ResponseBody
@Controller
//@RestController
public class MessageBoardController {
    @Autowired
    MessageRepository messageRepo;

//    @ResponseBody
//    @RequestMapping("/ping")
//    public String list(){
//        return "pong";
//    }
//
//    @RequestMapping("/list")
//    public String success(){
//        return "list";
//    }

    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable("id") Integer id){
//        Message msg = new Message();
//        msg.setId(3);
//        msg.setTitle("gz so hot");
//        msg.setContent("going~");
//        Message res = messageRepo.save(msg);
////                = messageRepo.getOne(id);

       Message msg = messageRepo.findById(id).get();
        return msg;
    }

    @GetMapping("/msg")
    public String insertMesage(Message msg){
        Message save = messageRepo.save(msg);
        return "front/message/list";
    }

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("hello","limq spring hello~");
        map.put("messages",messageRepo.findAll());
        System.out.println(messageRepo.findAll());

        for(Message msg:messageRepo.findAll()){
            System.out.println(msg.getId());
            System.out.println(msg.getContent());
            System.out.println(msg.getTitle());
        }
        return "front/message/list";
    }

}