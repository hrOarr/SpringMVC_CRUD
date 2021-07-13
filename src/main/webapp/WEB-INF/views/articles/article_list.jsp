<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Article List</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
	<div class="container bg-blue-300">
		<div
			class="flex md:flex-row flex-col md:justify-center justify-center pt-20">
			<div>
				<a href="<%=request.getContextPath()%>/articles/new">
				  <button class="bg-blue-600 px-2 py-2 hover:bg-blue-700 focus:outline-none text-white rounded-sm">Add New Article</button>
				</a>
			</div>
			<div class="pl-4">
				<a href="<%=request.getContextPath()%>/users/user_list">
				  <button class="bg-purple-600 px-2 py-2 hover:bg-purple-700 focus:outline-none text-white rounded-sm">Show Users</button>
				</a>
			</div>
		</div>

		<div class="row pl-20 pt-10 pr-20 pb-20">
		   <c:choose>
			 <c:when test="${articles!=null}">
				 <c:forEach var="article" items="${articles}">
					 <div class="mx-auto py-4 px-8 mt-3 bg-white justify-center shadow-lg rounded-lg">
						 <h2 class="text-4xl">
							<a href="<%=request.getContextPath()%>/articles/${article.id}" class="no-underline">${article.title}</a>
						 </h2>
						 <div>
							<span class="italic">published by</span> <span class="font-bold">${article.username}</span>
						 </div>
						 <p class="pt-2">${article.body}</p>
					 </div>
				 </c:forEach>
			 </c:when>
			 <c:otherwise>
				<h4 class="text-center">No Article yet.</h4>
			 </c:otherwise>
		    </c:choose>
		</div>
	</div>
</body>
</html>