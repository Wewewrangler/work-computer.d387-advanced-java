package edu.wgu.d387_sample_code.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*************************************
     *              THINGS THAT NEED REPLACING
     *            1. PurchaseResponse
     *            2. placeOrder
     *            3. Purchase
     *            4. purchase
     *            5. placeOrder
     *            6.purchaseResponse
     *************************************/


     //todo ADD THE CORRECT PATH FOR "POSTMAPPING"
    @PostMapping("/welcome")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse messageService.placeOrder(purchase);

        return purchaseResponse;
    }
}
