package library.service;

import library.dao.MemberDAO;
import library.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public List<Member> getAllMembers() {
        // TODO: Implement logic to get all members
        return null;
    }

    @Override
    public Member getMemberById(int id) {
        // TODO: Implement logic to get member by id
        return null;
    }

    @Override
    public Member createMember(Member member) {
        // TODO: Validate member data
        // TODO: Check for duplicate email
        // TODO: Implement logic to create member
        return null;
    }

    @Override
    public Member updateMember(int id, Member member) {
        // TODO: Validate member data
        // TODO: Check if member exists
        // TODO: Check for duplicate email (if updating email)
        // TODO: Implement logic to update member
        return null;
    }

    @Override
    public boolean deleteMember(int id) {
        // TODO: Check if member has active loans
        // TODO: Implement logic to delete member
        return false;
    }

    @Override
    public Member getMemberByEmail(String email) {
        // TODO: Implement logic to get member by email
        return null;
    }

    @Override
    public List<?> getMemberLoans(int memberId) {
        // TODO: Implement logic to get member loans
        return null;
    }
}

