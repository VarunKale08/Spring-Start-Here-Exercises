package com.example.sq_ch12_ex1.repositories;

import com.example.sq_ch12_ex1.models.Purchase;
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

    public void storeProduct(Purchase purchase){
//        String query = "INSERT INTO purchase VALUES(NULL, ?, ?)";
        String query = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        jdbcTemplate.update(query, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> finadAllPurchases() {

        String query = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseMapper = (r, i) -> {
            Purchase getRowObject = new Purchase();
            getRowObject.setId(r.getInt("id"));
            getRowObject.setProduct(r.getString("product"));
            getRowObject.setPrice(r.getBigDecimal("price"));
            return getRowObject;
        };

        return this.jdbcTemplate.query(query, purchaseMapper);

    }
}
