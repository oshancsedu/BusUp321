<!DOCTYPE HTML>
<html>
        <head>
		<title>Log In</title>
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
	<body>

	<!-- Header -->
	<div id="header-wrapper">
            <header id="header" class="container">
		<div class="row">
                    <div class="12u">
						
			<!-- Logo -->
			<!--h1><a href="#" id="logo">Busup</a></h1-->
			<img src="images/logo.png" alt="Bus Up" />
								
                    </div>
		</div>
            </header>
            
            <div id="banner">
                <div class="container">
                    <div class="row">
			<div class="6u">
                            <form action="LoginController" method="post">
                                <input type="text" name="username" placeholder="Enter User Name" id="username" size="40"><br><br>
                                <input type="password" name="password" placeholder="Enter Password" id="password" size="40"><br><br>
                                <input type="submit" value="Sign-in" name="btSubmit" class="button-big">
                            </form>
                            
                        </div>
			<div class="6u">
                            <!-- Banner Image -->
                            <a href="#" class="bordered-feature-image"><img src="images/banner.jpg" alt="" /></a>
			</div>
                    </div>
                </div>
            </div>
	</div>

	<!-- Features -->
	<div id="features-wrapper">
            <div id="features">
                <div class="container">
                    <div class="row">
                        <div class="3u">
                            <!-- Feature #1 -->
                            <section>
                                <a href="#" class="bordered-feature-image"><img src="images/p1.jpg" alt="" /></a>
				<h2>Welcome to BusUp</h2>
				<p>
                                    This is <strong>BusUp</strong>, a free android application, developed 
                                    by <a href="http://www.facebook.com/sifat.oshan">Md. Sifat-Ul Haque</a>. It's objective
                                    is to provide a view over the city buses of <strong>Dhaka</strong>
				</p>
                            </section>

			</div>
			
                        <div class="3u">
								
                            <!-- Feature #2 -->
                            <section>
				<a href="#" class="bordered-feature-image"><img src="images/p2.jpg" alt="" /></a>
				<h2>Bus Detail</h2>
				<p>
                                    This shows the stopages of all the buses in the <strong>Dhaka City</strong>.
                                    One can also view the route of a bus in google map simply by tapping on
                                    the bus on this list.
				</p>
                            </section>

			</div>
			
                        <div class="3u">
								
                            <!-- Feature #3 -->
                            <section>
				<a href="#" class="bordered-feature-image"><img src="images/p3.jpg" alt="" /></a>
				<h2>Get Bus</h2>
				<p>
                                    Selecting two bus stand one can view via which bus(es) he/she can travle through
                                    by simply tapping on the button below.
                                </p>
                            </section>

			</div>
							
                        <div class="3u">
								
                            <!-- Feature #4 -->
                            <section>
                                <a href="#" class="bordered-feature-image"><img src="images/p4.jpg" alt="" /></a>
				<h2>Google Map</h2>
                                <p>
                                   One can view the route of a particular bus through google map.Clicking on the
                                   marker he/she can also view the name of the bus stand the marker is pointed to.
				</p>
                            </section>

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
