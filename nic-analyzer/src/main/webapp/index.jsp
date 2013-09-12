<html>
<body>
    <div style="width:500px; height:30px; background-color:green">
	<h2 style="text-align:center;color:white">Welcome to NIC Analyzer</h2>
    </div>
	<h3>
		Written by
		<%=java.lang.System.getProperty("user.name")%> 110454E</h3>
		<form action="results.jsp" method="get">
			NIC no:<input type="text" name="nic">
			<br>
			<input type="submit">
		</form>
</body>
</html>
