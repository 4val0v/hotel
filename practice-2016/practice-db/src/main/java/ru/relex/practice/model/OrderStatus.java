package ru.relex.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS_STATUS", schema = "PRACTICE_ADMIN", catalog = "")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    
    @Basic
    @Column(name = "NAME", nullable = false, updatable = false, length = 64)
    private String name;
    
    @Basic
    @Column(name = "DESCRIPTION", nullable = false, updatable = false, length = 256)
    private String description;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus that = (OrderStatus) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(getId());
    }
}
