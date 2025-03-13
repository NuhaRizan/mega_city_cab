package test;

import com.Mega_City_Cab.dao.CusRegDAO;
import com.Mega_City_Cab.model.User;
import com.Mega_City_Cab.utils.DBConnection;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class CusRegDAOTest {
    private static Connection connection;
    private CusRegDAO dao;

    @BeforeAll
    public static void setupDatabase() throws SQLException {
        connection = DBConnection.getConnection();
        assertNotNull(connection, "Database connection should be established");
    }

    @BeforeEach
    public void setup() {
        dao = new CusRegDAO();
    }

    @Test
    public void testRegisterUser() {
        User user = new User(0, "testUser", "password123", "test@example.com");
        assertTrue(dao.registerUser(user), "User registration should be successful");

        // Cleanup test user after insertion
        deleteTestUser("test@example.com");
    }

    @Test
    public void testValidateUserSuccess() {
        // First, insert a user to validate
        User user = new User(0, "testUser", "password123", "test@example.com");
        dao.registerUser(user);

        // Now validate the user
        User retrievedUser = dao.validateUser("testUser", "password123");
        assertNotNull(retrievedUser, "User should be found in database");
        assertEquals("testUser", retrievedUser.getUsername(), "Username should match");

        // Cleanup test user
        deleteTestUser("test@example.com");
    }

    @Test
    public void testValidateUserFailure() {
        User user = dao.validateUser("wrongUser", "wrongPass");
        assertNull(user, "User should not be found in database");
    }

    // Utility method to delete test users
    private void deleteTestUser(String email) {
        String deleteQuery = "DELETE FROM user WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void closeDatabase() throws SQLException {
        connection.close();
    }
}
