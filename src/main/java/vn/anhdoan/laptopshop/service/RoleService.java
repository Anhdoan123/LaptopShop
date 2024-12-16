package vn.anhdoan.laptopshop.service;

import org.springframework.stereotype.Service;

import vn.anhdoan.laptopshop.domain.Role;
import vn.anhdoan.laptopshop.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleById(long id) {
        return this.roleRepository.findById(id);
    }
}
