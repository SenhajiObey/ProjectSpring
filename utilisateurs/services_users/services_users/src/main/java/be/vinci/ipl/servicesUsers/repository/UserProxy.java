package be.vinci.ipl.servicesUsers.repository;

import be.vinci.ipl.servicesUsers.config.CustomProperties;
import be.vinci.ipl.servicesUsers.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@FeignClient()
public interface UserProxy {

    private String baseUrl;
    private static int COUNT = 3;

    public UserProxy(CustomProperties props) {
        baseUrl = props.getApi();
    }



    public User findByEmail(String email) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<User> response = template.exchange(
                baseUrl + "/legos/" + email,
                HttpMethod.GET,
                null,
                User.class
        );
        return response.getBody();
    }

    public List<User> findAll() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<User>> response = template.exchange(
                baseUrl + "/legos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>(){}
        );
        return response.getBody();
    }

    public List<LegoKit> findAllWithRace(String race) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<LegoKit>> response = template.exchange(
                baseUrl + "/legos/?race=" + race,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LegoKit>>(){}
        );
        return response.getBody();
    }

    public void saveLegoKit(User kit) {
        kit.setId(COUNT++);
        RestTemplate template = new RestTemplate();
        HttpEntity<LegoKit> request = new HttpEntity<>(kit);
        template.exchange(
                baseUrl + "/legos",
                HttpMethod.POST,
                request,
                Void.class
        );
    }

    public void updateLegoKit(int id, User user) {
        RestTemplate template = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(user);
        template.exchange(
                baseUrl + "/users/" + id,
                HttpMethod.PUT,
                request,
                Void.class
        );
    }

    public void deleteLegoKit(int id) {
        RestTemplate template = new RestTemplate();
        template.exchange(
                baseUrl + "/users/" + id,
                HttpMethod.DELETE,
                null,
                Void.class
        );
    }
}
