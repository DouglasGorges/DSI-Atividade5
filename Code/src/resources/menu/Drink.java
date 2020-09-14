package resources.menu;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Drink extends MenuItem {
    StringBuilder drinkStr = new StringBuilder();

    public Drink() {
    }

    public void saveDrink(Drink drink) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("bebidas-tabuladas.txt", true));
            output.print(prepareToSave(drink));
            output.close();
            System.out.println("Bebida salva com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String prepareToSave(Drink drink) {
        String drinkPriceRaw = Double.toString(drink.getPrice());
        String drinkPrice = drinkPriceRaw.replace(".", ",");
        drinkStr.append("\n");
        drinkStr.append(drinkPrice);
        drinkStr.append("\t");
        drinkStr.append(drink.getName());
        return drinkStr.toString();
    }
}
