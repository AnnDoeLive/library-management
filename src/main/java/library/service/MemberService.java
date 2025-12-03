package library.service;

import library.model.Member;
import java.util.List;

public interface MemberService {
    // TODO: Implement all methods
    
    List<Member> getAllMembers();
    Member getMemberById(int id);
    Member createMember(Member member);
    Member updateMember(int id, Member member);
    boolean deleteMember(int id);
    Member getMemberByEmail(String email);
    List<?> getMemberLoans(int memberId);
}

