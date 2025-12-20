package library.controller;

import library.model.Loan;
import library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PutMapping("/{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable int id) {
        Loan loan = loanService.returnBook(id);

        if (loan == null) {
            return ResponseEntity.status(404).body("Loan not found");
        }

        return ResponseEntity.ok(loan);
    }

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

        return ResponseEntity.ok(null);
    }


    @GetMapping("/active")
    public ResponseEntity<List<Loan>> getActiveLoans() {

        return ResponseEntity.ok(null);
    }


    @GetMapping("/overdue")
    public ResponseEntity<List<Loan>> getOverdueLoans() {

        return ResponseEntity.ok(null);
    }


    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Loan>> getLoansByBookId(@PathVariable int bookId) {

        return ResponseEntity.ok(null);
    }

    @PatchMapping("/{id}/extend")
    public ResponseEntity<Loan> extendLoan(@PathVariable int id, @RequestParam int days) {

        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}/fine")
    public ResponseEntity<Double> calculateFine(@PathVariable int id) {

        return ResponseEntity.ok(0.0);
    }
}

