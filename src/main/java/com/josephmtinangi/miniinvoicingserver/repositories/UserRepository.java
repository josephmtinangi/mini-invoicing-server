package com.josephmtinangi.miniinvoicingserver.repositories;

import com.josephmtinangi.miniinvoicingserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);
}
