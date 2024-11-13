package vn.haibazo.ecommerce_service.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_users")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private String firstName ;
    @Column(nullable = false)
    private String lastName ;
    @Column(nullable = false)
    private String email ;
    @Column(nullable = false)
    private String telephone ;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_users_posts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private Set<Post> posts ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Question> questions ;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "users")
    private List<Contact> contacts;
    @ManyToMany
    private List<Role> roles;
    @ManyToMany
    private List<Notification> notifications ;
    @OneToMany(mappedBy = "users" , cascade = CascadeType.ALL)
    private List<Address> address;
    @ManyToMany
    private List<Coupon> coupons;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<WishList> wishLists ;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Anwser> anwsers ;
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Order> orders ;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
    private List<User_Coupon> userCoupons ;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Cart_Item> cartItems ;
    @OneToMany(mappedBy = "users" , fetch = FetchType.LAZY)
    private List<Review> reviews ;
}
