package resources.menu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Plate extends MenuItem {

    StringBuilder plateStr = new StringBuilder();

    public Plate() {
    }

    public List<Plate> loadPlates() {
        try {
            List<Plate> platesList = new ArrayList<>();
            Scanner scanner = new Scanner(new FileReader("pratos.csv")).useDelimiter("\\n");
            scanner.nextLine();

            while (scanner.hasNext()) {
                String[] plateLoaded = scanner.next().split(";");
                Plate plate = new Plate();
                plate.setName(plateLoaded[0]);
                plate.setPrice(Double.parseDouble(plateLoaded[1]));
                platesList.add(plate);
            }
            return platesList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void savePlate(Plate plate) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("pratos.csv", true));
            output.print(prepareToSave(plate));
            output.close();
            System.out.println("Prato salvo com sucesso!");
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
}
