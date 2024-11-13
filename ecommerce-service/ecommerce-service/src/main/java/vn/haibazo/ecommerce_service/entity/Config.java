package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

@Table
@Entity(name = "tbl_configs")
public class Config extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "provider" , nullable = false)
    private String provider ;
    @Column(name = "name", nullable = false)
    private String name ;
    @Column(name = "icon")
    private String icon ;
    @Column(name = "link")
    private String link ;

}
