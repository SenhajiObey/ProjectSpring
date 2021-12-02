package service.products.service;

import service.products.model.Product;
import service.products.repository.ProductsRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductsRepository repo;

    public ProductServiceImpl(ProductsRepository repo){this.repo=repo;}

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(int id) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return null;
    }

    @Override
    public List<Product> getProductsByPrice(int min, int max) {
        return null;
    }

    @Override
    public boolean createProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(int id, Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }
}
