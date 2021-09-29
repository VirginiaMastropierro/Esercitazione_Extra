package Controller;


import Service.UtenteService;
import lombok.RequiredArgsConstructor;
import model.Brano;
import model.RoleToUtente;
import model.Utente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.relation.Role;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class UsersController {
    private final UtenteService utenteService;

    @GetMapping("/utenti")
    public ResponseEntity<List<Brano>> getUtenti(){
        return ResponseEntity.ok(this.utenteService.getUtente());
    }

    @PostMapping("/utenti")
    public ResponseEntity<Utente> saveUtente(@RequestBody Utente utente)
    {
        //TODO verificare uri sia corretto, si dovrebbe fare in modo che l'uri indichi il path preciso della risorsa creata
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/utenti/"+utente.getUsername()).toUriString());
        System.out.println(uri.toString()); //TODO da rimuovere, per test
        return ResponseEntity.created(uri).body(this.utenteService.saveUtente(utente));
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> saveRole(@RequestBody Role ruolo)
    {
        return ResponseEntity.ok().body(this.utenteService.saveRole(ruolo));
    }

    @PostMapping("/roles/addUtente")
    public ResponseEntity<?> addRoleToUtente(@RequestBody RoleToUtente ruolo)
    {
        this.utenteService.addRoleUtente(ruolo.getUsername(), ruolo.getRoleName());
        return ResponseEntity.ok().build();
    }


}