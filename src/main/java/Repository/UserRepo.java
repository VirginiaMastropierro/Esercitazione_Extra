package Repository;

import model.Brano;
import model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Brano,String > {
    Utente findUtenteByUsername(String username);
    Boolean existsByUsername(String username);

    Utente saveUtente(Utente utente);
}
