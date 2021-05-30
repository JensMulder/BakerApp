package JensMulder.project.bakerapp.core.models;

import JensMulder.project.bakerapp.core.models.base.DbModelBase;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User extends DbModelBase {
    @Column(unique = true)
    @Length(min = 3, max = 20)
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
    @Length(min = 3, max = 40)
    private String firstName;
    @Length(min = 3, max = 40)
    private String lastName;
    @Length(min = 8, max = 10)
    private String phoneNumber;

    // Address
    @Length(min = 3, max = 30)
    private String streetName;
    @Length(min = 3, max = 30)
    private String postalCode;
    private Integer houseNumber;
    @Length(max = 3)
    private String houseNumberExtra;
    @Length(min = 3, max = 30)
    private String province;

    @ManyToMany
    @JoinTable (name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "user",
        orphanRemoval = true,
        cascade = CascadeType.ALL
    )
    private Set<Order> orders;

    public User() {}

    public User(
            String username,
            String password,
            String email,
            String firstName,
            String lastName,
            String phoneNumber,
            String streetName,
            String postalCode,
            Integer houseNumber,
            String houseNumberExtra,
            String province,
            Set<Role> roles
    ) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.houseNumberExtra = houseNumberExtra;
        this.province = province;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberExtra() {
        return houseNumberExtra;
    }

    public void setHouseNumberExtra(String houseNumberExtra) {
        this.houseNumberExtra = houseNumberExtra;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return getUsername() + " " + getPassword() + " " + getEmail() + " " + getFirstName() + " " + getLastName();
    }
}
