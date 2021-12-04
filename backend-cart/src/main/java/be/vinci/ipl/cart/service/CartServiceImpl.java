package be.vinci.ipl.cart.service;

import be.vinci.ipl.cart.model.Cart;
import be.vinci.ipl.cart.repository.CartRepository;

import java.util.List;

public class CartServiceImpl implements CartService{

    private final CartRepository repo;

    public CartServiceImpl(CartRepository repo){ this.repo = repo; }

    @Override
    public List<Cart> getAllCartsByUser(int idUser) {
        return null;
    }

    @Override
    public Cart createCarts(int idProduct, int idUser) {
        return null;
    }

    @Override
    public void deleteCarts(int id) {

    }

    @Override
    public void updateCarts(int id, int quantite) {

    }


}
