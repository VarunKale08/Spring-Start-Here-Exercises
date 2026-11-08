package com.example.sq_ch14_ex1.repositories;

import com.example.sq_ch14_ex1.models.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {


    @Query("SELECT * FROM account WHERE name =:name")
    public List<Account> findAccountByNames(String name);

    @Modifying
    @Query("UPDATE account SET amount =:amount WHERE id =:id")
    public void changeAmount(BigDecimal amount, long id);

}
