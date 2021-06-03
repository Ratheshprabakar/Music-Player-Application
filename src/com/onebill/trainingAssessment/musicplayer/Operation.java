/**
 * 
 */
package com.onebill.trainingAssessment.musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Rathesh Prabakar
 *
 */
public class Operation {

	/**
	 * @param args
	 */
	public void addSongtoDB() {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {

			// Step 1
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2 Establish the connection with the database with user and password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false", "root",
					"Onebill@2020");

			// Step 3 Issuing Query
			String query = "insert into MusicFiles (Song_Title,Artist_Name,Album_Name,Song_Location,Description) values (?,?,?,?,?)";

			// Step 4 : Execute and process the query
			pstmt = con.prepareStatement(query);
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the Song Title\t");
			String songTitle = input.nextLine();

			System.out.println("\nEnter the Artist Name\t");
			String artistName = input.nextLine();

			System.out.println("\nEnter the Album Name\t");
			String albumName = input.nextLine();
			
			System.out.println("\nEnter the Song Location\t");
			String songLocation = input.nextLine();
			
			System.out.println("\nEnter the Description\t");
			String songDescription = input.nextLine();

			pstmt.setString(1, songTitle);
			pstmt.setString(2, artistName);
			pstmt.setString(3, albumName);
			pstmt.setString(4, songLocation);
			pstmt.setString(5, songDescription);

			count = pstmt.executeUpdate();
			if (count != 0)
				System.out.println("Inserted Successfully");
			else
				System.out.println("Error");
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
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void editSonginDB() {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {

			// Step 1
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2 Establish the connection with the database with user and password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false", "root",
					"Onebill@2020");

			// Step 3 Issuing Query
			String query = "update MusicFiles set Song_Title = ?,Artist_Name= ?,Album_Name =?,Song_Location =?, Description =? where Song_Title = ?";

			// Step 4 : Execute and process the query
			pstmt = con.prepareStatement(query);
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the Song Title you need to update\t");
			String updateSongTitle = input.nextLine();

			System.out.println("Enter the New Song Title\t");
			String songTitle = input.nextLine();
			
			System.out.println("Enter the New Artist Name\t");
			String artistName = input.nextLine();
			
			System.out.println("Enter the New Album Name\t");
			String albumName = input.nextLine();
			
			System.out.println("Enter the New Song Location\t");
			String songLocation = input.nextLine();
			
			System.out.println("Enter the New Description\t");
			String description = input.nextLine();

			pstmt.setString(1, songTitle);
			pstmt.setString(2, artistName);
			pstmt.setString(3, albumName);
			pstmt.setString(4, songLocation);
			pstmt.setString(5, description);
			pstmt.setString(6, updateSongTitle);

			count = pstmt.executeUpdate();
			if (count != 0)
				System.out.println("Updated Successfully");
			else
				System.out.println("Sorry, You are wrong this time, No song found with"+ updateSongTitle);
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
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
	public void deleteASongInDB() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		Properties properties = new Properties();
		int count = 0;

		try {

			// Step 1
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2 Establish the connection with the database with user and password
			properties.put("user", "root");
			properties.put("password", "Onebill@2020");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false", properties);

			// Step 3 Issuing Query
			String query = "delete from  MusicFiles where Song_Title = ?";

			// Step 4 : Execute and process the query
			pstmt = con.prepareStatement(query);
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the Song_Title you need to delete\t");
			String songTitle = input.nextLine();

			pstmt.setString(1, songTitle);
			System.out.println("Do you want to delete "+songTitle+" (yes/no)");
			String confirmation = input.nextLine();
			if(confirmation.equalsIgnoreCase("yes"))
				count = pstmt.executeUpdate();
			else
			{
				System.out.println("Thank GOD, You saved your song !!");
				System.exit(0);
			}
			if (count != 0)
				System.out.println("Deleted Successfully");
			else
				System.out.println("No Such record found");
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
				if (properties != null)
					properties = null;
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
	
}
