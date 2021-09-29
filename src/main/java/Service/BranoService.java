package Service;

import model.Brano;

import java.util.List;

public interface BranoService {

    List<Brano> getBraniByVotoDESC();
    List<Brano> getBraniBYCantanteASC();
    List<Brano> getBraniByTitoloASC();

    void saveBrano(Brano brano);
    void updateBrano(Brano brano);
    void deleteBrano(String titolo, String cantante);
}
