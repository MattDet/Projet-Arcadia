package zoo.arcadia.back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import zoo.arcadia.back.entity.Role;
import zoo.arcadia.back.repository.RoleRepository;

@Log4j2
@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> findAll() {
        log.info("Find all roles");
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role not found"));
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Role not found"));
    }

    public Role creatRole(Role role) {
        role.setId(null);
        return roleRepository.save(role);
    }

    public Role updateRole(Role role) {
        if (role.getId() != null && roleRepository.existsById(role.getId())) {
            return roleRepository.save(role);
        }
        throw new IllegalArgumentException("Role not found");
    }

    public void deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Role not found");
        }
    }

}
