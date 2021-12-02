package service.products.controllers;

import org.springframework.web.bind.annotation.*;
import service.products.model.Product;
import service.products.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    @GetMapping
    public List<Product> getProducts(){return service.getProducts();}

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id){return service.getProduct(id);}

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category")String category){
        return service.getProductsByCategory(category);
    }

    @GetMapping("/price/{min}+{max}")
    public List<Product> getProductsByPrice(@PathVariable("min")int min, @PathVariable("max")int max){
        return service.getProductsByPrice(min,max);
    }

    @PostMapping
    public boolean createProduct(@RequestBody Product product) {service.createProduct(product);}

    @PostMapping("{id}")
    public boolean updateProduct(@PathVariable("id")int id, @RequestBody Product product){
        return service.updateProduct(id,product);
    }

    @DeleteMapping("{id}")
    public boolean deleteProduct(@PathVariable("id")int id){service.deleteProduct(id);}
}
