import java.sql.*;

public class HospitalDAO {

    // CREATE
    public void addPatient(Hospital h) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "INSERT INTO patients(patient_id,name,age,disease,doctor_assigned,bill_amount) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, h.patient_id);
            ps.setString(2, h.name);
            ps.setInt(3, h.age);
            ps.setString(4, h.disease);
            ps.setString(5, h.doctor_assigned);
            ps.setDouble(6, h.bill_amount);

            ps.executeUpdate();

            System.out.println("Patient Added Successfully");

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    // READ ALL (FIXED NAME)
    public void viewPatients() {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM patients";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("patient_id") + " | "
                        + rs.getString("name") + " | "
                        + rs.getInt("age") + " | "
                        + rs.getString("disease") + " | "
                        + rs.getString("doctor_assigned") + " | "
                        + rs.getDouble("bill_amount")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    // READ BY ID (FIXED TABLE)
    public void getPatientById(int id) {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM patients WHERE patient_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("patient_id") + " | "
                        + rs.getString("name") + " | "
                        + rs.getInt("age") + " | "
                        + rs.getString("disease") + " | "
                        + rs.getString("doctor_assigned") + " | "
                        + rs.getDouble("bill_amount")
                );
            } else {
                System.out.println("Patient not found");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    // DELETE (FIXED TABLE)
    public void deletePatient(int id) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "DELETE FROM patients WHERE patient_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Patient Deleted");

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    // UPDATE DISEASE
    public void updateDisease(int id, String disease) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE patients SET disease=? WHERE patient_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, disease);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Disease Updated");

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    // UPDATE DOCTOR
    public void updateDoctor(int id, String doctor) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE patients SET doctor_assigned=? WHERE patient_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, doctor);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Doctor Updated");

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    // UPDATE BILL
    public void updateBill(int id, double bill) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE patients SET bill_amount=? WHERE patient_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, bill);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Bill Updated");

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    // ADD BILL (CREDIT)
    public void addBill(int id, double amount) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE patients SET bill_amount = bill_amount + ? WHERE patient_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Bill Added");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // PAY BILL (FIXED → MINUS)
    public void payBill(int id, double amount) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE patients SET bill_amount = bill_amount - ? WHERE patient_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Payment Done");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}