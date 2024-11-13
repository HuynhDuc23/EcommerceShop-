package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_guests")
public class Guest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(nullable = false)
    private String fullName ;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String  image ;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "guests")
    private List<Question> questions ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guests")
    private List<Review> reviews ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guests")
    private List<Contact> contacts;

}
