<%-- 
    Document   : CreateService
    Created on : Jan 25, 2024, 7:33:09 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="././CSS/Admin/createService.css" />
    <title>Service Form</title>
</head>

<body>
    <form method="post">
        <h2>Add Service</h2>
        
        <c:if test ="${requestScope.result != null}">
            <c:choose>
                <c:when test="${requestScope.result == true}">
                    <p style="color: green;">Create service successful!</p>
                </c:when>

                <c:otherwise>
                    <p style="color: red;">Create service fail!</p>
                </c:otherwise>
            </c:choose>
        </c:if>
        
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${requestScope.oldInput.name}">
         <c:if test="${requestScope.errors != null}">
          <c:forEach items="${requestScope.errors}" var="error" >
              <c:if test="${error.name eq 'name'}">
                  <p class="error-output">${error.message}</p>
              </c:if>
          </c:forEach>
         </c:if>
        

        <label for="details">Details:</label>
        <textarea id="details" name="details">${requestScope.oldInput.details}</textarea>
        <c:if test="${requestScope.errors != null}">
          <c:forEach items="${requestScope.errors}" var="error" >
              <c:if test="${error.name eq 'details'}">
                  <p class="error-output">${error.message}</p>
              </c:if>
          </c:forEach>
         </c:if>

        <label for="weightMinimum">Minimum Weight:</label>
        <input type="number" step="0.1"min="1" max="200" id="weightMinimum" name="weightMinimum" required>

        <label for="weightMaximum">Maximum Weight:</label>
        <input type="number" step="0.1" min="1" max="200" id="weightMaximum" name="weightMaximum" required>

        <label for="price">Price:</label>
        <input type="number" step="0.1" min="0" id="price" name="price" required>

        <input type="submit" value="Submit">
    </form>

</body>

</html>
