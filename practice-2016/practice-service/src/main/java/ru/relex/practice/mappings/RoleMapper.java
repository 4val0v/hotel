package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.practice.dao.RoleDao;
import ru.relex.practice.enumeration.RoleType;
import ru.relex.practice.model.Role;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Выполняет преобразования между объектами таблицы-словаря из БД и перечислением.
 */
@Mapper(componentModel = "spring")
public abstract class RoleMapper {

    @Autowired
    private RoleDao roleDao;

    private static final Map<Long, Role> CACHED_ROLES = new HashMap<>();

    public RoleType roleToRoleType(Role role) {
        assert role != null : "Role must be set!";
        return RoleType.getById(role.getId());
    }

    public Role roleTypeToRole(RoleType roleType) {
        assert roleType != null : "roleType must be set!";
        if (!CACHED_ROLES.containsKey(roleType.getId())) {
            CACHED_ROLES.put(roleType.getId(), roleDao.getRole(roleType.getId()));
        }
        return CACHED_ROLES.get(roleType.getId());
    }

    public abstract Set<RoleType> rolesToRoleTypes(Collection<Role> roles);

    public abstract Set<Role> roleTypesToRoles(Collection<RoleType> roleTypes);
}
