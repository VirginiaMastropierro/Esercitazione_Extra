package Service;

import Repository.BranoRepository;
import lombok.AllArgsConstructor;
import model.Brano;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BranoServiceImpl implements BranoService{
    private final BranoRepository branoRepository;


    @Override
    public List<Brano> getBraniByVotoDESC() {
        return branoRepository.findBraniByVotoDESC();
    }

    @Override
    public List<Brano> getBraniBYCantanteASC() {
        return branoRepository.findBraniByCantanteASC();
    }

    @Override
    public List<Brano> getBraniByTitoloASC() {
        return branoRepository.findBraniByTitoloASC();
    }

    @Override
    public void saveBrano(Brano brano) {
        branoRepository.save(brano);
    }

    @Transactional
    @Override
    public void updateBrano(Brano brano) {
        Brano temp = branoRepository.getById(brano.getIdBrano());
        temp.setAnno(brano.getAnno());
        temp.setCantante(brano.getCantante());
        temp.setTitolo(brano.getTitolo());
        temp.setNomeAlbum(brano.getNomeAlbum());
        temp.setVoto(brano.getVoto());
    }

    @Override
    public void deleteBrano(String titolo, String cantante) {

    }


}
