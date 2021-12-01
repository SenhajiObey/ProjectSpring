package be.vinci.ipl.user.repository;

import be.vinci.ipl.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User,Integer> {

}
