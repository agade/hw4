
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Albums;


public class ReadQuery {
  
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery () {
        
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void doRead(){
            
        try {
            String query = "Select * from albums";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable(){
        
          String table = "";
                            
        
        table += "<table border=1>";
        
            table += "<tr><th>AlbumID</th>";
            table += "<th>Album Name</th>";
            table += "<th>Number Of Songs</th>";
            table += "<th>Artist</th>";
            table += "<th>Release Date</th></tr>"; 
        
        try {
            while(this.results.next()){
                
                Albums album = new Albums();
                album.setAlbumID(this.results.getInt("albumID"));
                album.setAlbumName(this.results.getString("albumName"));
                album.setNumberOfSongs(this.results.getInt("numberOfSongs"));
                album.setArtist(this.results.getString("artist"));
                album.setReleaseDate(this.results.getInt("releaseDate"));
                
                
              
                table += "<tr>";
                table += "<td>";
                table += album.getAlbumID();
                table += "</td>";
                
                table += "<td>";
                table += album.getAlbumName();
                table += "</td>";
                
                table += "<td>";
                table += album.getNumberOfSongs();
                table += "</td>";
                
                table += "<td>";
                table += album.getArtist();
                table += "</td>";
                
                table += "<td>";
                table += album.getReleaseDate();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=delete?albumID=" + album.getAlbumID() + "> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
                
                return table;
    
    }
    
    
}
