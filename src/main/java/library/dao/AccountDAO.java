package library.dao;

import java.sql.*;

public class AccountDAO {

    public boolean login(String email, String password) {
        String sql = "SELECT 1 FROM account WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // có record là đúng

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
