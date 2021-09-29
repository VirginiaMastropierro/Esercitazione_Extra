package Config;

import Repository.BranoRepository;
import model.Brano;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class BranoConfig {
    @Bean
    CommandLineRunner commandLineRunner(BranoRepository branoRepository){
        return args -> {
            Brano brano1 = new Brano("Shot for me","Drake","Take care",2016,9);
            Brano brano2 = new Brano("XO","Beyonce","Beyonce",2013,10);
            Brano brano3 = new Brano("Part of me","Katy Perry","Katy Album",2012,7);
            Brano brano4 = new Brano("T'amo","Mahmood","Ghettolimpo",2021,10);
            Brano brano5 = new Brano("Che poi","Carl Brave","Notti brave",2019,8.5);
            Brano brano6 = new Brano("Rancore","Lavente","Magmamemoria",2020,9.5);
            Brano brano7 = new Brano("Giulia","Pingiuni tattici nucleari","Ahia",2019,9.9);
            Brano brano8 = new Brano("Sour candy","DrLady Gaga","Chromatica",2020,10);
            Brano brano9 = new Brano("Mad","Solange","A seat at the table",2018,7.5);
            Brano brano10 = new Brano("Baby","Madame","Baby",2017,5.6);

            List<Brano> temp= new ArrayList<>();
            temp.add(brano1);
            temp.add(brano2);
            temp.add(brano3);
            temp.add(brano4);
            temp.add(brano5);
            temp.add(brano6);
            temp.add(brano7);
            temp.add(brano8);
            temp.add(brano9);
            temp.add(brano10);
            branoRepository.deleteAll();
            branoRepository.saveAll(temp);
        };
    }
}
