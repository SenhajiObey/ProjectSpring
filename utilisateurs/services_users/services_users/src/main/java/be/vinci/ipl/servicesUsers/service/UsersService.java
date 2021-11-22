package be.vinci.ipl.servicesUsers.service;

import be.vinci.ipl.servicesUsers.model.User;

import java.util.List;

public interface UsersService {

  List<User> getUsers();

  List<User> getUser(String email);

  List<User> createUsers(User user);

  List<User> deleteUsers(int id);

  List<User> updateUsers(int id);
}


