package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!StringValidator.isValidName(name)) {
            throw new IllegalArgumentException(ConstantMessage.INVALID_NAME_EXCEPTION);
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (!NumericValidator.isNonNegative(money)) {
            throw new IllegalArgumentException(ConstantMessage.NEGATIVE_MONEY_EXCEPTION);
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
      if (product.getCost() > this.money) {
        throw new IllegalArgumentException(name +
                " can't afford " + product.getName());
      }
          this.products.add(product);
          this.money -= product.getCost();
    }

    public String getName() {
        return this.name;
    }

    @Override
  public String toString() {
      String productsOutput = this.products.isEmpty()
              ? "Nothing bought"
              : this.products.stream()
              .map((Product::getName))
              .collect(Collectors.joining(", "));
    return name + " - " + productsOutput;
  }
}
