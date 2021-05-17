<?php
include('connect.php');
$stmt = $connect->prepare("Select Username, Address, City, ZipCode, County, Date, PhoneNumber, FoodLeft from info order by Id DESC;");
$stmt->execute();
$stmt->bind_result($Username, $Address, $City, $ZipCode, $County, $Date, $PhoneNumber, $FoodLeft);

$info = array();

 
 while($stmt->fetch()){
	 
 $temp = array();
 $temp['Username'] = $Username; 
 $temp['Address'] = $Address; 
 $temp['City'] = $City; 
 $temp['ZipCode'] = $ZipCode; 
 $temp['County'] = $County;
 $temp['Date'] = $Date; 
 $temp['PhoneNumber'] = $PhoneNumber; 
 $temp['FoodLeft'] = $FoodLeft; 
 array_push($info, $temp);
 }
  
 echo json_encode($info); 

?>