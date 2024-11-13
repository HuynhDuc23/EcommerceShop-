package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_users_coupons")
public class User_Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon ;
}
