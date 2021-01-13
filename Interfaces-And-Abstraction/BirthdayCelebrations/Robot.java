package BirthdayCelebrations;

public class Robot implements Identifiable, Machine {
    private String id;
    private String model;

    public Robot(String id, String mode) {
        this.id = id;
        this.model = mode;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
