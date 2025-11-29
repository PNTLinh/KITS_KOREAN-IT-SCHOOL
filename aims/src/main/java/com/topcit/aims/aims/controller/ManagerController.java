package com.topcit.aims.aims.controller;

import com.topcit.aims.aims.dto.request.ManagerCreationRequest;
import com.topcit.aims.aims.entity.Manager;
import com.topcit.aims.aims.entity.Order;
import com.topcit.aims.aims.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    @GetMapping
    public List<Manager> getAllManagers(){
        return managerService.getAllManagers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Integer id){
        return managerService.getManagerById(id)
                .map(ResponseEntity:: ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{email}")
    public ResponseEntity<Manager> getManagerByEmail(@PathVariable String email){
        return  managerService.getManagerByEmail(email)
                .map(ResponseEntity:: ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Manager> createManager(@RequestBody ManagerCreationRequest request){
        Manager saved = managerService.createManager(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Integer id, @RequestBody Manager updateManager){
        try{
            return ResponseEntity.ok(managerService.updateManager(id, updateManager));
        }catch(RuntimeException  e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManagerByID(@PathVariable Integer id) {
        managerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
    // Xóa khach hàng bằng Email
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteManagerByEmail(@PathVariable String email){
        managerService.deleteManagerByEmail(email);
        return ResponseEntity.noContent().build();
    }

}
