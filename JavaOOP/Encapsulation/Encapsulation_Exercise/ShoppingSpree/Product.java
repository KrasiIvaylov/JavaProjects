package ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product (String name, double cost){
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (!StringValidator.isValidName(name)){
            throw new IllegalArgumentException(ConstantMessage.INVALID_NAME_EXCEPTION);
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (!NumericValidator.isNonNegative(cost)){
            throw new IllegalArgumentException(ConstantMessage.NEGATIVE_MONEY_EXCEPTION);
        }
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
