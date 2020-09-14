package application;

import resources.menu.Drink;
import resources.menu.Plate;
import resources.menu.Wine;

import java.util.Scanner;

public class ManagerApp {
    public static void main(String[] args) {
        Scanner scanModule = new Scanner(System.in);

        System.out.println("Selecione um módulo");
        System.out.println("1 - Cadastros");
        System.out.println("2 - Relatórios"); //TODO Implementar
        Integer module = scanModule.nextInt();

        if (module.equals(1)) {
        Scanner scanMenu = new Scanner(System.in);
            System.out.println("Selecione um tipo de cadastro");
            System.out.println("1 - Pratos");
            System.out.println("2 - Bebidas");
            System.out.println("3 - Vinhos");
            Integer tipoCadastro = scanMenu.nextInt();

            if (tipoCadastro.equals(1)) {
                Scanner scanPlate = new Scanner(System.in);
                System.out.println("Digite o nome do novo prato:");
                String plateName = scanPlate.next();
                System.out.println("Digite o preço do novo prato:");
                Double platePrice = scanPlate.nextDouble();
                Plate plate = new Plate();
                plate.setName(plateName);
                plate.setPrice(platePrice);
                plate.savePlate(plate);

            } else if (tipoCadastro.equals(2)) {
                Scanner scanDrink = new Scanner(System.in);
                System.out.println("Digite o nome da nova bebida:");
                String drinkName = scanDrink.next();
                System.out.println("Digite o preço da nova bebida:");
                Double drinkPrice = scanDrink.nextDouble();
                Drink drink = new Drink();
                drink.setName(drinkName);
                drink.setPrice(drinkPrice);
                drink.saveDrink(drink);

            } else if (tipoCadastro.equals(3)) {
                Scanner scanWine = new Scanner(System.in);
                System.out.println("Digite o nome do novo vinho:");
                String wineName = scanWine.next();
                System.out.println("Digite o preço do novo vinho:");
                Double winePrice = scanWine.nextDouble();
                Wine wine = new Wine();
                wine.setName(wineName);
                wine.setPrice(winePrice);
                wine.saveWine(wine);

            }
        } else if (module.equals(2)) {  //TODO visualizar todos os pedidos e o seus totais (Item 4)

        }
    }
}
