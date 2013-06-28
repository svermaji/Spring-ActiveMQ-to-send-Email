package com.examples.amqmobile;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: sverma
 * Date: 18/10/12
 * Time: 3:06 PM
 */
public class AMQMobile implements Serializable {

    private String company;
    private String model;
    private int price;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString () {
        StringBuilder sb = new StringBuilder().append("Company: ").append(company)
                                  .append(", Model: ").append(model)
                                  .append(", Price: ").append(price);
        return sb.toString();
    }

}
