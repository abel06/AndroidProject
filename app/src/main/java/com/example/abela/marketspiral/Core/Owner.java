package com.example.abela.marketspiral.Core;

/**
 * Created by Abela on 4/1/2017.
 */

public class Owner {
    private String name;
    private String phone;
    private String email;
    private String country;
    private String speaks;


    public Owner(String name,String phone,String email,String country,String speaks) {
        this.name = name;
        this.phone = phone;
        this.email= email;
        this.country=country;
        this.speaks = speaks;


    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name ;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }
    public void setSpeaks(String speaks) {

        this.speaks=speaks;
    }
    public String getSpeaks (){
        return speaks;
    }

}
