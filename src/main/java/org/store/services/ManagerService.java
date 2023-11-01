package org.store.services;

import org.store.models.Applicant;
import org.store.models.Cashier;
import org.store.models.Product;
import org.store.models.Store;

public interface ManagerService {

//    Manager should be able to hire, sack and pay employees(cashiers) salaries...
    String hireCashier(Store store, Applicant applicant);

    String sackStaff(Store store, Cashier cashier);
    String restockProducts(Store store, Product products);
}
