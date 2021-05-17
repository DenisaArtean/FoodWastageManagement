<?php
if(isset($_POST['UserTake']) && isset($_POST['UserPost']) ){
	require_once "connect.php";
	require_once "validate.php";
	$UserTake = validate($_POST['UserTake']);
	$UserPost = validate($_POST['UserPost']);
	$sql = "insert into take values('', '$UserTake', '$UserPost')";
	 if(!$connect->query($sql)){
		echo "failure";
	}else{
		echo "success";
	}
}
?>