package com.fortlom.account.interfaces.controllers;
import com.fortlom.account.domain.UserAggregate.entity.UserAccount;
import com.fortlom.account.domain.UserAggregate.service.UserAccountService;
import com.fortlom.account.interfaces.dto.useraccoount.UpdatePersonResource;
import com.fortlom.account.interfaces.dto.useraccoount.UserAccountResource;
import com.fortlom.account.interfaces.mapping.entity.FanaticMapper;
import com.fortlom.account.interfaces.mapping.entity.UserAccountMapper;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/userservice/users")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserAccountMapper mapper;
    @GetMapping("/check/{userId}")
    public boolean existsartistid(@PathVariable("userId") Long userId){
        return userAccountService.existsById(userId);
    }
    @GetMapping("{userId}")
    public UserAccountResource getArtistById(@PathVariable("userId") Long userId) {
        return mapper.toResource(userAccountService.getById(userId));
    }
    @ApiOperation(value="getUserByUsername",notes = "Esta consulta nos retorna un usuario segun su nombre de usuario")
    @GetMapping("/users/Username/{username}")
    public UserAccountResource getUserByUsername(@PathVariable("username") String username) {
        return mapper.toResource(userAccountService.getByUsername(username));
    }
    @ApiOperation(value="updateprofile",notes = "Esta consulta nos actualiza la informacion del perfil del usuario segun el id de este")
    @PutMapping("/changeprofile/{userId}")
    public UserAccountResource updateprofile(@PathVariable Long userId, @RequestBody UpdatePersonResource request) {
        return mapper.toResource(userAccountService.updateprofile(userId, mapper.toModel(request)));
    }
    @ApiOperation(value="updatepassword",notes = "Esta consulta nos actualiza la contraseña del usuario segun el id de este")
    @PutMapping("/changepassword/{userId}")
    public UserAccountResource updatepassword(@PathVariable Long userId, @RequestBody UpdatePersonResource request) {
        return mapper.toResource(userAccountService.updatepassword(userId, mapper.toModel(request)));
    }
}
