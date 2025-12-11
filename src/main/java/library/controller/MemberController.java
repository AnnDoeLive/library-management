package library.controller;

import library.model.Loan;
import library.model.Member;
import library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String deleteMember(@PathVariable int id) {
        boolean ok = memberService.deleteMember(id);

        return ok ? "Deleted" : "Member still has active loans!";
    }

    // 6) GET search by email
    @GetMapping("/search")
    public Member findByEmail(@RequestParam String email) {
        return memberService.findByEmail(email);
    }

    // 7) GET member loans
    @GetMapping("/{id}/loans")
    public List<Loan> getMemberLoans(@PathVariable int id) {
        return memberService.getLoansByMember(id);
    }
}
