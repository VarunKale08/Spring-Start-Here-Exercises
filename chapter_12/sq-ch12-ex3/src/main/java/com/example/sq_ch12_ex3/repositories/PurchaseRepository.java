package com.example.sq_ch12_ex3.repositories;

import com.example.sq_ch12_ex3.models.Purchase;
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

    public void storeProducts(Purchase purchase){
        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";
        this.jdbcTemplate.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> getProducts(){

        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> rowMapper = (r, i) ->{
            Purchase purchaseObj = new Purchase();
            purchaseObj.setId(r.getInt("id"));
            purchaseObj.setPrice(r.getBigDecimal("price"));
            purchaseObj.setProduct(r.getString("product"));
            return purchaseObj;
        };

        return this.jdbcTemplate.query(sql, rowMapper);
    }

}
