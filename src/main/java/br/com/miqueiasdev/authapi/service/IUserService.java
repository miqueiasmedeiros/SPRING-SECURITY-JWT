package br.com.miqueiasdev.authapi.service;

import br.com.miqueiasdev.authapi.model.User;
import br.com.miqueiasdev.authapi.security.MyToken;

public interface IUserService {
    public User addUser(User user);
    public User getByUsername(String username);
    public MyToken userLogin(User user);
}
