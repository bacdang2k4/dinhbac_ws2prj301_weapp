package pe.Certificate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

public class CertificateDAO {

    public List<CertificateDTO> getAllCertificate() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CertificateDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM Certificates ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CertificateDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4)));
            }

        } catch (Exception e) {

        }

        return list;
    }

    public CertificateDTO getDetail(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Certificates WHERE CertificateID = ? ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new CertificateDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void delete(String id) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM Certificates WHERE CertificateID = ? ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void create(String id, String name, String issuer, String issuedate) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO Certificates VALUES(?,?,?,?) ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, issuer);
            ps.setString(4, issuedate);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void update(String id, String name, String issuer, String issuedate) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE Certificates \n"
                + "SET\n"
                + " CertificateName = ?\n"
                + " ,IssueDate= ?\n"
                + ",Issuer = ? WHERE CertificateID = ?";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, issuedate);
            ps.setString(3, issuer);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getMaxCertificateId() {
        int maxId = 0;
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT MAX(CertificateID) FROM Certificates";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1);
            }

        } catch (Exception e) {
        }
        return maxId;
    }

    public List<CertificateDTO> search(String keyword) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CertificateDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM Certificates WHERE CertificateName LIKE ? OR CAST(IssueDate AS CHAR) LIKE ? ";

        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, "%" + keyword +"%");
            ps.setString(2, "%" + keyword +"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CertificateDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4)));
            }

        } catch (Exception e) {

        }

        return list;
    }
}
