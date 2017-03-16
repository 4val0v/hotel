package ru.relex.practice.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Роль пользователя
 */
@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @Column(name = "ROLE_ID", insertable = false, updatable = false)
    private Long id;

    @Column(name = "CODE", length = 64, updatable = false, insertable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 256, insertable = false, updatable = false)
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Role)) {
            return false;
        }

        return this.id.equals(((Role) obj).getId());
    }
}
