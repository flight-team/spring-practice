package kyoongdev.kyoongdevspring.modules.user.mapper;

import javax.annotation.processing.Generated;
import kyoongdev.kyoongdevspring.modules.user.dto.UpdateUserDTO;
import kyoongdev.kyoongdevspring.modules.user.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T00:33:59+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public void updateUserFromRequest(UpdateUserDTO updateUserDTO, User user) {
        if ( updateUserDTO == null ) {
            return;
        }

        if ( updateUserDTO.getName() != null ) {
            user.setName( updateUserDTO.getName() );
        }
        if ( updateUserDTO.getEmail() != null ) {
            user.setEmail( updateUserDTO.getEmail() );
        }
        if ( updateUserDTO.getPassword() != null ) {
            user.setPassword( updateUserDTO.getPassword() );
        }
    }
}
