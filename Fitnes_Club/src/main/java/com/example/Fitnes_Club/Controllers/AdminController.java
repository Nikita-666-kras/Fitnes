package com.example.Fitnes_Club.Controllers;

import com.example.Fitnes_Club.dal.DataAccessLayer;
import com.example.Fitnes_Club.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/authorized")
public class AdminController {

    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public AdminController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
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
    @DeleteMapping("delete/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") long id) {
        dataAccessLayer.deleteUser(id);
        return ResponseEntity.ok("User номер " + id + " больше не Hru");
    }
    @PostMapping("update/user/{id}")
    public ResponseEntity updateUserById(@PathVariable("id") long id, @RequestBody User updatedUser) {
        dataAccessLayer.updateUser(id, updatedUser);
        return ResponseEntity.ok("");
    }
    @GetMapping("get/user/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getUser(id));
    }
    @PostMapping("set/user/img")
    public ResponseEntity newImgToDatbase(@RequestBody User user) {
        log.info(user.getName());
        dataAccessLayer.newImgToDatbase(user);
        return ResponseEntity.ok("Ура картинка!");
    }
    @GetMapping("get/workoutsId/")
    public ResponseEntity getWorkoutsID() {
        return ResponseEntity.ok(dataAccessLayer.getWorkoutsID());
    }
    @GetMapping("get/workouts/{id}")
    public ResponseEntity getWorkoutsById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getWorkouts(id));
    }
    @GetMapping("get/workouts/")
    public ResponseEntity getWorkouts() {
        return ResponseEntity.ok(dataAccessLayer.getWorkouts());
    }

    @GetMapping("get/exercises/")
    public ResponseEntity getExercise() {
        return ResponseEntity.ok(dataAccessLayer.getExercise());
    }

    @GetMapping("get/exercises/{id}")
    public ResponseEntity getExercisesById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getExercises(id));
    }
    @GetMapping("/train/workouts/{workoutsId}")
    public List<Train> getTrainByWorkoutsId(@PathVariable Long workoutsId) {
        return dataAccessLayer.getTrainByWorkoutsId(workoutsId);
    }
    @GetMapping("/get/train/{userId}")

    public ResponseEntity<List<Train>> getBasketsByUserId(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(dataAccessLayer.getBasketsByUserId(userId));
    }

    @PostMapping("create/exercises/")
    public ResponseEntity<String> createExercises(@RequestBody Exercises exercises) {
        dataAccessLayer.createExercise(exercises);
        return ResponseEntity.ok("PABEDA!");
    }
    @PostMapping("create/train/")
    public ResponseEntity<String> createTrain(@RequestBody Train train) {
        dataAccessLayer.createTrain(train);
        return ResponseEntity.ok("PABEDA!");
    }
    @DeleteMapping("delete/exercises/{id}")
    public ResponseEntity deleteExercisesById(@PathVariable("id") long id) {
        dataAccessLayer.deleteExercises(id);
        return ResponseEntity.ok("Cage номер " + id + " больше не Hru");
    }

    @PostMapping("update/exercises/{id}")
    public ResponseEntity updateExercisesById(@PathVariable("id") long id, @RequestBody Exercises updatedExercises) {
        dataAccessLayer.updateExercises(id, updatedExercises);
        return ResponseEntity.ok("");
    }




    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    public void someMethod() {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
    }
}