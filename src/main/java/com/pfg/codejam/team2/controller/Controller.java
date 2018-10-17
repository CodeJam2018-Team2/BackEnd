package com.pfg.codejam.team2.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;
import java.util.Properties;


@RestController
public class Controller {

	private static final Logger LOG = Logger.getLogger(Controller.class);

	@RequestMapping(value="/request", method = RequestMethod.POST)
	public ResponseEntity<String> getData(@RequestParam("id") long id) {

		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}

	@RequestMapping(value="/fred", method = RequestMethod.GET)
	public List<SearchResults> returnFredResults() throws ClassNotFoundException, SQLException {

		return getAllFredResults();
	}

	private List<SearchResults> getAllFredResults() throws ClassNotFoundException, SQLException {

		String host = "mydemoserver.mysql.database.azure.com";
		String database = "quickstartdb";
		String user = "myadmin@mydemoserver";
		String password = "<server_admin_password>";

		// check that the driver is installed
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			throw new ClassNotFoundException("MySQL JDBC driver NOT detected in library path.", e);
		}

		Connection connection = null;

		try {
			String url = String.format("jdbc:mysql://%s/%s", host, database);
			// Set connection properties.
			Properties properties = new Properties();
			properties.setProperty("user", user);
			properties.setProperty("password", password);
			properties.setProperty("useSSL", "true");
			properties.setProperty("verifyServerCertificate", "true");
			properties.setProperty("requireSSL", "false");

			// get connection
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new SQLException("Failed to create connection to database.", e);
		}
		if (connection != null) {
			System.out.println("Successfully created connection to database.");
			try {
				//Generic Prepared Statement that will be replaced to query the actually database
				int nRowsInserted = 0;
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO inventory (name, quantity) VALUES (?, ?);");
				preparedStatement.setString(1, "banana");
				preparedStatement.setInt(2, 150);
				nRowsInserted += preparedStatement.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new SQLException("Encountered an error when executing given sql statement.", e);
			}
		}
		else {
			System.out.println("Failed to create connection to database.");
		}
		//TODO replaced return statement with what is returned by query
		return null;
	}

}
