<?php
	require "init.php";
	
	$sql = "SELECT * FROM preferences_list;";
	
	$result = mysqli_query($con, $sql);
	
	$response = array();
	
	while($row = mysqli_fetch_array($result))
	{
		array_push($response, array("id"=>$row[0], 
									"title"=>$row[1]));
	}
	
	echo json_encode(array("server_response"=>$response));
	
	mysqli_close($con);
?>