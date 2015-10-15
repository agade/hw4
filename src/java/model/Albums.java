
package model;

public class Albums {
  
    private int albumID;
    private String albumName;
    private int numberOfSongs;
    private String artist;
    private int releaseDate;
    
    public Albums() {
        this.albumID = 0;
        this.albumName = "";
        this.numberOfSongs = 0;
        this.artist = "";
        this.releaseDate = 0;
    
    }

    public Albums(int albumID, String albumName, int numberOfSongs, String artist, int releaseDate) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.numberOfSongs = numberOfSongs;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Albums{" + "albumID=" + albumID + ", albumName=" + albumName + ", numberOfSongs=" + numberOfSongs + ", artist=" + artist + ", releaseDate=" + releaseDate + '}';
    }
    
    
    
    
}
