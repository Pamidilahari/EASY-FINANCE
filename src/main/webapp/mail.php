<?php
//getting data from php form
$fname = $POST['fname'];
$lname = $POST['lname'];
$contact = $POST['contact'];
$email= $POST['emailaddress'];
$message= $_POST['message'];
$to = "pamidilahari15@gmail.com";
$subject = "Mail From EASY-FINANCE";
$txt ="First Name = ". $fname . "\r\n Last Name= " . $lname ."\r\n Contact= " . $contact . "\r\n Email = " . $email . "\r\n Message =" . $message;
$headers = "From: noreply@EASY-FINANCE.com" . "\r\n" .
"CC: somebodyelse@example.com";
if($email!=NULL){
mail($to,$subject,$txt,$headers);
}
//redirect to thank you page
header("Location:thankyou.html");
?>