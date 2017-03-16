package ru.relex.practice.enumeration;

/**
 * Перечисление, определяющее тип роли
 */
public enum RoleType {

    ADMIN(1),
    USER(2);

    private final long id;

    RoleType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public static RoleType getById(Long id) {
        if (id == null) {
            return null;
        }

        for (RoleType role : values()) {
            if (role.id == id) {
                return role;
            }
        }

        return null;
    }

    public static RoleType getByName(String name) {
        if (name == null) {
            return null;
        }

        String upper = name.trim().toUpperCase();
        for (RoleType role : values()) {
            if (role.name().equals(upper)) {
                return role;
            }
        }

        return null;
    }
}
