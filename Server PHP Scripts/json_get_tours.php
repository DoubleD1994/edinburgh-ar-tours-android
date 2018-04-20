<?php
	require "init.php";
	
	$sql = "SELECT * FROM tour_info;";
	
	$result = mysqli_query($con, $sql);
	
	$response = array();
	
	while($row = mysqli_fetch_array($result))
	{
		array_push($response, array("tour_id"=>$row[0], 
									"name"=>$row[1], 
									"description"=>$row[2], 
									"distance"=>$row[3], 
									"est_time"=>$row[4],
									"start_latitude"=>$row[5],
									"start_longitude"=>$row[6],
									"start_altitude"=>$row[7],
									"end_latitude"=>$row[8],
									"end_longitude"=>$row[9],
									"end_altitude"=>$row[10]));
	}
	
	echo json_encode(array("server_response"=>$response));
	
	mysqli_close($con);
?>