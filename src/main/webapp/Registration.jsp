<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<form method="post" action="registration">
		<h3>Sign up here!</h3>
		<label for="name">Name</label> <input type="text" name="name"
			placeholder="name"> <br> <label for="email">Email</label> <input type="text" name="email" placeholder="email">
		<br> <label for="password">Password</label> <input
			type="password" name="password" placeholder="password"> <br>
		<label for="reEnterPassword">Enter password again</label> <input
			type="password" name="reEnterPassword"
			placeholder="Enter password again"> <br> <label
			for="phoneNumber">Phone Number</label> <input type="text"
			name="phoneNumber" placeholder="phone number"> <br> 
			<input type="submit" value="Submit" >
	</form>
</body>
</html>