import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class oneSingleJson {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub	
		CustomerDetails customerDetails = new CustomerDetails();
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = new JSONArray();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "Password@123");
		
		//object of statement class help us to execute queries
		Statement createStatement = conn.createStatement();	
		ResultSet executeQuery = createStatement.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
		int i =1;
		
		while (executeQuery.next())
		{
			customerDetails.setDetails(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getString(4));
			
			//converting data objects to json	
			objectMapper.writeValue(new File("E:\\Software Testing\\SDET\\Coding\\Eclipse Projects\\JDBC connection\\JSON\\customerDetails" + i + ".json"), customerDetails);
			i ++;
			
			jsonArray.add(customerDetails);
		}	
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", jsonArray);
		
		objectMapper.writeValue(new File("E:\\Software Testing\\SDET\\Coding\\Eclipse Projects\\JDBC connection\\JSON\\SingleFile" + ".json"), jsonObject);
	
		conn.close();
		
	}

}
