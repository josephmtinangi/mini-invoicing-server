package com.josephmtinangi.miniinvoicingserver.repositories;

import com.josephmtinangi.miniinvoicingserver.models.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {
}
