package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_products_attributes")
public class Product_Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory ;
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute ;
}
