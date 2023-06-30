package ru.mirea.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.admin.dto.UserDto;
import ru.mirea.admin.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {


    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getList());
    }

    @PostMapping
    ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok(String.valueOf(true));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleted(id);
        return ResponseEntity.ok(String.valueOf(true));
    }
}
