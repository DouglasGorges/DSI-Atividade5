package resources.menu;

import resources.MenuItem;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Plate extends MenuItem {

    StringBuilder plateStr = new StringBuilder();

    public Plate() {
    }

    public void savePlate(Plate plate) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("pratos.csv", true));
            output.print(prepareToSave(plate));
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String prepareToSave(Plate plate) {
        String platePrice = Double.toString(plate.getPrice());
        plateStr.append("\n");
        plateStr.append(plate.getName());
        plateStr.append(";");
        plateStr.append(platePrice);
        return plateStr.toString();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPrice(Double price) {
        super.setPrice(price);
    }
}
