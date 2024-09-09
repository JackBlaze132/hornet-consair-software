package org.hornetsa.model;

public class Company {
    private static Company company;
    private String name;
    private int nit;
    private String address;
    private String phone;
    private String email;

    private Company() {
        name = "Hornet Corsair";
        nit = 123456789;
        address = "Calle 123";
        phone = "3124567890";
        email = "honet123@email.com";
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

    public int getNit() {
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
