package org.store.models;

import org.store.enums.Gender;
import org.store.enums.Qualification;
import org.store.enums.Role;
import org.store.services.ApplicantService;

public class Applicant extends Person implements ApplicantService {
    int applicantId;
    Role roleApplied;
    Qualification qualification;

    public Applicant(int applicantId, String name, String phoneNumber, Gender gender, String emailAddress, Qualification qualification) {
        super(name, phoneNumber, gender, emailAddress);
        this.qualification = qualification;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public Role getRoleApplied() {
        return roleApplied;
    }


    public void setRoleApplied(Role roleApplied) {
        this.roleApplied = roleApplied;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Applicant{" + super.toString() +
                " roleApplied=" + roleApplied +
                ", qualification=" + qualification +
                '}';
    }

    //method
    @Override
    public String apply(Store store, Role role) {
        this.roleApplied = role;
        store.getApplicantList().add(this);
        return this.getName() + " successfully applied for the role of "
                + role.toString().toLowerCase() + " in "
                + store.getStoreName().toLowerCase();
    }
}
