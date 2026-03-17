package com.logitrack.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_lines")
@Data @NoArgsConstructor @AllArgsConstructor
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantite;

    // Plusieurs lignes de commande appartiennent à une seule commande
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore // Empêche la boucle infinie Order -> OrderLine -> Order en JSON
    private Order order;

    // Plusieurs lignes de commande peuvent faire référence au même produit
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}