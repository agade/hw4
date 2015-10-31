<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title>Add A New Album</title>
    </head>
    <body>
        <h1>Add A New Album</h1>
        
        <form name="addForm" action="addAlbum" method="get">
            
            <label>Album Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>Number Of Songs:</label>
            <input type="text" name="songs" value="" />
            <br>
            <label>Artist Name:</label>
            <input type="text" name="artist" value="" />
            <br>
            <label>Release Date:</label>
            <input type="text" name="date" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
        
    </body>
</html>
