package org.store.models;

import org.store.enums.Gender;
import org.store.enums.Qualification;
import org.store.enums.Role;
import org.store.services.CashierService;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class Cashier extends Person implements CashierService {
    private Integer employeeID;
    private Role role;
    private Qualification qualification;

    public Cashier(String name, String phoneNumber, Gender gender, String emailAddress, Integer employeeID, Qualification qualification) {
        super(name, phoneNumber, gender, emailAddress);
        this.employeeID = employeeID;
        this.role = Role.CASHIER;
        this.qualification = qualification;
    }

    public Role getRole() {
        return role;
    }
    public Qualification getQualification() {
        return qualification;
    }
    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }
    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                super.toString() +
                " employeeID=" + employeeID +
                ", role=" + role +
                ", qualification=" + qualification +
                '}';
    }


    @Override
    public String sellProducts(Customer customer) {
        if (customer.isPurchase()){
            String receipt = dispenseReceipts(customer);
            System.out.println(receipt);
           customer.getCart().clear();
           return "Sales successfully made!";
        } else {
            return "Customer has not requested purchase!";
        }
    }

    @Override
    public String dispenseReceipts (Customer customer) {
        StringBuilder receipt = new StringBuilder();
        double cartTotal = 0.0;

        receipt.append("==== RECEIPT ====").append("\n------------");
        for (Map.Entry<Product, Integer> eachProduct : customer.getCart().entrySet()){
            Product product = eachProduct.getKey();
            int quantity = eachProduct.getValue();
            cartTotal += product.getPrice() * quantity;
            receipt.append("\n")
                    .append(product.getName())
                    .append("   ==  ")
                    .append(quantity);
        }
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "NG"));
        receipt.append("\nTotal ::::: ").append(numberFormat.format(cartTotal));
        return receipt.toString();
    }
}
