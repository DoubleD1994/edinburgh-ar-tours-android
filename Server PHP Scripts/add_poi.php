<?php

	require "init.php";
	
	$name = $_POST["name"];
	$latitude = $_POST["latitude"];	
	$longitude = $_POST["longitude"];
	$altitude = $_POST["altitude"];
	
	$sql = "INSERT INTO poi_info VALUES ('', '$name', '$latitude', '$longitude', '$altitude');";
	
	if(mysqli_query($con, $sql))
	{
		echo "<br><h3> One Row Inserted....</h3>";
	}
	else
	{
		echo "Error in insertion ... " . mysqli_error($con);
	}
	
?>