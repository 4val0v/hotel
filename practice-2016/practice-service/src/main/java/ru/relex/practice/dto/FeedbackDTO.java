package ru.relex.practice.dto;

/**
 * Data Transfer Object обратной связи
 */
public class FeedbackDTO {
    private int id;
    private String email;
    private String theme;
    private String message;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}
