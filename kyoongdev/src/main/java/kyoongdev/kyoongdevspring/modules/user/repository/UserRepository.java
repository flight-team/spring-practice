package kyoongdev.kyoongdevspring.modules.user.repository;

import kyoongdev.kyoongdevspring.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(String id);

    Optional<User> findByName(String name);


    Long countAllBy();

    List<User> findAll(Pageable paging);

    String saveUser(User user);

    void updateUser(User user);

    void deleteUser(String id);
}
