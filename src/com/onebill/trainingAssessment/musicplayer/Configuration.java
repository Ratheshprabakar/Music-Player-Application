/**
 * @Class : Configuration
 * @Description : Class to establish a connection to the database
 */
package com.onebill.trainingAssessment.musicplayer;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * @author Rathesh Prabakar
 * @version 2.0 03/06/2021
 */
public class Configuration {

	public Connection connectionConfig() throws ClassNotFoundException, SQLException {
		
		//Step 1
		Class.forName("com.mysql.jdbc.Driver");

		// Step 2 Establish the connection with the database with user and password
		return (DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/" + "MusicPlayer?autoReconnect=true&useSSL=false", "db_username",
				"db_password"));
	}
}
