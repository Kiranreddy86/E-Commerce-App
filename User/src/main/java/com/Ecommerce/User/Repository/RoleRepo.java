package com.Ecommerce.User.Repository;

import com.Ecommerce.User.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Roles,Integer> {
}
