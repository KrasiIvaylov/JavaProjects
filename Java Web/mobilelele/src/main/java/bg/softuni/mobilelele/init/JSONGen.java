package bg.softuni.mobilelele.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JSONGen implements CommandLineRunner {
    private final ObjectMapper mapper;

    public JSONGen(ObjectMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(mapper.writeValueAsString(new Car().setName("ford").setBrand("fiesta")));
    }

    static class Car{
        private String name, brand;

        public String getName() {
            return name;
        }

        public Car setName(String name) {
            this.name = name;
            return this;
        }

        public String getBrand() {
            return brand;
        }

        public Car setBrand(String brand) {
            this.brand = brand;
            return this;
        }
    }
}
