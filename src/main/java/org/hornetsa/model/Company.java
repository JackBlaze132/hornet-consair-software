package org.hornetsa.model;

public class Company {
    private static Company company;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private String email;

    private Company() {
        name = "Hornet Corsair";
        nit = "1234567890";
        address = "Street 123 #1-2";
        phone = "3124567890";
        email = "honetsas@email.com";
    }

    public synchronized static Company getEmpresa(){

        if (company == null){
            company = new Company();
        }

        return company;
    }

    public String getName() {
        return name;
    }

    public String getNit() {
        return nit;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
