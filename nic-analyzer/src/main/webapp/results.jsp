<%@page import="cse.maven.sample.exception.InvalidNICInputException"%>
<%@page import="cse.maven.sample.NIC_obj"%>
<%@page import="cse.maven.sample.NIC_decryp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<div style="width:500px; height:25px;background-color:firebrick ">
<h3 style="text-align:center;color:white">Result of NIC calculation</h3>
<%
	String nic = request.getParameter("nic");
	
	NIC_obj nic_obj=new NIC_obj(nic);
	
	
	try {
                NIC_decryp nic_decryp=new NIC_decryp();
		String[] output = nic_decryp.calculate(nic_obj);
		out.println("Birthday: "+output[0]);
                out.println("Gender: "+output[1]);
                out.println("Voter: "+output[2]);
	} catch (InvalidNICInputException ex) {
		out.println(ex.getMessage());
	}	
%>
</head>
<body>

</body>
</html>