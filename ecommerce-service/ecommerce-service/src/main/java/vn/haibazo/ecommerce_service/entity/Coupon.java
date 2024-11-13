package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "coupons")
public class Coupon extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String code;
    private String couponType ;
    private LocalDateTime couponStartDate ;
    private LocalDateTime couponEndDate ;
    private double couponMinSpend ;
    private double couponMaxSpend ;
    private String couponStatus ;
    @OneToMany(mappedBy = "coupon",fetch = FetchType.LAZY )
    private List<User_Coupon> couponLists ;

    @OneToOne(mappedBy = "coupon" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Order order ;

}
