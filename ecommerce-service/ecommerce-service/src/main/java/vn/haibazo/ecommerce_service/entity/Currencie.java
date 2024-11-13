package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_currencies")
public class Currencie extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "name" , nullable = false)
    private String name ;
    @Column(name = "icon", nullable = false)
    private String icon;

}
