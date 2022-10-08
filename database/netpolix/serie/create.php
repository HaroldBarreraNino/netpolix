<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		require_once("../db.php"); //Llamar la base de datos

		//Los datos de la tabla
		$titulo = $_POST['titulo'];
		$temporadas = $_POST['temporadas'];
		$capitulos = $_POST['capitulos'];

		$query = "INSERT INTO `Serie`(`titulo`, `temporadas`, `capitulos`) VALUES ('$titulo', '$temporadas', '$capitulos')"; //Peticion SQL

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
