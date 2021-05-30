package JensMulder.project.bakerapp.dto.user;

import JensMulder.project.bakerapp.dto.user.base.UserDtoBase;

public class RegisterRequest extends UserDtoBase {
    private String password;
    private String roles;

    public RegisterRequest() {}

    public RegisterRequest(
            String username,
            String password,
            String email,
            String roles,
            String firstName,
            String lastName,
            String phoneNumber,
            String streetName,
            String postalCode,
            Integer houseNumber,
            String houseNumberExtra,
            String province,
            String role
    ) {
        super(username, email, roles, firstName, lastName, phoneNumber, streetName, postalCode, houseNumber, houseNumberExtra, province);

        this.password = password;
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
