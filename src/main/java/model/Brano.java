package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table
@Data
@AllArgsConstructor

public class Brano {
    Long idBrano;
    String titolo;
    String cantante;
    String nomeAlbum;
    Integer anno;
    double voto;

    public Brano(String titolo, String cantante, String nomeAlbum, Integer anno, double voto) {
        this.titolo = titolo;
        this.cantante = cantante;
        this.nomeAlbum = nomeAlbum;
        this.anno = anno;
        this.voto = voto;
    }
}
