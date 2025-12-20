package library.controller;

import library.model.Librarian;
import library.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {

        return ResponseEntity.ok(null);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {

        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<Librarian> getCurrentLibrarian() {

        return ResponseEntity.ok(null);
    }
}

