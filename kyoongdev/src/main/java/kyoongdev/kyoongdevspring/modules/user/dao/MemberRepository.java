package kyoongdev.kyoongdevspring.modules.user.dao;


import java.util.List;
import kyoongdev.kyoongdevspring.modules.user.dto.UpsertUserDTO;
import kyoongdev.kyoongdevspring.modules.user.dto.UserDTO;

public interface MemberRepository {

  Long create(UpsertUserDTO member);

  List<UserDTO> getAll();

  UserDTO getOne(Long id);

  void update(Long id, UpsertUserDTO member);

  void delete(Long id);

}