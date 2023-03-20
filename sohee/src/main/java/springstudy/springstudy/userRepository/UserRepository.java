package springstudy.springstudy.userRepository;

import org.springframework.stereotype.Repository;
import springstudy.springstudy.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    public static List<User> users;

    static{
        users = new ArrayList<>();
        users.add(new User(100,"kim","123","010-1111-1111"));
        users.add(new User(200,"lee","456","010-2222-2222"));
        users.add(new User(300,"park","789","010-3333-3333"));
        users.add(new User(400,"choi","135","010-4444-4444"));
        users.add(new User(500,"hwang","246","010-5555-5555"));

    }

    public List<User> getUsers(){
        return this.users;
    }

    public User getUserByUserId(Integer id){
        return users.stream()
                .filter(x->x.getId().equals(id))
                .findFirst()
                .orElse(new User(0,"Not Available","000","Not Available"));
    }

    public User createUser(User user){
        users.add(user);
        return user;
    }

    public void updateUser(User user){
        users.stream()
                .filter(item->item.getId().equals(user.getId()))
                .findAny()
                .orElse(new User(0,"no user","000","no tel"))
                .setName(user.getName());
    }

    public void deleteUser(Integer id){
        users.removeIf(user->user.getId().equals(id));
    }
}
