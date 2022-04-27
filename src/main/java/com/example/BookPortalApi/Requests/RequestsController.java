package com.example.BookPortalApi.Requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "requests")
@CrossOrigin("*")
public class RequestsController {
    private RequestsService requestsService;

    @Autowired
     RequestsController(RequestsService requestsService){
         this.requestsService = requestsService;
     }

    @GetMapping
    @ResponseBody
    public List<Requests> getRequests(@RequestParam int id){
        return this.requestsService.getRequestsToUser(id);
    }

    @GetMapping(path = "getAllRequests")
    @ResponseBody
    public List<Requests> getAllRequests(){
        return this.requestsService.fetchAllRequests();
    }

     @PostMapping
    public String createRequest(@RequestBody Requests request){
        String result = this.requestsService.addRequest(request);
        return result;
     }


}
