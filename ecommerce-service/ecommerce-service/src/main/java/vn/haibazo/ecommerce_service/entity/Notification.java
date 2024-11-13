package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_notifications")
public class Notification extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String content ;

}