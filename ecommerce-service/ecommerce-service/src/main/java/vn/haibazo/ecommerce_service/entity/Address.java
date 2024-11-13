package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String displayName ;
    private String streetAddress ;
    private String  firstName ;
    private String lastName ;
    private String email ;
    private String phone ;
    private String city ;
    private String country;
    private String status ;
    private String zipCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User users ;
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "city_id")
    private City cities ;
}
