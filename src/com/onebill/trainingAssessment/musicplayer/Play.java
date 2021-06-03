/**
 * 
 */
package com.onebill.trainingAssessment.musicplayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Rathesh Prabakar
 * @version 2.0
 */
public class Play extends Configuration {

	Configuration conf = new Configuration();

	public void playAllSongs() {
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

			/*
			 * ResultSetMetaData rsmd = songs.getMetaData(); int columnsNumber =
			 * rsmd.getColumnCount();
			 */
			while (songs.next()) {
				System.out.println("Playing " + songs.getString("Song_Title") + "...");
				Thread.sleep(200);
				/*
				 * for (int i = 1; i <= columnsNumber; i++) { String columnValue =
				 * songs.getString(i); System.out.print(columnValue + " ");
				 * System.out.print("\t"); }
				 */
				// System.out.println("");
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

	public void playSongsRandomly() {
		Connection con = null;
		Statement stmt = null;
		ResultSet songs = null;
		try {

			con = conf.connectionConfig(); // To get the Database connection

			// Step 3 Issuing Query
			String query = "select * from MusicFiles order by RAND()";

			// Step 4 : Execute and process the query
			stmt = con.createStatement();
			songs = stmt.executeQuery(query);

			/*
			 * ResultSetMetaData rsmd = songs.getMetaData(); int columnsNumber =
			 * rsmd.getColumnCount();
			 */
			while (songs.next()) {
				System.out.println("Playing " + songs.getString("Song_Title") + "...");
				Thread.sleep(400);
				/*
				 * for (int i = 1; i <= columnsNumber; i++) { String columnValue =
				 * songs.getString(i); System.out.print(columnValue + " ");
				 * System.out.print("\t"); }
				 */
				// System.out.println("");
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

	public void playAParticularSong(String querySong) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet songs = null;
		try {

			con = conf.connectionConfig(); // To get the Database connection

			// Step 3 Issuing Query
			String query = "select * from MusicFiles where Song_Title = ?";

			// Step 4 : Execute and process the query
			pstmt = con.prepareStatement(query);

			Scanner input = new Scanner(System.in);
			/*
			 * System.out.println("Enter the Song Title you want to hear"); String querySong
			 * = input.nextLine();
			 */

			pstmt.setString(1, querySong);
			songs = pstmt.executeQuery();

			if (songs.next()) {
				System.out.print("Playing " + songs.getString("Song_Title") + "....\t");
			} else {
				System.out.println("OOPS, No song is available in the name of" + querySong);
			}
			input.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Step 5 : Close all the objects
		finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
				if (songs != null)
					songs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
