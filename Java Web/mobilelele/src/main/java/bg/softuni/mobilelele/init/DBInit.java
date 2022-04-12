package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.model.entity.CategoryEnum;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;

    public DBInit(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public void run(String... args) {
        if (brandRepository.count() == 0){
            BrandEntity ford = new BrandEntity().setName("Ford");
            ModelEntity fiesta = new ModelEntity();
            fiesta
                    .setName("Fiesta")
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/800px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                    .setStartYear(1976)
                    .setCategory(CategoryEnum.CAR);

            ModelEntity mondeo = new ModelEntity();
            mondeo
                    .setName("Mondeo")
                    .setImageUrl("https://images.ams.bg/images/galleries/207570/ford-mondeo-otiva-v-istoriyata-prez-mart-2022-g-1616681377_big.jpg")
                    .setStartYear(2022)
                    .setCategory(CategoryEnum.CAR);

            ford.setModels(List.of(fiesta, mondeo));
            fiesta.setBrand(ford);
            mondeo.setBrand(ford);
            brandRepository.save(ford);
        }
    }
}
