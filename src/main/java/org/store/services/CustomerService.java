package org.store.services;

import org.store.models.Product;
import org.store.models.Store;

public interface CustomerService {
    String addToCart(Store store, Product product, int quantityToBuy);

    String payForPurchase();

}
