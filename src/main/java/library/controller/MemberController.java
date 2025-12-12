package library.controller;

import library.model.Loan;
import library.model.Member;
import library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 1) GET all
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // 2) GET by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable int id) {
        return memberService.getMemberById(id);
    }

    // 3) POST - create new member
    @PostMapping
    public Member createMember(@RequestBody Member m) {
        return memberService.createMember(m);
    }

    // 4) PUT - update member
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable int id, @RequestBody Member m) {
        return memberService.updateMember(id, m);
    }

    // 5) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable int id) {
        boolean deleted = memberService.deleteMember(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Member with id " + id + " not found");
        }

        return ResponseEntity.ok("Member deleted successfully");
    }



    @GetMapping("/search")
    public ResponseEntity<List<Member>> searchByName(@RequestParam String name) {
        System.out.println("Searching member: " + name);
        List<Member> result = memberService.findByName(name);
        return ResponseEntity.ok(result);
    }


    // 7) GET member loans
    @GetMapping("/{id}/loans")
    public List<Loan> getMemberLoans(@PathVariable int id) {
        return memberService.getLoansByMember(id);
    }
}
