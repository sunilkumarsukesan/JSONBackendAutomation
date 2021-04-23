import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractJSON {

	public static void main(String[] args) throws IOException {
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		CustomerDetails readValue = objectMapper.readValue(new File("E:\\Software Testing\\"
				+ "SDET\\Coding\\Eclipse Projects\\JDBC connection\\JSON\\customerDetails2.json"), CustomerDetails.class);
		System.out.println(readValue.getCourseName());
	}

}
