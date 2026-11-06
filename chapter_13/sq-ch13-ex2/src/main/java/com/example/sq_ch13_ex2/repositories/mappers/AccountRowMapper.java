package com.example.sq_ch13_ex2.repositories.mappers;

import com.example.sq_ch13_ex2.models.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException{
        Account a = new Account();
        a.setId(resultSet.getLong("id"));
        a.setAmount(resultSet.getBigDecimal("amount"));
        a.setName(resultSet.getString("name"));
        return a;
    }
}
