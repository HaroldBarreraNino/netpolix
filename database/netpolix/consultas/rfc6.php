<?php

	if($_SERVER['REQUEST_METHOD'] == 'GET'){

		require_once("../db.php");

		$query = "SELECT Videos.isan,Videos.titulo,Videos.calificacion,Alquiler.cantidad FROM Alquiler INNER JOIN Videos ON Videos.id_Video = Alquiler.video ORDER BY Alquiler.cantidad DESC LIMIT 10";
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
