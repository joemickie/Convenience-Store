package org.store;

import org.store.enums.Gender;
import org.store.enums.Qualification;
import org.store.models.*;

public class Main {

    public static void main(String[] args) {
         Main main = new Main();
         main.setUp();
         main.testManagerHireUnAppliedApplicant();
         main.testManagerSuccessfulHire();
         main.testManagerFire();
         main.testManagerUnauthorized();

//        main.setUp();
        main.testCustomerAddToCart();
        main.testCustomerPayForPurchase();

        main.setUp();
        main.testCashierSellProduct();

        main.testCashierDispenseProduct();



    }

    private Store store;
    private Manager manager;
    private Cashier cashier;
    private Customer customer;
    private Applicant applicant;
    private Product product;

    private void setUp(){
        store = new Store("ShoppersMart", "edo");
        manager = new Manager("Dennis", "09082782894", Gender.MALE, "dennis@gmail.com");
        cashier = new Cashier("Jindu","09087868785", Gender.FEMALE, "jindu@gmail.com", 12221, Qualification.BSC);
        customer = new Customer("Augusta", "09081398737", Gender.FEMALE, "augusta@gmail.com");
        applicant = new Applicant(1, "Rems","09081392782", Gender.FEMALE, "augusta@gmail.com", Qualification.BSC);
        product = new Product("dark chocolate", "chocolate", 4000, 2022, 2022, 12);
    }

    private void testManagerSuccessfulHire(){
        store.setManager(manager);
        store.getApplicantList().add(applicant);
        var response = manager.hireCashier(store, applicant);
        System.out.println(response);
    }

    private void testManagerHireUnAppliedApplicant(){
        store.setManager(manager);
        var response = manager.hireCashier(store, applicant);
        System.out.println(response);
    }

    private void testManagerFire(){
        store.setManager(manager);
        Cashier cashier1 = store.getCashierList().get(0);
        var response = manager.sackStaff(store, cashier1);
        System.out.println(response);
    }

    private void testManagerUnauthorized(){
        store.setManager(null);
        store.getCashierList().add(cashier);
        var response = manager.sackStaff(store, cashier);
        System.out.println(response);
    }



    private void testCustomerAddToCart(){
        store.getProductsList().add(product);
        System.out.println(customer.addToCart(store, product, 3));

    }
    private void testCustomerPayForPurchase(){
        customer.setWallet(500_000);
        System.out.println(customer.payForPurchase());
    }

    private void testCashierSellProduct(){
//        customer.payForPurchase();
        String sellProducts = cashier.sellProducts(customer);
        System.out.println(sellProducts);
    }

    private void testCashierDispenseProduct(){

    }

}

