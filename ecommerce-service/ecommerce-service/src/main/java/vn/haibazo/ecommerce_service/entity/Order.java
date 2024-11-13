package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice;
    private String status;
    private String note;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User users;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<OrderDetail> orderDetails;
    @OneToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon ;
}

