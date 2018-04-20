<?php
	require "init.php";
	
	$tour_id = $_GET["tour_id"];
	
	$sql = "SELECT * FROM tour_info WHERE tour_id = $tour_id";
	
	$result = mysqli_query($con, $sql);
	
	$response = array();
	
	if(!mysqli_num_rows($result)>0)
	{
		$status = "error in getting tour info";
		echo json_encode(array("response" => $status));
	}
	else
	{
		while($row = mysqli_fetch_array($result))
		{
		array_push($response, array("tour_id"=>$row[0], 
									"name"=>$row[1], 
									"description"=>$row[2]));
		}
		echo json_encode(array("server_response"=>$response));
	}
	mysqli_close($con);
?>