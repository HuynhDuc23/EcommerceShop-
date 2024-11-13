package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_payment")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String paymentMethod ;
    @OneToOne(mappedBy = "payment" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Order order ;
}
