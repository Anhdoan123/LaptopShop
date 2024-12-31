package vn.anhdoan.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.anhdoan.laptopshop.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(long id);

    Role findByName(String name);
}