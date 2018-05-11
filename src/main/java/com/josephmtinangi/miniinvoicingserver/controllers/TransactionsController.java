package com.josephmtinangi.miniinvoicingserver.controllers;

import com.josephmtinangi.miniinvoicingserver.models.Transaction;
import com.josephmtinangi.miniinvoicingserver.repositories.TransactionRepository;
import com.josephmtinangi.miniinvoicingserver.utilities.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/transactions")
public class TransactionsController {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<?> index(Pageable pageable) {

        Page<Transaction> transactions = transactionRepository.findAll(pageable);

        return Helper.createResponse(transactions, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<?> store(@ModelAttribute Transaction transaction) {

        Transaction newTransaction = transactionRepository.save(transaction);

        return Helper.createResponse(newTransaction, HttpStatus.CREATED);
    }
}
