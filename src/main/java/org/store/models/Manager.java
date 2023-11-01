package org.store.models;

import org.store.enums.Gender;
import org.store.enums.Qualification;
import org.store.enums.Role;
import org.store.services.ManagerService;

public class Manager extends Person implements ManagerService {
    Role role;

    public Manager(String name, String phoneNumber, Gender gender, String emailAddress) {
        super(name, phoneNumber, gender, emailAddress);
        this.role = Role.MANAGER;
    }

    @Override
    public String toString() {
        return "Manager{"
                + super.toString() +
                " role=" + role +
                '}';
    }

    @Override
    public String hireCashier(Store store, Applicant applicant) {
        if (store.getApplicantList().contains(applicant)) {
            if (store.getManager() == this) {
                if (applicant.qualification == Qualification.BSC || applicant.qualification == Qualification.MSC) {
                    Cashier cashier = new Cashier(applicant.getName(),
                            applicant.getPhoneNumber(),
                            applicant.getGender(),
                            applicant.getEmailAddress(),
                            store.getCashierList().size() + 1,
                            applicant.qualification);
                    store.getCashierList().add(cashier);
                    store.getApplicantList().remove(applicant);
                    return applicant.getName() + " has been hired as a cashier in " + store.getStoreName();
                } else {
                    return "Applicant is not qualified.";
                }
            } else {
                return "You are not authorized to perform this operation.";
            }
        }
        return "Applicant has not applied for a position in" + store.getStoreName().toLowerCase();
    }

    @Override
    public String sackStaff(Store store, Cashier cashier) {
        if (store.getCashierList().contains(cashier)) {
            if (store.getManager() == this) {
                store.getCashierList().remove(cashier);
                return "Cashier is fired!";
            }
            else {
                return "Manager is unauthorized";
            }
        }
        return "Cashier doesn't work here!";
    }


    @Override
    public String restockProducts(Store store, Product products) {
        return null;
    }
}
