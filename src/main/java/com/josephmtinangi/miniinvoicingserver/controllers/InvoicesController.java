package com.josephmtinangi.miniinvoicingserver.controllers;

import com.josephmtinangi.miniinvoicingserver.models.Invoice;
import com.josephmtinangi.miniinvoicingserver.repositories.InvoiceRepository;
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
@RequestMapping(path = "/invoices")
public class InvoicesController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<?> index(Pageable pageable) {

        Page<Invoice> invoices = invoiceRepository.findAll(pageable);

        return Helper.createResponse(invoices, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<?> store(@ModelAttribute Invoice invoice) {

        Invoice newInvoice = invoiceRepository.save(invoice);

        return Helper.createResponse(newInvoice, HttpStatus.CREATED);
    }
}
