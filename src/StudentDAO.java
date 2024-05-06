import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
    private final IDBAdapter dbAdapter = new DBFactory().getDefaultDBAdapter();


    public List<Student> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = dbAdapter.getConnection();
            statement = connection.prepareStatement(
                    "SELECT nocontrol, fullname, career, curp, currentgrade " +
                       " FROM student "
            );
            results = statement.executeQuery();
            while (results.next()) {
                students.add(new Student(
                        results.getString(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getInt(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public boolean save(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dbAdapter.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO student(nocontrol, fullname, career, curp, currentgrade) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, student.nocontrol());
            statement.setString(2, student.fullname());
            statement.setString(3, student.career());
            statement.setString(4, student.curp());
            statement.setInt(5, student.currentgrade());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
