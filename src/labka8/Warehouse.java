/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labka8;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для створення складу з товарами.
 * @author Admin
 */
class Warehouse {

    private List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Товар " + product.getName() + " додано на склад.");
    }

    public void takeProduct(String productName) throws ExceptionNotFound {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getName().equals(productName)) {
                products.remove(i);
                System.out.println("Товар " + productName + " взято зі складу.");
                return;
            }
        }

        throw new ExceptionNotFound("Товар " + productName + " не знайдено на складі.");
    }

    public List<Product> getProducts() {
        return products;
    }
}
