package vn.anhdoan.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "carts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    double sum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @OneToMany(mappedBy = "cart")
    List<CartDetail> cartDetails;

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

}
