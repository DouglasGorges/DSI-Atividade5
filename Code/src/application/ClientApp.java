package application;

import resources.menu.MenuItem;
import resources.menu.Drink;
import resources.menu.Plate;
import resources.menu.Wine;
import resources.requests.Request;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class ClientApp {
    static Integer CHARACTERS_QTY = 40;
    static String HEAD = "Cód \t Descrição \t\t\t\t\t\t\t\t\t Preço";
    static Request request = new Request();

    public static void main(String[] args) {
        initMenu();
    }

    private static void initMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione um tipo de produto");
        System.out.println("1 - Pratos");
        System.out.println("2 - Bebidas");
        System.out.println("3 - Vinhos");
        System.out.println("");
        System.out.println("4 - Reiniciar pedido");
        System.out.println("5 - Finalizar pedido");
        Integer productType = scanner.nextInt();

        if (productType.equals(1)) {
            System.out.println(HEAD);
            addPlate();
        } else if (productType.equals(2)) {
            System.out.println(HEAD);
            addDrink();
        } else if (productType.equals(3)) {
            System.out.println(HEAD);
            addWine();
        } else if (productType.equals(4)) {
            request = new Request();
            initMenu();
        } else
            closeRequest();
    }

    private static void addPlate() {
        try {
            Scanner scanner = new Scanner(new FileReader("pratos.csv")).useDelimiter("\\n");
            scanner.nextLine();
            HashMap<Integer, String[]> platesMap = new HashMap<Integer, String[]>();
            Integer mapControl = 0;

            while (scanner.hasNext()) {
                String[] plate = scanner.next().split(";");
                platesMap.put(mapControl++, plate);
                System.out.println(mapControl + "\t\t" + prepareDescription(plate[0]) + "\t" + plate[1]);
            }
            Scanner scanCode = new Scanner(System.in);
            System.out.println("Digite o código do prato desejado:");
            Integer plateCode = scanCode.nextInt();

            Plate plate = new Plate();
            plate.setName(platesMap.get(plateCode - 1)[0]);
            plate.setPrice(Double.parseDouble(platesMap.get(plateCode - 1)[1]));

            request.getMenuList().add(plate);

            System.out.println("Prato adicionado ao pedido com sucesso!\n");

            initMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addDrink() {
        try {
            Scanner scanner = new Scanner(new FileReader("bebidas-tabuladas.txt")).useDelimiter("\\n");
            scanner.nextLine();
            HashMap<Integer, String[]> drinksMap = new HashMap<Integer, String[]>();
            Integer mapControl = 0;

            while (scanner.hasNext()) {
                String[] drink = scanner.next().split("\t");
                drink[0] = drink[0].replace(",", ".");
                drink[1] = drink[1].split("\r")[0];
                drinksMap.put(mapControl++, drink);
                System.out.println(mapControl + "\t\t" + prepareDescription(drink[1]) + "\t" + drink[0]);
            }
            Scanner scanCode = new Scanner(System.in);
            System.out.println("Digite o código da bebida desejada:");
            Integer drinkCode = scanCode.nextInt();

            Drink drink = new Drink();
            drink.setName(drinksMap.get(drinkCode - 1)[1]);
            drink.setPrice(Double.parseDouble(drinksMap.get(drinkCode - 1)[0]));

            request.getMenuList().add(drink);

            System.out.println("Bebida adicionada ao pedido com sucesso!\n");

            initMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addWine() {
        try {
            Scanner scanner = new Scanner(new FileReader("vinhos-tabulados.txt")).useDelimiter("\\n");
            scanner.nextLine();
            HashMap<Integer, String[]> winesMap = new HashMap<Integer, String[]>();
            Integer mapControl = 0;

            while (scanner.hasNext()) {
                String[] wine = scanner.next().split("\t");
                wine[1] = wine[1].split("\r")[0];
                winesMap.put(mapControl++, wine);
                System.out.println(mapControl + "\t\t" + prepareDescription(wine[1]) + "\t" + wine[0]);
            }
            Scanner scanCode = new Scanner(System.in);
            System.out.println("Digite o código do vinho desejado:");
            Integer wineCode = scanCode.nextInt();

            Wine wine = new Wine();
            wine.setName(winesMap.get(wineCode - 1)[1]);
            wine.setPrice(Double.parseDouble(winesMap.get(wineCode - 1)[0]));

            request.getMenuList().add(wine);

            System.out.println("Vinho adicionado ao pedido com sucesso!\n");

            initMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String prepareDescription(String description) {
        String plateDescription = "";
        if (description.length() >= CHARACTERS_QTY)
            plateDescription = description.substring(0, CHARACTERS_QTY);
        else {
            plateDescription = description;
            while (plateDescription.length() <= CHARACTERS_QTY)
                plateDescription += " ";
        }
        return plateDescription;
    }

    private static void closeRequest() {
        if (request.getMenuList().size() != 0) {
            System.out.println("Alguma observação final?");
            Scanner scanGuideline = new Scanner(System.in);
            String guideline = scanGuideline.next();
            request.setGuideline(guideline);

            writeRequestOnHistoryFile();

            System.out.println("Totais do pedido:");
            System.out.println("Total de itens: " + request.getMenuList().size());
            System.out.println("Total a pagar: " + totalCalculate(request));
        } else
            System.out.println("Pedido finalizado sem itens.");
    }

    private static Double totalCalculate(Request request) {
        Double totalPrice = 0.0;
        for (MenuItem item : request.getMenuList())
            totalPrice += item.getPrice();
        return totalPrice;
    }

    private static void writeRequestOnHistoryFile() {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("historico.txt", true));
            String historyStr = "";
            for (MenuItem item : request.getMenuList()) {
                historyStr += item.getName();
                historyStr += "\t";
                historyStr += item.getPrice();
                historyStr += "\n";
            }
            historyStr += "Observações: ";
            historyStr += request.getGuideline();
            historyStr += ";\n\n";

            output.print(historyStr);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
