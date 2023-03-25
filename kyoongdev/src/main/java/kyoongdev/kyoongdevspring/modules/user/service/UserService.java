package kyoongdev.kyoongdevspring.modules.user.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import kyoongdev.kyoongdevspring.common.PagingDTO;
import kyoongdev.kyoongdevspring.common.ResponseWithIdDTO;
import kyoongdev.kyoongdevspring.modules.user.dto.UpsertUserDTO;
import kyoongdev.kyoongdevspring.modules.user.dto.UserDTO;
import kyoongdev.kyoongdevspring.modules.user.entity.User;
import kyoongdev.kyoongdevspring.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


@Service
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserDTO getUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        return user.map(UserDTO::new).get();
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public PagingDTO<UserDTO> getUsers(Pageable pageable) {
        Long count = userRepository.countAllBy();
        List<UserDTO> users = userRepository.findAll(pageable).stream().map(UserDTO::new).collect(toList());

        return new PagingDTO<>(users, pageable, count);
    }

    public ResponseWithIdDTO createUser(UpsertUserDTO props) {
        Optional<User> isExist = getUserByName(props.getName());

        if (isExist.isPresent()) {
            throw new IllegalArgumentException("User already exist");
        }

        User user = userRepository.save(props.hashPassword(passwordEncoder).toEntity());

        return ResponseWithIdDTO.builder().id(user.getId()).build();
    }

    public void updateUser(String id, UpsertUserDTO props) {
        this.getUser(id);
        props.hashPassword(passwordEncoder);
        userRepository.save(props.toEntity());
    }

    public void deleteUser(String id) {
        this.getUser(id);
        userRepository.deleteById(id);
    }
}
