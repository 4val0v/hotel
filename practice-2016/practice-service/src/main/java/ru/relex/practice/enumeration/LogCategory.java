package ru.relex.practice.enumeration;

/**
 * Перечисление, определяющее тип логигования
 */
public enum LogCategory {

    CREATE(1),
    LOGIN(2),
    LOGOUT(3),;

    private final long id;

    LogCategory(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public static LogCategory getById(Long id) {
        if (id == null) {
            return null;
        }

        for (LogCategory category : values()) {
            if (category.id == id) {
                return category;
            }
        }
        return null;
    }
}
