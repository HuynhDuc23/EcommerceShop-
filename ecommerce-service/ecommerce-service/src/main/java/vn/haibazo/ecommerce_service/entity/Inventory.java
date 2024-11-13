package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@Entity
@Table(name = "tbl_inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product ;
    private int quantity;
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "inventory")
    private List<Product_Attribute> product_attributes ;
}
