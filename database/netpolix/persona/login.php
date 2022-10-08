<?php

	if($_SERVER['REQUEST_METHOD'] == 'GET'){

		require_once("../db.php");

		$cedula=$_GET["cedula"];
		$nombre_completo=$_GET["nombre_completo"];


		$query = "SELECT * FROM Persona WHERE cedula ='$cedula' AND nombre_completo ='$nombre_completo'";
		$result = $mysql->query($query);

		if($mysql->affected_rows > 0){

			while ($row = $result->fetch_assoc()) {
				$array = $row;
			}

			echo json_encode($array);

		}else{

			echo "Not found any rows";

		}

		$result->close();
		$mysql->close();
	}

?>
