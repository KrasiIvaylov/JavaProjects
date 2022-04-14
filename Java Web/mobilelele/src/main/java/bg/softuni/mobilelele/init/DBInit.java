package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.entity.enumeration.CategoryEnum;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;

    public DBInit(BrandRepository brandRepository, UserRepository userRepository) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) {

    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            admin
                    .setActive(true)
                    .setUsername("admin")
                    .setFirstName("Admin")
                    .setLastName("Admin");
        }
    }

    private void initializeBrandAndModels() {
        if (brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity().setName("Ford");
            ModelEntity fiesta = new ModelEntity();
            fiesta
                    .setCategory(CategoryEnum.CAR)
                    .setName("Fiesta")
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/800px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                    .setStartYear(1976);

            ModelEntity mondeo = new ModelEntity();
            mondeo
                    .setCategory(CategoryEnum.CAR)
                    .setName("Mondeo")
                    .setImageUrl("https://images.ams.bg/images/galleries/207570/ford-mondeo-otiva-v-istoriyata-prez-mart-2022-g-1616681377_big.jpg")
                    .setStartYear(2022);

            ford.setModels(List.of(fiesta, mondeo));
            fiesta.setBrand(ford);
            mondeo.setBrand(ford);
            brandRepository.save(ford);
        }
    }
}
