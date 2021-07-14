<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Article form</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

<script src="https://cdn.tiny.cloud/1/en64pjam2gyx9a0j1nlqd1yqpj35cv2r2nx27kthovcvcefd/tinymce/5/tinymce.min.js"></script>

    <script>
      tinymce.init({
        selector: '#mytextarea'
      });
    </script>

</head>
<body>
  <div class="container bg-blue-300">
     <div class="row justify-center p-20">
       
       <div class="col-md-12"><h1 class="text-center text-4xl">New Article</h1></div>
       
       <div class="pt-3">
       <form:form action="${pageContext.servletContext.contextPath}/articles/${type}" method="POST" modelAttribute="article">
         
         <form:label path="title" class="block text-sm font-medium text-gray-700">Enter title</form:label>
         <form:input type="text" path="title" placeholder="Enter title" class="w-full mt-2 mb-6 px-4 py-2 border rounded-lg text-gray-700 focus:outline-none focus:border-green-500" />
         <div class="relative mb-2 text-red-500"><c:out value="${title_error}"/></div>
         
         <div>
              <form:label path="body" class="block text-sm font-medium text-gray-700">
                Content
              </form:label>
              <div class="mt-1">
                <form:textarea id="mytextarea" path="body" rows="4" cols="48" class="w-full px-3 py-2 text-gray-700 border rounded-lg focus:outline-none" placeholder="Enter contents"/>
              </div>
         </div>
         <div class="relative mb-2 text-red-500"><c:out value="${body_error}"/></div>
         
         <div>
         <form:select class="form-select" path="user_id" required="required">
            <c:if test="${article.username==null}">
                <option selected>Select User</option>
            </c:if>
            <c:forEach var="user" items="${users}">
              <c:if test="${article.username==user.getName()}">
                <form:option value="${user.getId()}" selected="selected">${user.getName()}</form:option>
              </c:if>
              <c:if test="${article.username!=user.getName()}">
                <form:option value="${user.getId()}">${user.getName()}</form:option>
              </c:if>
            </c:forEach>
            
            <form:input type="hidden" path="id" />
         </form:select>
         </div>
         <div class="relative mb-2 text-red-500"><c:out value="${user_id_error}"/></div>
         
         <div class="justify-center">
           <form:button type="submit" class="btn btn-primary mt-2">Submit</form:button>
         </div>
       </form:form>
       </div>
     </div>
  </div>
</body>
</html>