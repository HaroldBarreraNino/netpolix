<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		require_once("../db.php"); //Llamar la base de datos

		//Los datos de la tabla
		$titulo = $_POST['titulo'];
		$volumen = $_POST['volumen'];
		$capitulos = $_POST['capitulos'];

		$query = "INSERT INTO `Coleccion`(`titulo`, `volumen`, `capitulos`) VALUES ('$titulo', '$volumen', '$capitulos')"; //Peticion SQL

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
