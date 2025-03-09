
import pe.Certificate.CertificateDAO;
import pe.Certificate.CertificateDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bacda
 */
public class Test {
    public static void main(String[] args) {
      CertificateDAO dao = new CertificateDAO();
      CertificateDTO c = dao.getDetail("1");
        System.out.println(c);
    }
}
