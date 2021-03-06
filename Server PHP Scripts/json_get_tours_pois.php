<?php
	require "init.php";
	
	$tour_id = $_GET["tour_id"];
	
	$sql = "SELECT poi_id, name, latitude, longitude, altitude FROM `tour_of_pois` JOIN poi_info ON tour_of_pois.poi_id = poi_info.id WHERE tour_id = $tour_id";
	
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
		array_push($response, array("poi_id"=>$row[0], 
									"name"=>$row[1], 
									"latitude"=>$row[2],
									"longitude"=>$row[3],
									"altitude"=>$row[4]));
		}
		echo json_encode(array("server_response"=>$response));
	}
	mysqli_close($con);
?>