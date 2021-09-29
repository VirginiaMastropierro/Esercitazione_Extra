package Repository;

import model.Brano;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RoleRepo extends JpaRepository<Brano,String > {
    Role findByNome(String nome);
    Role saveRole(Role role);
    Role addRoleUtente(String roleName, String username);
}
