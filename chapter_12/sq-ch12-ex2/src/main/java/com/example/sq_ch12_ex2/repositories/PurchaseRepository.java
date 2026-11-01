package com.example.sq_ch12_ex2.repositories;

import com.example.sq_ch12_ex2.models.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchaseRecord(Purchase purchase){
        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";
        this.jdbcTemplate.update(sql, purchase.getProduct(), purchase.getPrice());
    }


    public List<Purchase> getPurchaseRecords(){

        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> getRecordList = (r,i) ->{
            Purchase getRecord = new Purchase();
            getRecord.setId(r.getInt("id"));
            getRecord.setProduct(r.getString("product"));
            getRecord.setPrice(r.getBigDecimal("price"));
            return getRecord;
        };

        return this.jdbcTemplate.query(sql, getRecordList);
    }
}
