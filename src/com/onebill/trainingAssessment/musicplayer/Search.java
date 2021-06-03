/**
 * 
 */
package com.onebill.trainingAssessment.musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author Rathesh Prabakar
 *
 */
public class Search {

	public void SearchSong() {
		
		Connection con = null;
		PreparedStatement pstmt = null;	
		ResultSet songs = null;			
			try {
				
				//Step 1
				Class.forName("com.mysql.jdbc.Driver");
				
				//Step 2 Establish the connection with the database with user and password
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false","root","Onebill@2020");
				
				// Step 3 Issuing Query
				String query = "select * from MusicFiles where Song_Title = ?";
				
				// Step 4 : Execute and process the query
				pstmt = con.prepareStatement(query);
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the Song Title");
				String songTitle = input.nextLine();
				
				pstmt.setString(1, songTitle);
				songs = pstmt.executeQuery();
				
				 while(songs.next()) {
					 int songId = songs.getInt("Song_ID");
					 System.out.print(songs.getString("Song_Title")+"\t");
					 System.out.print(songs.getString("Artist_Name")+"\t");
					 System.out.print(songs.getString("Album_Name")+"\t"); 
					 System.out.print(songId*50);
					 System.out.println();
				 }
				 System.out.println("Enter the Play ID to play that song\t");
				 int playId = input.nextInt();
				 System.out.println("You entered play ID is\t"+playId+"The Actually id of the song is\t"+(int)playId/50);
					input.close();


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//Step 5 : Close all the objects
			finally {
				try {
					if(con!=null)
						con.close();
					if(pstmt!= null)
						pstmt.close();
					if(songs!=null)
						songs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
	}

}
