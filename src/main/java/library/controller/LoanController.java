package library.controller;

import library.model.Loan;
import library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    /**
     * POST /api/loans
     * Tạo phiếu mượn sách mới
     */
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        // TODO: Validate loan data (bookId, memberId, borrowDate, returnDate, status)
        // TODO: Check if book exists
        // TODO: Check if member exists
        // TODO: Check if book is available (quantity > 0)
        // TODO: Validate dates (returnDate must be after borrowDate)
        // TODO: Check if member has exceeded loan limit (business rule)
        // TODO: Implement logic to insert loan
        // TODO: Decrease book quantity by 1
        // TODO: Return created loan with generated ID
        // TODO: Handle validation errors and return 400 Bad Request
        // TODO: Handle book not available and return 409 Conflict
        // TODO: Handle database errors and return 500 Internal Server Error
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    /**
     * GET /api/loans
     * Lấy danh sách tất cả phiếu mượn
     */
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        // TODO: Implement logic to get all loans
        // TODO: Optionally include book and member details (join query)
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/loans/{id}
     * Lấy thông tin phiếu mượn theo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Implement logic to get loan by id
        // TODO: Return 404 if loan not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * PUT /api/loans/{id}/return
     * Trả sách (cập nhật status và returnDate)
     */
    @PutMapping("/{id}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Check if loan exists
        // TODO: Check if loan is already returned
        // TODO: Update returnDate to current date
        // TODO: Update status to "Returned"
        // TODO: Increase book quantity by 1
        // TODO: Calculate fine if overdue (business rule)
        // TODO: Return updated loan
        // TODO: Return 404 if loan not found
        // TODO: Return 400 if loan already returned
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/loans/active
     * Lấy danh sách phiếu mượn đang hoạt động (chưa trả)
     */
    @GetMapping("/active")
    public ResponseEntity<List<Loan>> getActiveLoans() {
        // TODO: Implement logic to get all active loans (status = "Borrowed")
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/loans/overdue
     * Lấy danh sách phiếu mượn quá hạn
     */
    @GetMapping("/overdue")
    public ResponseEntity<List<Loan>> getOverdueLoans() {
        // TODO: Implement logic to get overdue loans (returnDate < currentDate AND status = "Borrowed")
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/loans/book/{bookId}
     * Lấy danh sách phiếu mượn của một cuốn sách
     */
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Loan>> getLoansByBookId(@PathVariable int bookId) {
        // TODO: Validate bookId parameter
        // TODO: Check if book exists
        // TODO: Implement logic to get loans by bookId
        // TODO: Return 404 if book not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/loans/member/{memberId}
     * Lấy danh sách phiếu mượn của một thành viên
     */
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Loan>> getLoansByMemberId(@PathVariable int memberId) {
        // TODO: Validate memberId parameter
        // TODO: Check if member exists
        // TODO: Implement logic to get loans by memberId
        // TODO: Return 404 if member not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * PATCH /api/loans/{id}/extend
     * Gia hạn thời gian mượn sách
     */
    @PatchMapping("/{id}/extend")
    public ResponseEntity<Loan> extendLoan(@PathVariable int id, @RequestParam int days) {
        // TODO: Validate id parameter
        // TODO: Validate days parameter (must be positive)
        // TODO: Check if loan exists
        // TODO: Check if loan is already returned
        // TODO: Check if loan can be extended (business rule - max extensions?)
        // TODO: Update returnDate by adding days
        // TODO: Return updated loan
        // TODO: Return 404 if loan not found
        // TODO: Return 400 if loan already returned or cannot be extended
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/loans/{id}/fine
     * Tính tiền phạt cho phiếu mượn quá hạn
     */
    @GetMapping("/{id}/fine")
    public ResponseEntity<Double> calculateFine(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Check if loan exists
        // TODO: Check if loan is overdue
        // TODO: Calculate fine based on business rule (days overdue * fine per day)
        // TODO: Return fine amount
        // TODO: Return 404 if loan not found
        // TODO: Return 0 if loan is not overdue
        // TODO: Handle exceptions
        return ResponseEntity.ok(0.0);
    }
}

