/**
 * @Class : Main
 * @Description : Class to drive the entire Music Player Application
 * 				  Display all the options available in our MX Music Player
 */
package com.onebill.trainingAssessment.musicplayer;

import java.util.Scanner;

/**
 * @author Rathesh Prabakar
 * @version 2.0 03/06/2021
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean quit = true; 

		while(quit) {
		System.out.println("------Welcome to MX Music Player------");
		System.out.println("Press 1 to Play a Song");
		System.out.println("Press 2 to Search a Song");
		System.out.println("Press 3 to Show all Songs");
		System.out.println("Press 4 to Operate on Songs Database\nEnter your choice\t");
		System.out.println("Press 5 to Quit\t");

		int choice = input.nextInt();

		switch (choice) {
		case 1:
			Play playSongs = new Play();
			System.out.println("Press A to 'Play All Songs'");
			System.out.println("Press B to 'Play Songs Randomly'");
			System.out.println("Press C to 'Play a Particular Song'");
			System.out.println("Enter your choice\t");
			String playChoice = input.next();
			switch (playChoice) {
			case "A":
				playSongs.playAllSongs();
				break;
			case "B":
				playSongs.playSongsRandomly();
				break;
			case "C":
				System.out.println("Enter the song title you want to play");
				String querySong = input.nextLine();
				playSongs.playAParticularSong(querySong);
				break;
			}
			playSongs=null;
			break;
		case 2:
			Search search = new Search();
			search.SearchSong();
			search=null;
			break;
		case 3:
			DisplaySongs show = new DisplaySongs();
			System.out.println("\nDisplaying All Songs\n");
			show.showAllSongs();
			show=null;
			break;
		case 4:
			Operation edit = new Operation();
			System.out.println("Press A to Add Songs to Songs Repository");
			System.out.println("Press B to Edit an existing Song");
			System.out.println("Press C to Delete an existing Song");
			String userChoice = input.next();
			switch (userChoice) {
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
			edit = null;
			break;
		case 5:
			quit= false;
			break;
		default:
			System.out.println("Invalid Choice");
		}

		input.close();
	}
	}

}
