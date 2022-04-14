package com.example.BookPortalApi.Requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "requests")
@CrossOrigin("*")
public class RequestsController {
    private RequestsService requestsService;

    @Autowired
     RequestsController(RequestsService requestsService){
         this.requestsService = requestsService;
     }

     @PostMapping
    public String createRequest(@RequestBody Requests request){
        System.out.println(request);
        String result = this.requestsService.addRequest(request);
        return result;
     }
}
