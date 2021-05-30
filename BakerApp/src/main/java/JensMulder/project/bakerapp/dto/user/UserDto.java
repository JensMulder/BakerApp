package JensMulder.project.bakerapp.dto.user;

import JensMulder.project.bakerapp.core.models.Order;
import JensMulder.project.bakerapp.core.models.Role;
import JensMulder.project.bakerapp.dto.user.base.UserDtoBase;

import java.util.Set;

public class UserDto extends UserDtoBase {
    private Long id;
    private Set<Order> orders;
    private Set<Role> roles;

    public UserDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
