package gad_management;

import java.sql.*;

public class storage {

    public static String main_id;
    public static int client_order_id;

    public static void order_count() {
        Connection con = null;
        Statement stmt = null;
        Statement stmt1 = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mypharma", "postgres",
                    "admin");
            stmt = con.createStatement();
            stmt1 = con.createStatement();
            // String sql1 = "delete from Store where store_username = 'Ram';";
            String sql = "select distinct(order_id) from orders order by order_id;";

            ResultSet res = stmt1.executeQuery(sql);
            while (res.next()) {
                client_order_id = res.getInt(1);
            }
            stmt.close();
            if (con != null) {
                System.out.println("Connected");
            }

        } catch (Exception es) {
            System.out.println(es.getMessage());

        }
    }

    public static void order_incre() {
        order_count();
        Connection con = null;
        Statement stmt = null;
        Statement stmt1 = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mypharma", "postgres",
                    "admin");
            stmt = con.createStatement();
            stmt1 = con.createStatement();
            // String sql1 = "delete from Store where store_username = 'Ram';";
            String sql = "insert into orders values(" + (client_order_id + 1) + ");";

            ResultSet res = stmt1.executeQuery(sql);
            while (res.next()) {
                client_order_id = res.getInt(1);
            }
            stmt.close();
            if (con != null) {
                System.out.println("Connected");
            }

        } catch (Exception es) {
            System.out.println(es.getMessage());

        }
    }

    public static void main(String[] args) {
        order_incre();

    }

}
