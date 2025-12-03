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

    /**
     * POST /api/auth/login
     * Đăng nhập thủ thư
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        // TODO: Extract username and password from request body
        // TODO: Validate username and password (not null, not empty)
        // TODO: Implement logic to authenticate librarian
        // TODO: Generate JWT token or session (if needed)
        // TODO: Return librarian info and token
        // TODO: Return 401 Unauthorized if credentials are invalid
        // TODO: Handle SQL injection prevention (already handled by PreparedStatement)
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * POST /api/auth/logout
     * Đăng xuất thủ thư
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        // TODO: Invalidate session or token
        // TODO: Return success response
        return ResponseEntity.ok().build();
    }

    /**
     * GET /api/auth/me
     * Lấy thông tin thủ thư hiện tại (nếu đã đăng nhập)
     */
    @GetMapping("/me")
    public ResponseEntity<Librarian> getCurrentLibrarian() {
        // TODO: Get current librarian from session/token
        // TODO: Return librarian info
        // TODO: Return 401 Unauthorized if not logged in
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }
}

