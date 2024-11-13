package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_categories")
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private Long parentId ;
    private String image ;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Collection> collections ;
}
