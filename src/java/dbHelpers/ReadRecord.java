
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Albums;


public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Albums album = new Albums();
    private int albumID;
    
    public ReadRecord (int albumID) {
    
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
    
    this.albumID = albumID;
    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public void doRead() {
    
        try {
            //Set up a string to hold our query
            String query = "SELECT * FROM albums WHERE albumID = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement (query);
            
            //fill in the preparedstatement
            ps.setInt(1, albumID);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            album.setAlbumID(this.results.getInt("albumID"));
            album.setAlbumName(this.results.getString("albumName"));
            album.setNumberOfSongs(this.results.getInt("numberOfSongs"));
            album.setArtist(this.results.getString("artist"));
            album.setReleaseDate(this.results.getInt("releaseDate"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
    public Albums getAlbum(){
        
        return this.album;
        
    }    
}    
