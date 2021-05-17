<?php
function validate($data){
	$data = trim($data);
	$data = stripslashes($data);
	$data = htmlspecialchars($data);
	$data = str_replace("\r\n","",$data);
	return $data;
}
?>