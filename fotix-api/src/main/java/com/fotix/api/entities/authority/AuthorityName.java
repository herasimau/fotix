package com.fotix.api.entities.authority;

/**
 * Created by herasimau on 07.08.16.
 */
public enum AuthorityName {
    ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

    private final String authority;

    AuthorityName(String s) {
        authority = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : authority.equals(otherName);
    }

    public String toString() {
        return this.authority;
    }
}
