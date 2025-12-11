package library.service;

import library.model.Loan;
import library.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();
    Member getMemberById(int id);
    Member createMember(Member member);
    Member updateMember(int id, Member member);
    boolean deleteMember(int id);

    Member findByEmail(String email);

    boolean hasActiveLoans(int id);

    List<Loan> getLoansByMember(int id);
}
