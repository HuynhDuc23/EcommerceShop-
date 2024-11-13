package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_posts")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "name", nullable = false)
    private String name ;
    @Column(name = "content", nullable = false)
    private String content;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "posts")
    private Set<User> users ;
}
