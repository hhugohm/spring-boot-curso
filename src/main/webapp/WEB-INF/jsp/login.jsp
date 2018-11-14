<html>

<head>
<title>First Web Application</title>
</head>

<body>
<H1>Welcome to Loggin Application!!</H1><br>
<table>
	<tr>
		<td><font color="red"> ${messageErrorUser}</font></td>
	</tr>
</table>
<br>
	<form method="post" action="/login">
		<table>
			<tr>
				<td>User:</td>
				<td><input type="text" name="name" value="hugo" /> </td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value="12345" /> </td>
			</tr>
			<tr>
				<td><input type="submit" value="click here" /></td>
			</tr>
		</table>
	</form>
</body>

</html>