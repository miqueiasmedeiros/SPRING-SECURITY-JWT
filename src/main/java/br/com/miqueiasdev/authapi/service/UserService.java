package br.com.miqueiasdev.authapi.service;

import br.com.miqueiasdev.authapi.model.User;
import br.com.miqueiasdev.authapi.repo.UserRepo;
import br.com.miqueiasdev.authapi.security.MyToken;
import br.com.miqueiasdev.authapi.security.TokenUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public User addUser(User user) {
//        if (!repo.existsUserByUsername(user.getUsername())){
//            throw new RuntimeException("Username exists!");
//        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

//    @Override
//    public User getByUsername(String username) {
//        User user = repo.findByUsername(username);
//        if (user != null){
//            return user;
//        }
//        return null;
//    }

    @Override
    public MyToken userLogin(User user) {
        User storedUser = repo.findByUsername(user.getUsername()).orElseThrow(()-> new RuntimeException("User not Found."));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(user.getPassword(), storedUser.getPassword())){
            return TokenUtil.encode(storedUser);
        }
        throw new RuntimeException("Unathourized user");
    }


}
