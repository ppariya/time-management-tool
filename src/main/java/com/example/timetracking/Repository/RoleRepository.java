package com.example.timetracking.Repository;

import com.example.timetracking.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
