<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		require_once("../db.php"); //Llamar la base de datos

		//Los datos de la tabla
		$titulo = $_POST['titulo'];
		$duracion = $_POST['duracion'];
		$categoria = $_POST['categoria'];
		$actores = $_POST['actores'];
		$directores = $_POST['directores'];
		$isan = $_POST['isan'];
		$calificacion = $_POST['calificacion'];
		$idioma = $_POST['idioma'];

		$query = "INSERT INTO Videos (titulo, duracion, categoria, actores, directores, isan, calificacion, idioma) VALUES ('$titulo', '$duracion', $categoria, '$actores', '$directores', '$isan', $calificacion, $idioma)"; //Peticion SQL

		$result = $mysql->query($query);

		//Se comprueba si se añadio el usuario o no
		if($result === TRUE){
			echo "The comment was created succesfully";
		}else{
			echo "Error";
		}

		$mysql->close();
	}

?>
