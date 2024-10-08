//FROM PROFESSOR TIMESTAMP 6:40
package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin
@RequestMapping(“/api”)
public class MessageMapping {

    @RequestMapping(path = “/presentation”, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showPresentation() {
        String finalMessage = “third message example”;
        return new String[] {finalMessage};
    }
}
