package library.service;

import library.dao.AccountDAO;
import library.dao.MemberDAO;
import library.model.Member;

public class LoginService {

    private AccountDAO accountDAO = new AccountDAO();
    private MemberDAO memberDAO = new MemberDAO();

    public Member login(String email, String password) {

        // kiểm tra account trước
        if (!accountDAO.login(email, password)) {
            return null;
        }

        // lấy thông tin member theo email
        return memberDAO.findByEmail(email);
    }
}
