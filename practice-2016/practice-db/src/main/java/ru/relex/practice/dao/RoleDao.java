package ru.relex.practice.dao;

import ru.relex.practice.model.Role;

public interface RoleDao {

    Role getRole(long id);
    Role getRole(String name);
}
