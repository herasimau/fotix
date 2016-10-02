package com.fotix.api.entities.user;

import com.fotix.api.entities.authority.Authority;

import javax.persistence.*;

/**
 * Created by herasimau on 02/10/16.
 */
@Entity
@Table(name = "user_authority")
public class UserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @OneToOne(targetEntity = Authority.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(nullable = false, name = "authority_id")
    private Authority authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
