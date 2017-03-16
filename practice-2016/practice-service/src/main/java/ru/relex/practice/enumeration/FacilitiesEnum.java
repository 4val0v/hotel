package ru.relex.practice.enumeration;


/**
 * Перечисление удобств в номерах.
 */

public enum FacilitiesEnum {

    COFFEE_MACHINE(1),
    CARDKEY(2),
    DVD_PLAYER(3),
    WIFI(4),
    HAIRDRYER(5),
    AIR_CONDITIONING(6),
    SAFEBOX(7),
    TOWELS(8),
    TV(9),
    OVEN(10),
    WC(11),
    BADKINGSIZE(12);

    final int id;

    FacilitiesEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static FacilitiesEnum getByID(Integer id){
        if (id == null){
            return null;
        }

        for (FacilitiesEnum facilitiesEnum : values()){
            if (facilitiesEnum.id == id){
                return facilitiesEnum;
            }
        }

        return null;
    }

    public static FacilitiesEnum getByName(String name){
        if (name == null){
            return null;
        }

        String upper = name.trim().toUpperCase();
        for (FacilitiesEnum facilitiesEnum : values()) {
            if (facilitiesEnum.name().equals(upper)) {
                return facilitiesEnum;
            }
        }


        return null;
    }

}
