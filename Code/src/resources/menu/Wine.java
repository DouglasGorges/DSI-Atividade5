package resources.menu;

import resources.MenuItem;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Wine extends MenuItem {
    StringBuilder wineStr = new StringBuilder();

    public Wine() {
    }

    public void saveWine(Wine wine) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("vinhos-tabulados.txt", true));
            //output.print(prepareToSave(wine));
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String prepareToSave(Wine wine) {
        String drinkPrice = Double.toString(wine.getPrice());
        wineStr.append("\n");
        wineStr.append(drinkPrice);
        wineStr.append("\t");
        wineStr.append(wine.getName());
        return wineStr.toString();
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
