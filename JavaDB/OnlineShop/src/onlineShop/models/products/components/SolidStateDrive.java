package onlineShop.models.products.components;

import onlineShop.models.products.computers.BaseComputer;

public class SolidStateDrive extends BaseComponent {
    public SolidStateDrive(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price,1.20 * overallPerformance, generation);
    }
}
