package kyoongdev.kyoongdevspring.modules.user.dto;

import kyoongdev.kyoongdevspring.modules.user.entity.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UpsertUserDTO {

    private String name;
    private String email;

    private String password;

    public UpsertUserDTO hashPassword(PasswordEncoder passwordEncoder) {
        if (this.password != null) {
            this.password = passwordEncoder.encode(this.password);
        }
        return this;
    }

    public boolean checkPassword(String plainPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(plainPassword, this.password);
    }

    public User toEntity() {
        return User.builder().email(this.email).name(this.name).password(this.password).build();
    }
}
