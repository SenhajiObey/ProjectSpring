package be.vinci.ipl.cart.model;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idUser;
    private int idProduct;
    private int quantite;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }




}
