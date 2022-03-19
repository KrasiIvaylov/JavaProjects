package onlineShop.models.products.computers;

import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.List;

public class DesktopComputer extends BaseComputer{

    private static final int DEFAULT_PERFORMANCE = 15;
    public DesktopComputer(int id, String manufacturer, String model, double price) {
    super(id, manufacturer, model, price, DEFAULT_PERFORMANCE);
    }

}
