package springstudy.springstudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import springstudy.springstudy.user.User;
import springstudy.springstudy.userRepository.UserRepository;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public List<User> getUsers(){
        return userRepository.getUsers();
    }

    public User getUserByUserId(Integer id){
        return userRepository.getUserByUserId(id);
    }

    public User createUser(User user){
        return userRepository.createUser(user);
    }

    public void updateUser(User user){
        userRepository.updateUser(user);
    }

    public void deleteUser(Integer id){
        userRepository.deleteUser(id);
    }
}
