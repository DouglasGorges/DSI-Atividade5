package application;

import resources.menu.Drink;
import resources.menu.Plate;
import resources.menu.Wine;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class ManagerApp {
    public static void main(String[] args) {
        initMenu();
    }

    private static void initMenu() {
        Scanner scanModule = new Scanner(System.in);

        System.out.println("Selecione um módulo");
        System.out.println("1 - Cadastros");
        System.out.println("2 - Relatórios");
        System.out.println("");
        System.out.println("3 - Finalizar");
        Integer module = scanModule.nextInt();

        if (module.equals(1))
            register();
        else if (module.equals(2))
            reports();
        else
            systemFinisher();
    }

    private static void register() {
        Scanner scanMenu = new Scanner(System.in);
        System.out.println("Selecione um tipo de cadastro");
        System.out.println("1 - Pratos");
        System.out.println("2 - Bebidas");
        System.out.println("3 - Vinhos");
        System.out.println("");
        System.out.println("4 - Voltar ao menu principal");

        Integer tipoCadastro = scanMenu.nextInt();

        if (tipoCadastro.equals(1))
            plateRegister();
        else if (tipoCadastro.equals(2))
            drinkRegister();
        else if (tipoCadastro.equals(3))
            wineRegister();
        else
            initMenu();
    }

    private static void plateRegister() {
        Scanner scanPlate = new Scanner(System.in);
        System.out.println("Digite o nome do novo prato:");
        String plateName = scanPlate.next();
        System.out.println("Digite o preço do novo prato:");
        Double platePrice = scanPlate.nextDouble();

        Plate plate = new Plate();
        plate.setName(plateName);
        plate.setPrice(platePrice);

        plate.savePlate(plate);

        System.out.println("\n\n");
        System.out.println("----------");
        initMenu();
    }

    private static void drinkRegister() {
        Scanner scanDrink = new Scanner(System.in);
        System.out.println("Digite o nome da nova bebida:");
        String drinkName = scanDrink.next();
        System.out.println("Digite o preço da nova bebida:");
        Double drinkPrice = scanDrink.nextDouble();

        Drink drink = new Drink();
        drink.setName(drinkName);
        drink.setPrice(drinkPrice);

        drink.saveDrink(drink);

        System.out.println("\n\n");
        System.out.println("----------");
        initMenu();
    }

    private static void wineRegister() {
        Scanner scanWine = new Scanner(System.in);
        System.out.println("Digite o nome do novo vinho:");
        String wineName = scanWine.next();
        System.out.println("Digite o preço do novo vinho:");
        Double winePrice = scanWine.nextDouble();

        Wine wine = new Wine();
        wine.setName(wineName);
        wine.setPrice(winePrice);

        wine.saveWine(wine);

        System.out.println("\n\n");
        System.out.println("----------");
        initMenu();
    }

    private static void reports() {
        try {
            Scanner scanner = new Scanner(new FileReader("historico.txt")).useDelimiter(";");

            while (scanner.hasNext()) {
                Double requestTotalPrice = 0.0;
                String request = scanner.next();
                String[] items = request.split("\n");
                for (String item : items) {
                    String[] itemDetails = item.split("\t");
                    if (itemDetails.length > 1)
                        requestTotalPrice += Double.parseDouble(itemDetails[1]);
                }

                if (requestTotalPrice != 0.0) {
                    System.out.println(request);
                    System.out.println("Preco total do pedido: " + requestTotalPrice);
                }
            }

            System.out.println("\n\n");
            System.out.println("----------");

        } catch (Exception e) {
            e.printStackTrace();
        }

        initMenu();
    }

    private static void systemFinisher(){
        System.out.println("Sistema finalizado com sucesso!");
    }
}
