package service.products.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int price;
    private String category;

    public Product(int id, String name, String description, int price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product() {

    }

}
