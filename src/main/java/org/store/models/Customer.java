package org.store.models;

import org.store.enums.Gender;
import org.store.enums.Role;
import org.store.services.CustomerService;

import java.util.HashMap;
import java.util.Map;

public class Customer extends Person implements CustomerService {
    private Role role;
    private Map<Product, Integer> cart = new HashMap<>();
    private double wallet;

    boolean purchase = false;

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public boolean isPurchase() {
        return purchase;
    }

    public void setPurchase(boolean purchase) {
        this.purchase = purchase;
    }

    public Customer(String name, String phoneNumber, Gender gender, String emailAddress) {
        super(name, phoneNumber, gender, emailAddress);
        this.role = Role.CUSTOMER;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String addToCart(Store store, Product product, int quantityToBuy) {
        if(store.getProductsList().contains(product)){
            if(product.getQuantity() >= quantityToBuy){
                cart.put(product,quantityToBuy);
                return "Product has been added to " + this.getName() + "'s cart";
            }
            else {
                return "Sorry, product out of stock. " + product.getQuantity() + " remaining in stock.";
            }
        }
        else {
          return "Sorry, product is not available. ";
        }
    }

    @Override
    public String payForPurchase() {
        double cartTotal = 0.0;
        for (Map.Entry<Product, Integer> eachProduct : cart.entrySet()){
           Product product = eachProduct.getKey();
           int quantity = eachProduct.getValue();
           cartTotal += product.getPrice() * quantity;
           purchase=true;
        }

        if (wallet >= cartTotal){
            wallet -= cartTotal;

            return "Purchase made, waiting for cashier!";
        } else {
            return "Customer doesn't have enough cash!";
        }
    }
}
