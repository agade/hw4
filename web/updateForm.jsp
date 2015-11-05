<%@page import="model.Albums"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Albums album = (Albums) request.getAttribute("album"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update An Album</title>
        
        <link rel="stylesheet" type="text/css" href="style.css" />
        
    </head>
    <body>
        <h1>Update An Album Record</h1>
        
        <form name="updateForm" action="updateAlbum" method="get">
            
            <table class="update">
            <label>Album ID:</label>
            <input type="text" name="id" value="<%= album.getAlbumID() %>" readonly />
            <label>Album Name:</label>
            <input type="text" name="name" value="<%= album.getAlbumName() %>" />
            <br>
            <label>Number Of Songs:</label>
            <input type="text" name="songs" value="<%= album.getNumberOfSongs() %>" />
            <br>
            <label>Artist Name:</label>
            <input type="text" name="artist" value="<%= album.getArtist() %>" />
            <br>
            <label>Release Date:</label>
            <input type="text" name="date" value="<%= album.getReleaseDate() %>" />
            </table>
            <br>
            <input type="submit" name="submit" value="Update" />
            <br>
            <input type="reset" name="reset" value="Clear" />
        </form>
    </body>
</html>
