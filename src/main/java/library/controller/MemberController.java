package library.controller;

import library.model.Member;
import library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * GET /api/members
     * Lấy danh sách tất cả thành viên
     */
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        // TODO: Implement logic to get all members
        // TODO: Handle exceptions and return appropriate HTTP status
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/members/{id}
     * Lấy thông tin thành viên theo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Implement logic to get member by id
        // TODO: Return 404 if member not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * POST /api/members
     * Thêm thành viên mới
     */
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        // TODO: Validate member data (name, email, phone)
        // TODO: Validate email format
        // TODO: Validate phone format
        // TODO: Check for duplicate email (if unique constraint exists)
        // TODO: Implement logic to insert member
        // TODO: Return created member with generated ID
        // TODO: Handle validation errors and return 400 Bad Request
        // TODO: Handle duplicate email and return 409 Conflict
        // TODO: Handle database errors and return 500 Internal Server Error
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    /**
     * PUT /api/members/{id}
     * Cập nhật thông tin thành viên
     */
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member member) {
        // TODO: Validate id parameter
        // TODO: Validate member data
        // TODO: Check if member exists
        // TODO: Check for duplicate email (if updating email)
        // TODO: Implement logic to update member
        // TODO: Return 404 if member not found
        // TODO: Return updated member
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * DELETE /api/members/{id}
     * Xóa thành viên
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Check if member exists
        // TODO: Check if member has active loans (business rule)
        // TODO: Implement logic to delete member
        // TODO: Return 404 if member not found
        // TODO: Return 409 Conflict if member has active loans
        // TODO: Handle exceptions
        return ResponseEntity.noContent().build();
    }

    /**
     * GET /api/members/search?email={email}
     * Tìm kiếm thành viên theo email
     */
    @GetMapping("/search")
    public ResponseEntity<Member> searchMemberByEmail(@RequestParam String email) {
        // TODO: Validate email parameter
        // TODO: Validate email format
        // TODO: Implement logic to search member by email
        // TODO: Return 404 if member not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/members/{id}/loans
     * Lấy danh sách phiếu mượn của thành viên
     */
    @GetMapping("/{id}/loans")
    public ResponseEntity<?> getMemberLoans(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Check if member exists
        // TODO: Implement logic to get all loans of member
        // TODO: Return 404 if member not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }
}

