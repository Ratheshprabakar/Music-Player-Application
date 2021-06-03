/**
 * @Class : Search
 * @Extend Class : Play -> Configuration
 * @Description : Class to do search a song and play the particular song from the Music player
 * SearchSong() -> Function to get the input for song title and generate a play Id
 *  			   and get the input for play Id and
 *  			   play that respective song using playAParticularSong()
 */
package com.onebill.trainingAssessment.musicplayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author Rathesh Prabakar
 * @version 2.0 03/06/2021
 */
public class Search extends Play {
	
	Play playSong = new Play();

	@SuppressWarnings("resource")
	public void SearchSong() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet songs = null;
		try {

			con = conf.connectionConfig(); // To establish the connection with the database

			// Step 3 Issuing Query
			String query = "select * from MusicFiles where Song_Title = ?";

			// Step 4 : Execute and process the query
			pstmt = con.prepareStatement(query);
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the Song Title");
			String songTitle = input.nextLine();

			pstmt.setString(1, songTitle);
			songs = pstmt.executeQuery();
			int count = 0;
			System.out.println("Song_Title\tArtist_Name\tAlbum_Name\tPlay Id");
			System.out.println("---------------------------------------------");
			while (songs.next()) {
				int songId = songs.getInt("Song_ID");
				System.out.print(songs.getString("Song_Title") + "\t");
				System.out.print(songs.getString("Artist_Name") + "\t");
				System.out.print(songs.getString("Album_Name") + "\t");
				System.out.print(songId * 50);
				System.out.println();
				count++;
			}
			if (count != 0) {
				System.out.println("Enter the Play ID to play that song\t");
				int playId = input.nextInt();

				String newQuery = "select Song_Title from MusicFiles where Song_Id = ?";
				pstmt = con.prepareStatement(newQuery);
				pstmt.setInt(1, (int) playId / 50);
				songs = pstmt.executeQuery();

				if (songs.next()) {
					playSong.playAParticularSong(songs.getString("Song_Title"));
				} else {
					System.out.println("I think you entered wrong input");
				}
				input.close();
			} else
				System.out.println("I think you entered wrong input");

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
