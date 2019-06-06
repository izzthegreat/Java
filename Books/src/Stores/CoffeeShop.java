package Stores;

import java.time.LocalTime;

public class CoffeeShop extends Store{

    public CoffeeShop(String name, String address) {
        super(name, address);
    }

    public CoffeeShop(String name, String address, int sqrFeet, LocalTime openAt, LocalTime closedAt, boolean openOnSaturday, boolean openOnSunday) {
        super(name, address, sqrFeet, openAt, closedAt, openOnSaturday, openOnSunday);
    }
}
