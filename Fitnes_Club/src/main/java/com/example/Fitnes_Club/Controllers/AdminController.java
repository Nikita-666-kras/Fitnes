package com.example.Fitnes_Club.Controllers;
import com.example.Fitnes_Club.dal.DataAccessLayer;
import com.example.Fitnes_Club.dto.SignupRequest;
import com.example.Fitnes_Club.models.Coach;
import com.example.Fitnes_Club.models.User;
import com.example.Fitnes_Club.models.Workouts;
import com.example.Fitnes_Club.security.JwtCore;
import com.example.Fitnes_Club.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Set;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/admin")
public class AdminController {
    private final UserDetailsServiceImpl userService;
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public AdminController(UserDetailsServiceImpl userService, DataAccessLayer dataAccessLayer) {
        this.userService = userService;
        this.dataAccessLayer = dataAccessLayer;
    }
    @Autowired
    private JwtCore jwtCore;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/user")
    public void user() {
        log.info("Gracias Senior user");
    }

    @GetMapping("/admin")
    public void admin() {
        log.info("Gracias Senior admin");
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createAdmin(@RequestBody SignupRequest signupRequest) {
        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        signupRequest.setRoles(Set.of("ROLE_ADMIN"));
        String serviceResult = userService.newUser(signupRequest);
        if (Objects.equals(serviceResult, "Выберите другое имя")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        if (Objects.equals(serviceResult, "Выберите другую почту")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        return ResponseEntity.ok("Администратор успешно создан.");
    }




    @PostMapping("create/coach/")
    public ResponseEntity<String> createCoach(@RequestBody Coach coach) {
        dataAccessLayer.createCoach(coach);
        return ResponseEntity.ok("PABEDA!");
    }

    @DeleteMapping("delete/coach/{id}")
    public ResponseEntity deleteCoachById(@PathVariable("id") long id) {
        dataAccessLayer.deleteCoach(id);
        return ResponseEntity.ok("свина больше нет увы");
    }

    @PostMapping("update/coach/{id}")
    public ResponseEntity updateCoachById(@PathVariable("id") long id, @RequestBody Coach newCoach) {
        dataAccessLayer.updateCoach(id, newCoach);
        return ResponseEntity.ok("у свиньи рестайлинг");
    }

    @PostMapping("create/workouts/")
    public ResponseEntity<String> createWorkouts(@RequestBody Workouts workouts) {
        dataAccessLayer.createWorkouts(workouts);
        return ResponseEntity.ok("PABEDA!");
    }
    @DeleteMapping("delete/workouts/{id}")
    public ResponseEntity deleteWorkoutsById(@PathVariable("id") long id) {
        dataAccessLayer.deleteWorkouts(id);
        return ResponseEntity.ok("Position номер "+ id + " больше не Hru");
    }
    @PostMapping("update/workouts/{id}")
    public ResponseEntity updateWorkoutsById(@PathVariable("id") long id, @RequestBody Workouts updatedWorkouts) {
        dataAccessLayer.updateWorkouts(id, updatedWorkouts);
        return ResponseEntity.ok("");
    }

    @PostMapping("create/user/")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        dataAccessLayer.createUser(user);
        return ResponseEntity.ok("PABEDA!");
    }

}