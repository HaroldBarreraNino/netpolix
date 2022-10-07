<?php

	if($_SERVER['REQUEST_METHOD'] == 'GET'){

		require_once("../db.php");


		$query = "SELECT isan,Videos.titulo FROM Videos INNER JOIN Serie ON Serie.capitulos = Videos.id_Video WHERE idioma = 2";
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
