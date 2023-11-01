package org.store.services;

import org.store.models.Customer;

public interface CashierService {
    String sellProducts(Customer customer);
    String dispenseReceipts(Customer customer);
}
