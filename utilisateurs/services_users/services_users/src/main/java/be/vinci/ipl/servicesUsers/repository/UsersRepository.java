package be.vinci.ipl.servicesUsers.repository;

import be.vinci.ipl.servicesUsers.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User,Integer> {

}
