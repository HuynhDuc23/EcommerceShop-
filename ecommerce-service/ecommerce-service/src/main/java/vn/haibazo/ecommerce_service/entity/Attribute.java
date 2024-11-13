package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_attributes")
public class Attribute extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    @OneToMany(mappedBy = "attribute", fetch = FetchType.LAZY)
    private List<Product_Attribute> attributes_products ;
}
