package br.com.emmanuelneri.aws.samples.producer.controller;

import br.com.emmanuelneri.aws.samples.producer.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
@Slf4j
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/myMessage",method = RequestMethod.GET)
    public void sendMessageObject(){
        messageService.sentMyMessage();
    }
}
