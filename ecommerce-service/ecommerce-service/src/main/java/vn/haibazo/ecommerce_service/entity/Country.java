package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;
import org.apache.kafka.common.record.UnalignedMemoryRecords;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_countries")
public class Country extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "name", nullable = false)
    private String name ;
    @Column(name = "state", nullable = false)
    private String state ;
    @Column(name="zipcode", nullable = false)
    private String zipCode ;
    @Column(name="icon", nullable = false)
    private String icon ;
    @OneToMany(mappedBy = "countrys" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Set<City> cities ;

    @OneToMany(mappedBy = "country")
    private List<State> states ;
}
