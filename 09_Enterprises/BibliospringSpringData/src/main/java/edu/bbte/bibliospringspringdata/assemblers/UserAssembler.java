package edu.bbte.bibliospringspringdata.assemblers;

import edu.bbte.bibliospringspringdata.dto.incoming.UserInDTO;
import edu.bbte.bibliospringspringdata.dto.outgoing.UserOutDTO;
import edu.bbte.bibliospringspringdata.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

    public User userInDtoToModel(UserInDTO userInDTO) {
        User user = new User();
        user.setUsername(userInDTO.getUsername());
        user.setPassword(userInDTO.getPassword());
        return user;
    }

    public UserOutDTO modelToUserOutDto(User user) {
        UserOutDTO userOutDTO = new UserOutDTO();
        userOutDTO.setUid(user.getUuid());
        userOutDTO.setId(user.getId());
        userOutDTO.setUsername(user.getUsername());
        return userOutDTO;
    }
}
