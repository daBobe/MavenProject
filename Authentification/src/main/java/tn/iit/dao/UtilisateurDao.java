package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.glid23.auth.model.UtilisateurModel;
import tn.iit.utils.JDBCUtils;

public class UtilisateurDao implements IUtilisateurDao {

    @Override
    public UtilisateurModel getByLoginPdw(String login, String pwd) {
        UtilisateurModel user = null;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND password = ?")) {

            pstmt.setString(1, login);
            pstmt.setString(2, pwd);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = createUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle appropriately
        }
        return user;
    }

    @Override
    public List<UtilisateurModel> findAll() {
        List<UtilisateurModel> users = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM utilisateur");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                users.add(createUserFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle appropriately
        }
        return users;
    }

    @Override
    public void save(UtilisateurModel user) {
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO utilisateur (name, lastName, email, role, password) VALUES (?, ?, ?, ?, ?)")) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getRole());
            pstmt.setString(5, user.getPassword());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle appropriately
        }
    }

    private UtilisateurModel createUserFromResultSet(ResultSet rs) throws SQLException {
        return new UtilisateurModel(
                rs.getString("name"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getString("role"),
                rs.getString("password")
        );
    }
}
