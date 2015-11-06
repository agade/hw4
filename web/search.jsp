<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Albums</title>

        <link rel="stylesheet" type="text/css" href="CSS/stylesheet.css" />
    </head>
    <body>

        <div class="wrap"> <!--div to contain all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="wrap"> <!--div to contain all other divs -->

                <h1>Search Albums</h1>

                <form name="searchForm" action="search" method="get">



                    <input type="text" name="searchVal" value="" />

                    <br>

                    <input type="submit" name="submit" value="Search" />

                </form>

            </div>

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close main div -->

    </body>
</html>
