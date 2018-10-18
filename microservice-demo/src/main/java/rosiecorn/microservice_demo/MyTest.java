package rosiecorn.microservice_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyTest  implements RequestHandler<RequestDetails, ResponseDetails>{

public ResponseDetails handleRequest(RequestDetails requestDetails, Context arg1) {
		
		// TODO Auto-generated method stub
		ResponseDetails responseDetails = new ResponseDetails();
				try {
					insertDetails(requestDetails, responseDetails);
				} catch (SQLException sqlException) {
					responseDetails.setMessageID("999");
					responseDetails.setMessageReason("Unable to Registor "+sqlException);
				}
				return responseDetails;
	}

	private void insertDetails(RequestDetails requestDetails, ResponseDetails responseDetails) throws SQLException {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		String query = getQuery(requestDetails);
		int responseCode = statement.executeUpdate(query);
		if(1 == responseCode)
		{
			responseDetails.setMessageID(String.valueOf(responseCode));
			responseDetails.setMessageReason("Successfully updated details");
		}
		
	}	
	

	private String getQuery(RequestDetails requestDetails) {
		
		String query = "INSERT INTO datacentral.compemp(companyID,companyName,companyEmail,candidateID,candidateName,candidateEmail) VALUES (";
		if (requestDetails != null) {
			query = query.concat("'" + requestDetails.getCompanyID() + "','" 
					+ requestDetails.getCompanyName() + "','" 
					+ requestDetails.getCompanyEmail() + "','" 
					+ requestDetails.getCandidateID() + "','" 
					+ requestDetails.getCandidateName() + "','" 
					+ requestDetails.getCandidateEmail()+ "')");
		}
		System.out.println("the query is "+ query);
		return query;
	}

	private Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
				String url = "jdbc:mysql://awsmysql.cmc1kiud8sar.us-east-2.rds.amazonaws.com:3306";
				String username = "adminuser";
				String password = "gauMAP789";
				Connection conn = DriverManager.getConnection(url, username, password);
				return conn;
	}
	
}