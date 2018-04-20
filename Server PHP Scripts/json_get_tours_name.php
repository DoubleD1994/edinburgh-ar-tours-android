<?php
	require "init.php";
	
	$sql = "SELECT tour_id, name FROM tour_info;";
	
	$result = mysqli_query($con, $sql);
	
	$response = array();
	
	while($row = mysqli_fetch_array($result))
	{
		array_push($response, array("tour_id"=>$row[0], 
									"name"=>$row[1]));
	}
	
	echo json_encode(array("server_response"=>$response));
	
	mysqli_close($con);
?>