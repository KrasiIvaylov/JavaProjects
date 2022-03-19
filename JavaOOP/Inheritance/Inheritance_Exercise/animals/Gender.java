package animals;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");
    public String asString;
    Gender(String asString){
        this.asString = asString;
    }

    public String getAsString() {
        return asString;
    }
}
