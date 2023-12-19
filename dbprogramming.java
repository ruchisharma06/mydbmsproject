package dbProgramming.javaguide.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbprogramming {

private final String url = "jdbc:postgresql://localhost:5432/postgres";
	    private final String user = "postgres";
	    private final String pwd = "Ruchi@1994";

	    private Connection conn;

	    private void connect() {
	        try {
	            conn = DriverManager.getConnection(url, user, pwd);
	            conn.setAutoCommit(false);
	            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

	           
	         // Activity 1: Deleting product p1 from Product and Stock
	            String deleteStockProductSQL = "DELETE FROM product WHERE prodid = 'p1';";
	            executeUpdateQuery(deleteStockProductSQL);


		 // Activity 2: Deleting depot d1 from Depot and Stock
	            String deleteProductSQL = "DELETE FROM depot WHERE depid = 'd1';";
	            executeUpdateQuery(deleteProductSQL);


	//I have update cascade query on my database. so, I am updating in one table and it is getting updated in other one. I have updated the query.
			
	            // Activity 3: Changing product p1 name to pp1 in Product and Stock
	            String updateProductSQL = "UPDATE product SET pname = 'pp1' WHERE prodid = 'p1';";
	            executeUpdateQuery(updateProductSQL);

	         // Activity 4: Changing depot d1 name to dd1 in Depot and Stock
	            String updateDepotSQL = "UPDATE depot SET depid = 'dd1' WHERE depid = 'd1';";
	            executeUpdateQuery(updateDepotSQL);*/
	        

	            conn.commit(); // Commit the changes

	         // Activity 5: Adding a product (p100, cd, 5) in Product and (p100, d2, 50) in Stock
	         // Inserting a record into the "product" table with prodid 'p1'
	           String insertProductSQL = "INSERT INTO product (prodid, pname, price) VALUES ('p1', 'cd5', 5);";
	            executeUpdateQuery(insertProductSQL);

	            // Now, you can insert into the "stock" table referencing prodid 'p1'
	           String insertStockSQL = "INSERT INTO stock (prodid, depid, quantity) VALUES ('p1', 'd100', 100);";
	            executeUpdateQuery(insertStockSQL);

	            // Activity 6: Adding a new depot (d100, Chicago, 100) in Depot and (p1, d100, 100) in Stock
	            String insertDepotSQL = "INSERT INTO depot (depid, addr, volume) VALUES ('d100', 'chicago', 100);";
	            executeUpdateQuery(insertDepotSQL);
	            

	            conn.commit(); // Commit all changes

	            System.out.println("Activities performed successfully.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	            try {
	                if (conn != null) {
	                    conn.rollback();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private void executeUpdateQuery(String sql) throws SQLException {
	        PreparedStatement preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.executeUpdate();
	    }

	    public static void main(String[] args) {
	    	dbprogramming sqlConnect = new dbprogramming();
	        sqlConnect.connect();
	    }
	}
	
