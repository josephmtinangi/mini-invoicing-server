package com.josephmtinangi.miniinvoicingserver.repositories;

import com.josephmtinangi.miniinvoicingserver.models.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
}
