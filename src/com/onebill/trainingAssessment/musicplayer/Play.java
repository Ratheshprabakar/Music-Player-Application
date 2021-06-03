/**
 * 
 */
package com.onebill.trainingAssessment.musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Rathesh Prabakar
 *
 */
public class Play {
	
	public void playAllSongs() {
		Connection con = null;
		Statement stmt = null;
		ResultSet songs = null;
			try {
				
				//Step 1
				Class.forName("com.mysql.jdbc.Driver");
				
				//Step 2 Establish the connection with the database with user and password
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
						+ "MusicPlayer?autoReconnect=true&useSSL=false","root","Onebill@2020");
				
				// Step 3 Issuing Query
				String query = "select * from MusicFiles order by Song_Title";
				
				// Step 4 : Execute and process the query
				 stmt = con.createStatement();
				 songs = stmt.executeQuery(query);
			 	
				 /*ResultSetMetaData rsmd = songs.getMetaData();
				 int columnsNumber = rsmd.getColumnCount();*/
				 while (songs.next()) {
					 System.out.println("Playing "+songs.getString("Song_Title")+"...");
					 Thread.sleep(200);
				    /*for (int i = 1; i <= columnsNumber; i++) {
				        String columnValue = songs.getString(i);
				        System.out.print(columnValue + " ");
				        System.out.print("\t");
				    }*/
				    //System.out.println("");
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			//Step 5 : Close all the objects
			finally {
				try {
					if(con!=null)
						con.close();
					if(stmt!= null)
						stmt.close();
					if(songs!=null)
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
				
				//Step 1
				Class.forName("com.mysql.jdbc.Driver");
				
				//Step 2 Establish the connection with the database with user and password
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
						+ "MusicPlayer?autoReconnect=true&useSSL=false","root","Onebill@2020");
				
				// Step 3 Issuing Query
				String query = "select * from MusicFiles";
				
				// Step 4 : Execute and process the query
				 stmt = con.createStatement();
				 songs = stmt.executeQuery(query);
			 	
				 /*ResultSetMetaData rsmd = songs.getMetaData();
				 int columnsNumber = rsmd.getColumnCount();*/
				 while (songs.next()) {
					 System.out.println("Playing "+songs.getString("Song_Title")+"...");
					 Thread.sleep(400);
				    /*for (int i = 1; i <= columnsNumber; i++) {
				        String columnValue = songs.getString(i);
				        System.out.print(columnValue + " ");
				        System.out.print("\t");
				    }*/
				    //System.out.println("");
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			//Step 5 : Close all the objects
			finally {
				try {
					if(con!=null)
						con.close();
					if(stmt!= null)
						stmt.close();
					if(songs!=null)
						songs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
	}
	public void playAParticularSong() {
		
	}

}
