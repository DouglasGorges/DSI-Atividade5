package resources.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class MenuItem {
    String name;
    Double price;

    public MenuItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
