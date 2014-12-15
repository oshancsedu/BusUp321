<!DOCTYPE HTML>
<html>
	<head>
		<title>Add Coordinate</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
	</head>
	<body class="subpage">

            <!-- Header -->
            <div id="header-wrapper">
		<header id="header" class="container">
                    <div class="row">
                        <div class="12u">
                            <img src="images/logo.png" alt="Bus Up" />

                            <!-- Nav -->
                            <nav id="nav">
                                <a href="AddBusController">Add Bus</a>
                                <a href="RemoveBusController">Remove Bus</a>
                                <a href="AddBusStandController">Add Bus Stand</a>
                                <a href="RemoveStandController">Remove Bus Stand</a>
                                <a href="update_route.jsp">Update Route</a>
                                <a href="JSONUpdateController">Json</a>
                            </nav>

                        </div>
                    </div>
                </header>
            </div>

            <!-- Content -->
            <div id="content-wrapper">
		<div id="content">
                    <div class="container">
                        <div class="row">
                            <div class="3u">
                                <!-- Sidebar -->
				<section>
                                    <header>
                                        <h2>Update Route</h2>
                                    </header>
                                    <ul class="link-list">
					<li><a href="route_up_add_stand.jsp">Add Stopage</a></li>
					<li><a href="route_up_remove_stand.jsp">Remove Stopage</a></li>
					<li><a href="route_up_update_stopage.jsp">Update Stopag</a></li>
					<li><a href="route_up_add_coordinate.jsp">Add Coordinate</a></li>
					<li><a href="route_up_remove_coordinate.jsp">Remove Coordinate</a></li>
					<li><a href="route_up_update_coordinate.jsp">Update Coordinate</a></li>
                                    </ul>
				</section>
                            </div>
                            <div class="9u important(collapse)">
                                <!-- Main Content -->
                                <form action="RouteUpController" method="post">
                                    <input type="text" placeholder="Enter Bus Name" name="etBusName"><br><br>
                                    <input type="text" placeholder="Enter Latitude" name="etLat">
                                    <input type="text" placeholder="Enter Longitude" name="etLong"><br><br>
                                    <input type="submit" value="Add Coordinate" name="btSubmit" class="button-big">
                                </form>
                            </div>
			</div>
                    </div>
		</div>
            </div>
			
            <!-- Copyright -->
            <div id="copyright">
                &copy; Untitled. All rights reserved.
            </div>
        </body>
</html>
