<?php
	require "init.php";
	
	$sql = "SELECT * FROM poi_info;";
	
	$result = mysqli_query($con, $sql);
	
	$response = array();
	
	while($row = mysqli_fetch_array($result))
	{
		array_push($response, array("id"=>$row[0], "name"=>$row[1], "latitude"=>$row[2], "longitude"=>$row[3], "altitude"=>$row[4]));
	}
	
	echo json_encode(array("server_response"=>$response));
	
	mysqli_close($con);
?>