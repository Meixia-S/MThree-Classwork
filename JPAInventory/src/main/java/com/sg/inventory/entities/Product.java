package com.sg.inventory.entities;

import org.springframework.data.annotation.Id;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private int quantity = 0;

    @ManyToOne
    @JoinColumn(name = "storeid", nullable = false)
    private Store store;

    @ManyToMany
    @JoinTable(name = "product_supplier",
            joinColumns = {@JoinColumn(name = "productid")},
            inverseJoinColumns = {@JoinColumn(name = "supplierid")})
    private List<Supplier> suppliers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}