package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_products")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String description;
    private BigDecimal stars;
    private Double weight ;
    private Double price ;
    private String image ;
    private BigDecimal discount ;
    private int views ;
    private LocalDateTime dateEndSale ;
    private String introduction ;
    @OneToMany(fetch=FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "products")
    private List<WishList> wishLists ;
    @OneToMany(mappedBy = "products")
    private List<OrderDetail> productDetails;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "product")
    private List<Inventory> inventories ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collections_id")
    private Collection collections ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart_Item> cartItems ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Review> reviews ;

}
