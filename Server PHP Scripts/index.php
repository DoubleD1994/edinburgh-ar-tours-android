<html>

	<head>
		<title>Add Poi</title>
	</head>
	
	<body>
		<form action="add_poi.php" method="POST">
			<table>
				<tr>
					<td>Name: </td>
					<td><input type="text" name="name" /></td>
				<tr>
				<tr>
					<td>Latitude: </td>
					<td><input type="text" name="latitude" /></td>
				<tr>
				<tr>
					<td>Longitude: </td>
					<td><input type="text" name="longitude" /></td>
				<tr>
				<tr>
					<td>Altitude: </td>
					<td><input type="text" name="altitude" /></td>
				<tr>
			</table>
			
			<input type="submit" value="Submit Poi" />
		</form>
	</body>

</html>