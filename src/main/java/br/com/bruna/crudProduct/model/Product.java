package br.com.bruna.crudProduct.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false, length = 40)
    private String name;

    @Column(name = "category", nullable = false, length = 20)
    private String category;

    @Column(name = "price", nullable = false, length = 10)
    private Double price;

    @Column(name="register_date")
    private Date registerDate;

    @Column(name="shipment")
    private String shipment;

    public Product() {
    }

    public Product(long id, String name, String category, Double price, Date registerDate, String shipment) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.registerDate = registerDate;
        this.shipment = shipment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }
}
