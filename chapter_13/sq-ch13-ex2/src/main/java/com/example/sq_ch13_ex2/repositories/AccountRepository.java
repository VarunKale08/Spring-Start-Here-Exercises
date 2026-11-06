package com.example.sq_ch13_ex2.repositories;

import com.example.sq_ch13_ex2.models.Account;
import com.example.sq_ch13_ex2.repositories.mappers.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public void changeAmount(long id, BigDecimal amount){
        String sql = "UPDATE account SET amount=? WHERE id=?";
        this.jdbcTemplate.update(sql, id, amount);
    }

    public Account finalAccountById(long id){
        String sql = "SELECT * FROM account WHERE id=?";
        return this.jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public List<Account> findAllAccounts(){
        String sql= "SELECT * FROM account";
        return this.jdbcTemplate.query(sql, new AccountRowMapper());
    }
}
