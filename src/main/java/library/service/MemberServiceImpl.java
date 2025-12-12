package library.service;

import library.dao.MemberDAO;
import library.model.Loan;
import library.model.Member;
import library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repo;

    @Override
    public List<Member> getAllMembers() {
        return repo.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return repo.findById(id);
    }

    @Override
    public Member createMember(Member member) {
        repo.save(member);
        return member;
    }

    @Override
    public Member updateMember(int id, Member member) {
        Member existing = repo.findById(id);
        if (existing == null) return null;

        repo.update(id, member);
        return member;
    }

    @Override
    public boolean deleteMember(int id) {
        if (repo.hasActiveLoans(id)) return false;
        return repo.delete(id) > 0;
    }

    @Override
    public List<Member> findByName(String name) {
        return MemberDAO.findByName(name);
    }



    @Override
    public boolean hasActiveLoans(int id) {
        return repo.hasActiveLoans(id);
    }

    @Override
    public List<Loan> getLoansByMember(int id) {
        return repo.findLoans(id);
    }
}
