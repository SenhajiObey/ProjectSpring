package service.products.repository;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import service.products.config.CustomProperties;
import service.products.model.Product;

import java.util.List;

@Component
public class ProductProxy {

    private String base_url;

    public ProductProxy(CustomProperties customProperties){base_url=customProperties.getApi();}
    private static int COUNT = 0;

    public List<Product> findAll() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Product>> response = template.exchange(
                base_url + "/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}
        );
        return response.getBody();
    }

    public Product findById(int id){
        RestTemplate template = new RestTemplate();
        ResponseEntity<Product> response = template.exchange(
                base_url + "/products" + id,
                HttpMethod.GET,
                null,
                Product.class
        );
        return response.getBody();
    }


}