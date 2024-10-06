package edu.wgu.d387_sample_code.controller;


import edu.wgu.d387_sample_code.convertor.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//MIGHT HAVE TO REMOVE "/mainscreen"
@CrossOrigin("http://localhost:8080/mainscreen")
@RestController
@RequestMapping ("/api/message")    //todo ADD "(/----/----)"
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController (MessageService messageService) {
        this.messageService = messageService;
    }

    // END POINT that returns MULTIPLE messages
    @GetMapping("/welcome")
    public List<String> getMessage() {
        // uses RECURSION to call the service to retrieve messages as a JSON array
        return messageService.getMessage();
    }
}
