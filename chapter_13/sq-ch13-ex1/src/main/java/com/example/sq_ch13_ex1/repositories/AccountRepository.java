package com.example.sq_ch13_ex1.repositories;

import com.example.sq_ch13_ex1.models.Account;
import com.example.sq_ch13_ex1.repositories.mappers.AccountRowMapper;
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

        public Account findAccountByIds(long id){
            String sql= "SELECT * FROM account WHERE id= ?";
            return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
        }

        public void changeAmount(long id, BigDecimal amount){
            String sql ="UPDATE account SET amount=? WHERE id=?";
            jdbcTemplate.update(sql, amount, id);
        }

        public List<Account> findAllAccount(){
            String sql= "SELECT * FROM account";
            return jdbcTemplate.query(sql, new AccountRowMapper());
        }

}
