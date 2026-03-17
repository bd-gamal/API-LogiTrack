package com.logitrack.repositories;

import com.logitrack.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategorie(String categorie);

    List<Product> findByPrixLessThan(Double prix);

    @Query("SELECT p FROM Product p WHERE p.stockAmount < :seuil")
    List<Product> findProduitsStockFaible(@Param("seuil") int seuil);

    @Query("SELECT ol.product FROM OrderLine ol GROUP BY ol.product ORDER BY SUM(ol.quantite) DESC LIMIT 1")
    Product findTopProduct();
}