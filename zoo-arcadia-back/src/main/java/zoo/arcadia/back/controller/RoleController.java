package zoo.arcadia.back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zoo.arcadia.back.entity.Role;
import zoo.arcadia.back.service.RoleService;


@RestController
@RequiredArgsConstructor
public class RoleController {
    
    private final RoleService roleService;

    @GetMapping("/v1/roles")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/v1/roles/{id}")
    public Role findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @GetMapping("/v1/roles/name/{name}")
    public Role findByName(@PathVariable String name) {
        return roleService.findByName(name);
    }
    
    @PostMapping("/v1/roles")
    public Role createRole(@RequestBody Role role) {
        return roleService.creatRole(role);
    }
    
    @PutMapping("/v1/roles")
    public Role updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }
    
    @DeleteMapping("/v1/roles/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
