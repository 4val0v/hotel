package ru.relex.practice.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Запись в логе
 */
@Entity
@Table(name = "LOGS")
public class Log {

    @Id
    @Column(name = "LOG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "USER_ID", updatable = false)
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class)
    private User user;

    @JoinColumn(name = "LOG_TYPE_ID", nullable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = LogType.class)
    private LogType type;

    @Column(name = "LOG_TIME", insertable = false, updatable = false)
    private Date time;

    @Column(name = "MESSAGE", length = 256, insertable = false, updatable = false)
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LogType getType() {
        return type;
    }

    public void setType(LogType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
