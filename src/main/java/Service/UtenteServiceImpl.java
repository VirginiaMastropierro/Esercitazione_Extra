package Service;

import Repository.RoleRepo;
import Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Brano;
import model.Utente;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UtenteServiceImpl implements UtenteService, UserDetailsService {
    private final UserRepo repositoryUtente;
    private final RoleRepo roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Utente saveUtente(Utente utente) {
        log.info("Salvataggio dell'utente{} all'interno del db", utente.getUsername());
        utente.getRoles().forEach(
            role ->{
                String nome = role.getNome();
                role.setId(roleRepository.findByNome(nome).getRoleName());
            }
        );
            utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return this.repositoryUtente.saveUtente(utente);
    };

    @Override
    public Role saveRole(Role role) {
        return this.roleRepository.saveRole(role);
    }

    @Override
    public void addRoleUtente(String username, String roleName) {
        Utente utente = this.repositoryUtente.findUtenteByUsername(username);
        Role role = this.roleRepository.findByNome(roleName);
        log.info("Aggiungo il ruolo {} all'utente {}.",role.getRoleName(),utente.getUsername());
       // utente.getRoles().add(roleName);

//        this.repositoryUtente.deleteById(utente.getId());
//        this.repositoryUtente.save(utente);
    }

    @Override
    public Utente getUtente(String username) {
        return repositoryUtente.findUtenteByUsername(username);
    }

    @Override
    public List<Brano> getUtente(){
        return repositoryUtente.findAll();
    }

    @Override
    public void resetAll() {
        this.repositoryUtente.deleteAll();
        this.roleRepository.deleteAll();

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
