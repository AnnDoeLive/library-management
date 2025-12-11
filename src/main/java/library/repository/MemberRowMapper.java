package library.repository;
import library.model.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class MemberRowMapper implements RowMapper<Member> {

        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member m = new Member();
            m.setId(rs.getInt("id"));
            m.setName(rs.getString("name"));
            m.setEmail(rs.getString("email"));
            m.setPhone(rs.getString("phone"));
            return m;
        }
    }


