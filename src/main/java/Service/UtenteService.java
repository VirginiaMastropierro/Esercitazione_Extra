package Service;

import model.Brano;
import model.Utente;

import javax.management.relation.Role;
import java.util.List;

public interface UtenteService {
    Utente saveUtente(Utente utente);
    Role saveRole(Role role);
    void addRoleUtente(String username, String roleName);
    Utente getUtente(String username);
    List<Brano> getUtente();
    void resetAll();

}
