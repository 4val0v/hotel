package ru.relex.practice.enumeration;

/**
 * Перечисление типов цен
 */

public enum PriceType {
    LOW(1),
    MIDDLE(2),
    HIGH(3);

    private final long id;

    PriceType(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public static PriceType getByID(Long id){
        if (id == null){
            return null;
        }

        for (PriceType type : values()){
            if (type.id == id){
                return type;
            }
        }

        return null;
    }

    public static PriceType getByName(String name){
        if (name == null){
            return null;
        }

        String upper = name.trim().toUpperCase();
        for (PriceType type : values()) {
            if (type.name().equals(upper)) {
                return type;
            }
        }

        return null;
    }
}
