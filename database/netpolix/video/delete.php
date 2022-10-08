<?php

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		require_once("../db.php");

		$id =$_POST['id'];

		$query ="DELETE FROM Videos WHERE id_Video = '$id'";
		$result = $mysql->query($query);

		if ($mysql->affected_rows > 0) {
			if($result === TRUE){
				echo "The comment was removed succesfully";
			}
		}else{
			echo "not found any rows";
		}

		$mysql->close();
	}

?>
