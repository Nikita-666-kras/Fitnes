package com.example.Fitnes_Club.Controllers;
import com.example.Fitnes_Club.dal.DataAccessLayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
//переписывать текст с доски это тяжело...