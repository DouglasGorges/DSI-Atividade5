package application;

import resources.menu.Drink;
import resources.menu.Plate;
import resources.menu.Wine;

import java.util.Scanner;

public class ManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione um módulo");
        System.out.println("1 - Cadastros");
        System.out.println("2 - Relatórios"); //TODO Implementar
        Integer module = scanner.nextInt();

        if (module.equals(1)) {
            System.out.println("Selecione um tipo de cadastro");
            System.out.println("1 - Pratos");
            System.out.println("2 - Bebidas");
            System.out.println("3 - Vinhos");
            Integer tipoCadastro = scanner.nextInt();

            if (tipoCadastro.equals(1)) {
                System.out.println("Digite o nome do novo prato:");
                String plateName = scanner.next();
                System.out.println("Digite o preço do novo prato:");
                Double platePrice = scanner.nextDouble();
                Plate plate = new Plate();
                plate.setName(plateName);
                plate.setPrice(platePrice);
                plate.savePlate(plate);

            } else if (tipoCadastro.equals(2)) {
                System.out.println("Digite o nome da nova bebida:");
                String drinkName = scanner.next();
                System.out.println("Digite o preço da nova bebida:");
                Double drinkPrice = scanner.nextDouble();
                Drink drink = new Drink();
                drink.setName(drinkName);
                drink.setPrice(drinkPrice);
                drink.saveDrink(drink);

            } else if (tipoCadastro.equals(3)) {
                System.out.println("Digite o nome do novo vinho:");
                String wineName = scanner.next();
                System.out.println("Digite o preço do novo vinho:");
                Double winePrice = scanner.nextDouble();
                Wine wine = new Wine();
                wine.setName(wineName);
                wine.setPrice(winePrice);
                wine.saveWine(wine);

            }
        } else if (module.equals(2)) {

        }
    }
}
