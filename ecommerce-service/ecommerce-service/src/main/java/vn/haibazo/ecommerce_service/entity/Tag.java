package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_tags")
public class Tag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "name")
    private String name ;
    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();


}
