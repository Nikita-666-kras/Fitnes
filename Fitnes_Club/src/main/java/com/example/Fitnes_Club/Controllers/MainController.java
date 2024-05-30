package com.example.Fitnes_Club.Controllers;
import com.example.Fitnes_Club.dal.DataAccessLayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/unauthorized")
public class MainController {
    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @GetMapping("/hello")
    public void hello() {
        log.info("Gracias Senior Pumba");
    }

    @GetMapping("/user")
    public void user() {
        log.info("Gracias Senior user");
    }

    @GetMapping("/admin")
    public void admin() {
        log.info("Gracias Senior admin");
    }

    @GetMapping("get/coach/{id}")
    public ResponseEntity getCoachById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getCoach(id));
    }

    @GetMapping("get/coach/")
    public ResponseEntity getCoach() {
        return ResponseEntity.ok(dataAccessLayer.getCoach());
    }







    @GetMapping("get/clients/{id}")
    public ResponseEntity getClientsById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getClients(id));
    }

    @GetMapping("get/clients/")
    public ResponseEntity getClients() {
        return ResponseEntity.ok(dataAccessLayer.getClients());
    }

    @GetMapping("get/users/")
    public ResponseEntity getUsers() {
        System.out.println("pop");
        return ResponseEntity.ok(dataAccessLayer.getUsers());
    }


    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    public void someMethod() {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
    }

}
//переписывать текст с доски это тяжело...