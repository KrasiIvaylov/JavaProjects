package animals;

public class Animal {
    private String name;
    private int age;
    private Gender gender;
    public Animal(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    protected String produceSound(){
        return "";
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(System.lineSeparator());
        sb.append(name + " " + age + " " + gender.getAsString());
        sb.append(System.lineSeparator());
        sb.append(this.produceSound());
        return sb.toString();
    }
}
