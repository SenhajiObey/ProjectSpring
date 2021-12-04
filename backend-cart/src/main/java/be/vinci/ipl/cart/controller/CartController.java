package be.vinci.ipl.cart.controller;

import be.vinci.ipl.cart.model.Cart;
import be.vinci.ipl.cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService service;

    @GetMapping("/{idUser}")
    public List<Cart> getAllCartsByUser(@PathVariable("idUser")int idUser){ return service.getAllCartsByUser(idUser);}

    @PostMapping("/{idUser}+{idProduct}")
    public Cart createCarts(@PathVariable("idUser") int idUser,@PathVariable("idProduct") int idProduct){
        return service.createCarts(idProduct,idUser);
    }

    @PostMapping("/delete/{id}")
    public void deleteCarts(@PathVariable("idUser")int idUser){ service.getAllCartsByUser(idUser);}

    @PostMapping("/update/{id}")
    public void updateCarts(@PathVariable("id") int id, @RequestParam(value = "amount")int amount) {
        service.updateCarts(id, amount);
    }
}
