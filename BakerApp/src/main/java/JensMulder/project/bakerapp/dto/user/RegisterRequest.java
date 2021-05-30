package JensMulder.project.bakerapp.dto.user;

import JensMulder.project.bakerapp.dto.user.base.UserDtoBase;

public class RegisterRequest extends UserDtoBase {
    private String password;

    public RegisterRequest() {}

    public RegisterRequest(
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
            String province
    ) {
        super(username, email, firstName, lastName, phoneNumber, streetName, postalCode, houseNumber, houseNumberExtra, province);

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
