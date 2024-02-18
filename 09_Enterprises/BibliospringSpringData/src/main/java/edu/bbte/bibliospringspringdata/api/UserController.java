package edu.bbte.bibliospringspringdata.api;

import edu.bbte.bibliospringspringdata.api.exception.NotFoundException;
import edu.bbte.bibliospringspringdata.assemblers.UserAssembler;
import edu.bbte.bibliospringspringdata.dto.incoming.UserInDTO;
import edu.bbte.bibliospringspringdata.dto.outgoing.UserOutDTO;
import edu.bbte.bibliospringspringdata.model.User;
import edu.bbte.bibliospringspringdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAssembler userAssembler;

    @GetMapping
    public List<UserOutDTO> getAll() {
        ArrayList<UserOutDTO> userOutDTOArrayList = new ArrayList<>();
        List<User> userList = userService.getAll();

        for (User user : userList) {
            userOutDTOArrayList.add(userAssembler.modelToUserOutDto(user));
        }
        return userOutDTOArrayList;
    }

    @GetMapping(path = "/{id}")
    public UserOutDTO getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user == null) {
            throw new NotFoundException(User.class, id);
        }
        return userAssembler.modelToUserOutDto(user);
    }

    @PostMapping
    public ResponseEntity<UserOutDTO> registerUser(@RequestBody UserInDTO userInDTO) {
        UserOutDTO userOutDTO = userAssembler
                .modelToUserOutDto(userService
                        .create(userAssembler
                                .userInDtoToModel(userInDTO)));
        URI uri = URI.create("/users/" + userOutDTO.getId());
        return ResponseEntity.created(uri).body(userOutDTO);
    }
}
