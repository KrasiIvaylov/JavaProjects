package August.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic (int capacity){
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void add(Pet pet){
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name){
       return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : this.data){
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }
    public Pet getOldestPet(){
        Pet pet = this.data
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()))
                .findFirst().orElse(null);
        return pet;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The Clinic has the following patients:");
        sb.append(System.lineSeparator());
        for (Pet pet : this.data){
            sb.append(String.format("%s %s%n", pet.getName(), pet.getOwner()));
        }
        return sb.toString();
    }
}
