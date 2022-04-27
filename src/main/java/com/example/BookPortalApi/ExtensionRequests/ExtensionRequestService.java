package com.example.BookPortalApi.ExtensionRequests;

import com.example.BookPortalApi.Transactions.TransactionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ExtensionRequestService {

    private ExtensionRequestsRepository extensionRequestsRepository;
    private  TransactionsRepository transactionsRepository;

    ExtensionRequestService(ExtensionRequestsRepository extensionRequestsRepository, TransactionsRepository transactionsRepository){
        this.extensionRequestsRepository = extensionRequestsRepository;
        this.transactionsRepository = transactionsRepository;
    }


@Transactional
    public String addExtensionRequest(ExtensionRequests extensionRequest) {
        Optional<ExtensionRequests> request = this.extensionRequestsRepository.findFirstByBook_idEqualsAndUser_idEquals(extensionRequest.getUser_id(), extensionRequest.getBook_id());
        if(request.isPresent()){
            return "You cannot request an extension for a book more than once.";
        }
        this.extensionRequestsRepository.save(extensionRequest);
        this.transactionsRepository.extendDate(extensionRequest.getTransaction_id(),extensionRequest.getExtendedDate());
        return "Success! You have received an extension for 15 days";
    }
}
