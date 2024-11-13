package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.concurrent.CancellationException;

@Entity
@Table(name = "tbl_collections")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String imageUrl ;
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category ;
    @OneToMany(mappedBy = "collections")
    private List<Product> products ;
}
