package com.example.task_manager.controllers;

import com.example.task_manager.entities.AppUser;
import com.example.task_manager.services.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AppUserController {

private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping()
    public ResponseEntity<Object> getAllAppUsers(){
        var appUsers = appUserService.getAllAppUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(appUsers);
    }

    @GetMapping("{appUserId}")
    public ResponseEntity<AppUser> getAppUserById(@PathVariable Integer appUserId){
        var appUser = appUserService.getAppUserById(appUserId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(appUser);
    }
}
