package org.store.services;

import org.store.enums.Role;
import org.store.models.Store;

public interface ApplicantService {
    String apply(Store store, Role role);
}
