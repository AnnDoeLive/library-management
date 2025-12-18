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

    @PostMapping("")
    public ResponseEntity<?> createLoan(@RequestBody Loan loan) {
        Loan created = loanService.createLoan(loan);
        if (created != null) {
            return ResponseEntity.ok(created);
        }
        return ResponseEntity.badRequest().body("Create loan failed");
    }

    @GetMapping("/member/search")
    public ResponseEntity<List<Loan>> getLoansByMemberName(@RequestParam String name) {
        List<Loan> loans = loanService.getLoansByMemberName(name);
        return ResponseEntity.ok(loans);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Implement logic to get loan by id
        // TODO: Return 404 if loan not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

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


    @GetMapping("/active")
    public ResponseEntity<List<Loan>> getActiveLoans() {
        // TODO: Implement logic to get all active loans (status = "Borrowed")
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }


    @GetMapping("/overdue")
    public ResponseEntity<List<Loan>> getOverdueLoans() {
        // TODO: Implement logic to get overdue loans (returnDate < currentDate AND status = "Borrowed")
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }


    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Loan>> getLoansByBookId(@PathVariable int bookId) {
        // TODO: Validate bookId parameter
        // TODO: Check if book exists
        // TODO: Implement logic to get loans by bookId
        // TODO: Return 404 if book not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

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

