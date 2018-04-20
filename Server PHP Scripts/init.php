<?php

	$host = "localhost";
	$db = "id2081541_artour";
	$user = "id2081541_artour";
	$password = "edinburgh";
	
	$con = mysqli_connect($host, $user, $password, $db);
	
	if(!$con)
	{
		die("Error in connection " . mysqli_connect_error());
	}
	else
	{
		echo "<br><h3>Connection Success....</h3>";
	}
	
?>