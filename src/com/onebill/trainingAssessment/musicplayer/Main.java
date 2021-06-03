/**
 * 
 */
package com.onebill.trainingAssessment.musicplayer;

import java.util.Scanner;

/**
 * @author Rathesh Prabakar
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("------Welcome to MX Music Player------");
		System.out.println("Press 1 to Play a Song");
		System.out.println("Press 2 to Search a Song");
		System.out.println("Press 3 to Show all Songs");
		System.out.println("Press 4 to Operate on Songs Database\nEnter your choice\t");
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			Play playSongs = new Play();
			System.out.println("Press A to 'Play All Songs'");
			System.out.println("Press B to 'Play Songs Randomly'");
			System.out.println("Press C to 'Play a Particular Song'");
			System.out.println("Enter your choice\t");
			String playChoice = input.next();
			switch(playChoice) {
			case "A":
				playSongs.playAllSongs();
				break;
			case "B":
				playSongs.playSongsRandomly();
				break;
			case "C":
				System.out.println("Enter the song title you want to play");
				String querySong = input.next();
				playSongs.playAParticularSong(querySong);
				break;
			}
			break;
		case 2: 
			Search search = new Search();
			search.SearchSong();
			break;
		case 3:
			DisplaySongs show = new DisplaySongs();
			System.out.println("\n--------------------------Displaying All Songs----------------------------------");
			show.showAllSongs();
			break;
		case 4: 
			Operation edit = new Operation();
			System.out.println("Press A to Add Songs to Songs Repository");
			System.out.println("Press B to Edit an existing Song");
			System.out.println("Press C to Delete an existing Song");
			String userChoice = input.next();
			switch(userChoice) {
			case "A":
				edit.addSongtoDB();
				break;
			case "B":
				edit.editSonginDB();
				break;
			case "C":
				edit.deleteASongInDB();
				break;
			}
			break;
		default:
			System.out.println("Invalid Choice");
		}
		
		input.close();
		
	}

}
