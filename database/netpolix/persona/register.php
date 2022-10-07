<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		require_once("../db.php"); //Llamar la base de datos

		//Los datos de la tabla
		$cedula = $_POST['cedula'];
		$nombre_completo = $_POST['nombre_completo'];
		$fecha_nacimiento = $_POST['fecha_nacimiento'];

		$query = "INSERT INTO Persona(cedula, nombre_completo, fecha_nacimiento) VALUES ('$cedula','$nombre_completo', '$fecha_nacimiento')"; //Peticion SQL

		$result = $mysql->query($query);

		//Se comprueba si se añadio el usuario o no
		if($result === TRUE){
			echo "The user was created succesfully";
		}else{
			echo "Error";
		}

		$mysql->close();
	}

?>
