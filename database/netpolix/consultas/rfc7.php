<?php

	if($_SERVER['REQUEST_METHOD'] == 'GET'){

		require_once("../db.php");

		$query = "SELECT Persona.cedula,Persona.nombre_completo, COUNT(cantidad) as cantidad FROM Persona INNER JOIN Alquiler ON Alquiler.persona = Persona.id_Persona GROUP BY Persona.nombre_completo ORDER BY cantidad DESC LIMIT 10";
		$result = $mysql->query($query);

		if($mysql->affected_rows > 0){

			while ($row = $result->fetch_assoc()) {
				$array[] = $row;
			}

			echo json_encode($array);

		}else{

			echo "Not found any rows";

		}

		$result->close();
		$mysql->close();
	}

?>
