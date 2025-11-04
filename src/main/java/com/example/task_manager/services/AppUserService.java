package com.example.task_manager.services;

import com.example.task_manager.entities.AppUser;
import com.example.task_manager.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllAppUsers(){
        return appUserRepository.findAll();
    }

    public AppUser getAppUserById(Integer appUserId){
        return appUserRepository.findById(appUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
