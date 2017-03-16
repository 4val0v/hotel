package ru.relex.practice.enumeration;

/**
 * Enum for statuses of orders
 */
public enum OrderStatusType {

    ORDERED(2),
    HOLD(3),
    CLOSED(4);

    private final long id;

    OrderStatusType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public static OrderStatusType getById(Long id) {
        if (id == null) {
            return null;
        }
        for (OrderStatusType type : values() ) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }
}
