# Music-Player-Application

> A console based application i.e. application which will not have any GUI but has a main method which takes input from console, which simulates “Music Player Application”.

## Functions :
- Play a Song
- Search a Song
- Show all Songs
- Operate on Songs Database

### Play a Song 
 - Play All Songs sort by Song Title
 - Play Songs Randomly
 - Play a particular Song by getting Song Title 
 
 ### Search a song
  - Fetch the songs from database.
  - Display the songs sort by Song Title
  - Generate a unique Play ID for every song
  - User needs to give the respective Play ID to play that song
  - Based upon the user's input play id, The song will get played.
  
  ### Show all songs
  - Fetch the songs from database.
  - Display the songs sort by Song Title in table format
  
  ### Operate on Songs
  - Add songs to the DB
  - Edit an existing songs in the DB
  - Delete an existing songs in the DB
  
  ### File Structure 
  
  [Main.java](https://github.com/Ratheshprabakar/Music-Player-Application/blob/master/src/com/onebill/trainingAssessment/musicplayer/Main.java) - Class to drive the entire Music Player Application and display all the options available in our MX Music Player
  
  [Configuration.java](https://github.com/Ratheshprabakar/Music-Player-Application/blob/master/src/com/onebill/trainingAssessment/musicplayer/Configuration.java) - Class to establish a connection to the database
  
  [DisplaySongs.java](https://github.com/Ratheshprabakar/Music-Player-Application/blob/master/src/com/onebill/trainingAssessment/musicplayer/DisplaySongs.java) - Class to display all songs in the database
  
  [Operation.java](https://github.com/Ratheshprabakar/Music-Player-Application/blob/master/src/com/onebill/trainingAssessment/musicplayer/Operation.java) - Class to do CRUD Operations of Music in Database
  
  [Play.java](https://github.com/Ratheshprabakar/Music-Player-Application/blob/master/src/com/onebill/trainingAssessment/musicplayer/Play.java) - Class to do several play operations of Music player
  
  [Search.java](https://github.com/Ratheshprabakar/Music-Player-Application/blob/master/src/com/onebill/trainingAssessment/musicplayer/Search.java) - Class to do search a song and play the particular song from the Music player
  
