<%-- 
    Document   : viewCourses
    Created on : Nov 7, 2017, 11:53:10 PM
    Author     : Bilal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="./css/main.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="w3-content" style="max-width:1200px">

        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">
            <div class="w3-container w3-display-container w3-padding-16">

                <h3 class="w3-wide"><b>LMS</b></h3>
            </div>
            <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
                <a href="#" class="w3-bar-item w3-button">Course 1</a>
                <a href="#" class="w3-bar-item w3-button">Course 2</a>               
                <a href="#" class="w3-bar-item w3-button">Course 3</a>
            </div>
            <a href="" class="w3-bar-item w3-button w3-padding">Log Off</a> 
        </nav>
        <div class="w3-main" style="margin-left:250px">
            <!-- Project Section -->
            <div class="w3-container w3-padding-32" id="projects">
                <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Courses</h3>
            </div>

            <!--course objs-->
            <div class="w3-row-padding w3-padding-16">
                <div class="w3-third w3-margin-bottom">
                    <div class="w3-container w3-white">
                        <h3>Course 1</h3>
                        <h6 class="w3-opacity">Name</h6>
                        <h6 class="w3-opacity">professor name?</h6>
                        <button class="w3-button w3-block w3-black w3-margin-bottom">Goto Course1</button>
                    </div>
                </div>
                <div class="w3-third w3-margin-bottom">
                    <div class="w3-container w3-white">
                        <h3>Course 2</h3>
                        <h6 class="w3-opacity">Name</h6>
                        <h6 class="w3-opacity">professor name?</h6>
                        <button class="w3-button w3-block w3-black w3-margin-bottom">Goto Course2</button>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
