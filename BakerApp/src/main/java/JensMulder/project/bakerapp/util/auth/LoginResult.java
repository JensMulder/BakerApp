package JensMulder.project.bakerapp.util.auth;

import java.util.List;

public class LoginResult {
    private String message;
    private String accessToken;

    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public LoginResult() {
        this.message = "Wrong username and/or password.";
    }

    public LoginResult(String accessToken, Long id, String username, String email, List<String> roles) {
        this.message = "Login successful";
        this.accessToken = accessToken;
        this.id = id;
        this.email = email;
        this.username = username;
        this.roles = roles;
    }

    public String getMessage() {
        return message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
