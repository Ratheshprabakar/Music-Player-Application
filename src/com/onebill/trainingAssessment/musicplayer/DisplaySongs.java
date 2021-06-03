/**
 * @Class : DisplaySongs
 * @Extend Class : Configuration
 * @Description : Class to display all songs in the database
 * showAllSongs() -> Function to display all the songs sort by song title in display format
 */
package com.onebill.trainingAssessment.musicplayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * @author Rathesh Prabakar
 * @version 2.0 03/06/2021
 */
public class DisplaySongs extends Configuration {

	Configuration conf = new Configuration();

	public void showAllSongs() {

		Connection con = null;
		Statement stmt = null;
		ResultSet songs = null;

		try {

			con = conf.connectionConfig(); // To get the Database connection

			// Step 3 Issuing Query
			String query = "select * from MusicFiles order by Song_Title";

			// Step 4 : Execute and process the query
			stmt = con.createStatement();
			songs = stmt.executeQuery(query);

			ResultSetMetaData rsmd = songs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			while (songs.next()) {
				System.out.println(
						"--------------------------------------------------------------------------------------");
				for (int i = 2; i <= columnsNumber; i++) {
					String columnValue = songs.getString(i);
					System.out.print(columnValue + "\t\t");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Step 5 : Close all the objects
		finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (songs != null)
					songs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
