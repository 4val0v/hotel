package ru.relex.practice.mappings;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import ru.relex.practice.dao.FacilityDao;
import ru.relex.practice.dto.FacilityDTO;
import ru.relex.practice.enumeration.FacilitiesEnum;
import ru.relex.practice.model.Facility;

@Mapper(componentModel = "spring")
public abstract class FacilityMapper {

    @Autowired
    FacilityDao facilityDao;

    private static final Map<Integer, Facility> CACHED_ROLES = new HashMap<>();

    public FacilitiesEnum facilityToFacilitiesEnum(Facility facility) {
        assert facility != null : "Facility must be set!";
        return FacilitiesEnum.getByID((Integer)facility.getId());
    }

    public Facility facilityEnumToFacility (FacilitiesEnum facilityEnum) {
        assert facilityEnum != null : "facilityEnum must be set!";
        if (!CACHED_ROLES.containsKey(facilityEnum.getId())) {
            CACHED_ROLES.put(facilityEnum.getId(), facilityDao.getByID(facilityEnum.getId()));
        }
        return CACHED_ROLES.get(facilityEnum.getId());
    }

    public abstract Set<FacilitiesEnum> facilitiesToFacilityEnums(Collection<Facility> roles);

    public abstract Set<Facility> facilityEnumsToFacilities(Collection<FacilitiesEnum> roleTypes);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description" , target = "description")
    public abstract Facility facilityDtoToFacility(FacilityDTO i);
}
