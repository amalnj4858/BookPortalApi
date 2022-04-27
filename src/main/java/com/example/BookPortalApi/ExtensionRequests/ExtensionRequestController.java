package com.example.BookPortalApi.ExtensionRequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "extensionRequests")
@CrossOrigin("*")
public class ExtensionRequestController {
    private ExtensionRequestService extensionRequestsService;

    @Autowired
    ExtensionRequestController(ExtensionRequestService extensionRequestsService){
        this.extensionRequestsService = extensionRequestsService;
    }

    @PostMapping
    public String createExtension(@RequestBody ExtensionRequests extensionRequest){
        return this.extensionRequestsService.addExtensionRequest(extensionRequest);
    }

}
