package com.example.itplanet.repository;

import com.example.itplanet.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    String FILTER_BY_FIELDS = "SELECT * FROM account a WHERE "
            + "(:firstName IS NULL OR a.first_name like %:firstName%) "
            + "AND (:lastName IS NULL OR a.last_name like %:lastName%) "
            + "AND (:email IS NULL OR a.email like %:email%)";

    @Query(value = FILTER_BY_FIELDS,nativeQuery = true)
    Page<Account> findAccountsByFirstNameLastNameEmail(
            String firstName, String lastName, String email, Pageable pageable);

    @Query(nativeQuery = true,value = "SELECT * FROM account WHERE email = ?1")
    Account findAccountByEmail(String email);

    Account findAccountByEmailAndPassword(String email,String password);

}
