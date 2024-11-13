package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_languages")
public class Language extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name="name", nullable = false)
    private String name ;
    @Column(name = "icon")
    private String icon ;


}
