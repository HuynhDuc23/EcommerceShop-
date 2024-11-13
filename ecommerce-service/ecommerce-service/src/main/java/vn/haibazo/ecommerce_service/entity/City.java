package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_citys")
public class City extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country countrys ;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cities")
    private List<Address> addresses ;
}
