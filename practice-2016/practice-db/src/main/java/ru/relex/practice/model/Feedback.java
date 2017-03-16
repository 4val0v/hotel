package ru.relex.practice.model;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Обратная связь
 */

@Entity
@Table(name = "FEEDBACK")
public class Feedback {
    private int id;
    private String email;
    private String theme;
    private String message;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() { return email; }

    public void setEmail(String email) {this.email = email; }

    @Basic
    @Column(name = "THEME")
    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }

    @Basic
    @Column(name = "MESSAGE")
    public String getMessage() { return message; }

    public void setMessage(String message) {this.message = message; }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
