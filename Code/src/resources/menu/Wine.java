package resources.menu;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Wine extends MenuItem {
    StringBuilder wineStr = new StringBuilder();

    public Wine() {
    }

    public void saveWine(Wine wine) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("vinhos-tabulados.txt", true));
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
