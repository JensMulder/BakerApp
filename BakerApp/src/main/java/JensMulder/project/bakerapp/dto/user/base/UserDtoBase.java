package JensMulder.project.bakerapp.dto.user.base;

import JensMulder.project.bakerapp.core.models.Order;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class UserDtoBase {
    @Length(min = 3, max = 20)
    private String username;
    @Email
    private String email;
    private boolean active;
    private String roles;
    @Length(min = 3, max = 40)
    private String firstName;
    @Length(min = 3, max = 40)
    private String lastName;
    @Length(min = 8, max = 10)
    private String phoneNumber;

    @Length(min = 3, max = 30)
    private String streetName;
    @NotBlank
    private String postalCode;
    private Integer houseNumber;
    @Length(max = 5)
    private String houseNumberExtra;
    @Length(min = 3, max = 30)
    private String province;

    private Set<Order> orders;

    public UserDtoBase() {}

    public UserDtoBase(
            String username,
            String email,
            String roles,
            String firstName,
            String lastName,
            String phoneNumber,
            String streetName,
            String postalCode,
            Integer houseNumber,
            String houseNumberExtra,
            String province
    ) {
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;

        this.streetName = streetName;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.houseNumberExtra = houseNumberExtra;
        this.province = province;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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
}
