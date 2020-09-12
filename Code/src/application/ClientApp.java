package application;

import java.util.Arrays;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione um tipo de produto");
        System.out.println("1 - Pratos");
        System.out.println("2 - Bebidas");
        System.out.println("3 - Vinhos");
        Integer tipoProduto = scanner.nextInt();
        System.out.println("Código \t Descrição \t\t\t Preço");

        if (tipoProduto.equals(1)) {

        } else if (tipoProduto.equals(1)) {

        } else if (tipoProduto.equals(1)) {

        }
    }
}
