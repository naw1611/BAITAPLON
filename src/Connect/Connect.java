/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;
import  java.sql.*;
/**
 *
 * @author luong
 */
public class Connect {
     public Connection con;

    public Connect() throws ClassNotFoundException,
            SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");//nap trinh dieu khien
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mln_quanlymaytinh", "root", ""); //thuc hien ket noi
    }

    public ResultSet GetData(String tbName) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select * from " + tbName + " ";
        kq = statement.executeQuery(sql);
        return kq;
    }

    public ResultSet GetData_TK(String ID) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "SELECT * FROM `products` WHERE `ID`='" + ID + "'";
        kq = statement.executeQuery(sql);
        return kq;
    }

    public ResultSet Getdata_Sluong(int sl) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();

        String sql = "SELECT * FROM `products` WHERE Number <= " + sl + "";
        kq = statement.executeQuery(sql);
        return kq;
    } 
    public void Update(String id, String name, int number) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Update Products set Name='" + name + "' where ID = '" + id + "'";
        String sql2 = "Update Products set Number=" + number + " where ID = '" + id + "'";
        sta.executeUpdate(sql1);
        sta.executeUpdate(sql2);
    }

    public void Insert(String id, String name, int number) throws SQLException {
      //Bổ sung sản phẩm
        Statement sta = this.con.createStatement();
        String sql1 = "Insert Products values('" + id + "','" + name + "'," + number + ")";
        sta.executeUpdate(sql1);
    }
    public void Insert(String id, String name, String pass) throws SQLException {

        Statement sta = this.con.createStatement();
        String sql1 = "Insert user values('" + id + "','" + name + "'," + pass + ")";
        sta.executeUpdate(sql1);
    }
    public void Delete(String id) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "DELETE FROM `products` WHERE ID = '" + id + "'";
        sta.executeUpdate(sql);
    }

}
