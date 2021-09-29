package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {

    @Id
    private String id;
    private String nome;
    @Indexed
    private String username;
    private String password;

    private Collection<Role> roles = new ArrayList<Role>();

    }

