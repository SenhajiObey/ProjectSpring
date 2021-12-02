package service.products.service;

import service.products.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(int id);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByPrice(int min, int max);

    boolean createProduct(Product product);

    boolean updateProduct(int id, Product product);

    boolean deleteProduct(int id);
}
