package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, RoleType> {
    boolean existsByName(RoleType name);

    Role findByName(RoleType name);
}
