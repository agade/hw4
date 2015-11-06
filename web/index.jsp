<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Albums</title>
        <link rel="stylesheet" type="text/css" href="CSS/stylesheet.css" />
    </head>
    <body>
        
            <div class="wrap"> <!--div to contain all other divs -->
            
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
            
            <div class="wrap"> <!--div to contain all other divs -->
                <h1>My Albums Database</h1>
        
                <a href="read">View All Albums</a>
                <br><br>
                <a href="search.jsp">Search Albums</a>
            </div>
            
        <%@ include file="includes/footer.jsp" %>
        
        </div> <!-- close main div -->
        
    </body>
</html>
