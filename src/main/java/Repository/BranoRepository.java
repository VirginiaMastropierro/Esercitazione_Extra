package Repository;

import model.Brano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranoRepository extends JpaRepository<Brano,String > {
    @Query(value = "SELECT * from Brano b order by voto DESC", nativeQuery = true)
    //@Query("SELECT b from Brano b order by voto DESC")
    List<Brano> findBraniByVotoDESC();

    @Query("SELECT b FROM Brano border by cantante ASC")
    List<Brano> findBraniByCantanteASC();

    @Query("SELECT b FROM Brano b order by titlo ASC")
    List<Brano> findBraniByTitoloASC();

    Brano getById(Long idBrano);
}
