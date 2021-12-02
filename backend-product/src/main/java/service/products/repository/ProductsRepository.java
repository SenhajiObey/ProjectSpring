package service.products.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import service.products.model.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {
}
