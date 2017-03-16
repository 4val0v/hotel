package ru.relex.practice.mappings;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.practice.dto.UserDTO;
import ru.relex.practice.model.User;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected RoleMapper roleMapper;

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "login")
    @Mapping(source = "createdAt" , target = "creationDate")
    @Mapping(expression = "java(roleMapper.rolesToRoleTypes(user.getRoles()))", target = "roles")
    @Mapping(source = "passwordAndSalt", target = "password")
    public abstract UserDTO userToDto(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "login", target = "username")
    @Mapping(source = "creationDate" , target = "createdAt")
    @Mapping(expression = "java(roleMapper.roleTypesToRoles(userDTO.getRoles()))", target = "roles")
    @Mapping(target = "passwordAndSalt", source = "password")
    public abstract User userDtoToUser(UserDTO userDTO);

    public abstract List<UserDTO> usersToDtos(Collection<User> users);

    public abstract List<User> DtosToUsers(Collection<UserDTO> userDTOs);
}
