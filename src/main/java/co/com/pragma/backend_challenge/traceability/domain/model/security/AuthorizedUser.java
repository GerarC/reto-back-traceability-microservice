package co.com.pragma.backend_challenge.traceability.domain.model.security;


import co.com.pragma.backend_challenge.traceability.domain.util.annotation.Generated;
import co.com.pragma.backend_challenge.traceability.domain.util.enums.RoleName;

@Generated
public class AuthorizedUser {
    private String token;
    private RoleName role;
    private String id;

    private AuthorizedUser(AuthorizedUserBuilder builder) {
        this.token = builder.token;
        this.role = builder.role;
        this.id = builder.id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static AuthorizedUserBuilder builder() {
        return new AuthorizedUserBuilder();
    }

    public static class AuthorizedUserBuilder {
        private String token;
        private RoleName role;
        private String id;

        public AuthorizedUserBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthorizedUserBuilder role(RoleName role) {
            this.role = role;
            return this;
        }

        public AuthorizedUserBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AuthorizedUser build() {
            return new AuthorizedUser(this);
        }
    }
}