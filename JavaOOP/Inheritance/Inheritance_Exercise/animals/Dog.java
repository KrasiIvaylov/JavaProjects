package animals;

public class Dog extends Animal{
    public Dog(String name, int age, Gender gender){
        super(name, age, gender);
    }
    @Override
    public String produceSound(){
        return "Woof!";
    }

}
