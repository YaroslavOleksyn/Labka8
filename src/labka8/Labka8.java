/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labka8;

import java.util.Scanner;
import java.util.List;

/**
 * Головний клас з логікою та меню
 * @author Admin
 */
public class Labka8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            try {
                System.out.println("Оберіть опцію:");
                System.out.println("1. Додати товар на склад");
                System.out.println("2. Забрати товар зі складу");
                System.out.println("3. Показати всі товари на складі");
                System.out.println("0. Вийти");

                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Введіть назву товару для додавання:");
                        String productAdd = scanner.nextLine();
                        Product productToAdd = new Product(productAdd);
                        warehouse.addProduct(productToAdd);
                        System.out.println("Товар успішно додано на склад.");
                        break;
                    case 2:
                        System.out.println("Введіть назву товару для забирання:");
                        String productName = scanner.nextLine();
                        try {
                            warehouse.takeProduct(productName);
                        } catch (ExceptionNotFound e) {
                            System.out.println("Помилка: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Товари на складі:");
                        List<Product> productList = warehouse.getProducts();
                        if (productList.isEmpty()) {
                            System.out.println("Склад порожній.");
                            break;
                        }
                        for (int i = 0; i < productList.size(); i++) {
                            Product product = productList.get(i);
                            System.out.println(product.getName());
                        }
                        break;
                    case 0:
                        System.out.println("Дякуємо за використання програми.");
                        break;
                    default:
                        System.out.println("Невірний вибір.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Помилка: Будь ласка, введіть ціле число.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
        scanner.close();
    }
}
