package softuni.exam.service;



import softuni.exam.models.Entity.Car;

import java.io.IOException;
public interface CarService {

    boolean areImported();

    String readCarsFileContent() throws IOException;
	
	String importCars() throws IOException;

    String getCarsOrderByPicturesCountThenByMake();

    Car findById(Long car);
}
