package be.vinci.ipl.cart.service;

import be.vinci.ipl.cart.model.Cart;

import java.util.List;

public interface CartService {

    public Cart createCarts(int idProduct, int idUser);
    public void deleteCarts(int id);
    public void updateCarts(int id, int quantite);
    public List<Cart> getAllCartsByUser(int idUser);

}
