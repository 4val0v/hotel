package ru.relex.practice.model;

import javax.persistence.*;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "userIdSeq", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false, length = 64)
    private String username;

    @Column(name = "PASSWORD", nullable = false, columnDefinition = "CHAR(88)")
    private String passwordAndSalt;

    @Column(name = "CREATED", nullable = false, insertable = false, updatable = false, columnDefinition = "DATE DEFAULT SYSDATE")
    private Date createdAt;

    @Column(name = "IS_LOCKED", nullable = false, insertable = false, columnDefinition = "NUMBER(2,0) DEFAULT 0")
    private boolean isLocked;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES", joinColumns = {@JoinColumn(name = "USER_ID", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false)})
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordAndSalt() {
        return passwordAndSalt;
    }

    public void setPasswordAndSalt(String passwordAndSalt) {
        this.passwordAndSalt = passwordAndSalt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
