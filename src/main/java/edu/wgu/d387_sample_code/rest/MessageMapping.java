package edu.wgu.d387_sample_code.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageMapping {
    // new code for webinar
    @RequestMapping(path ="/presentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showPresentation(){
        String finalMessage= "Join us for an online live presentation-message 3";
        return finalMessage;
    }
}
