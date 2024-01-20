<%-- 
    Document   : Register
    Created on : Jan 13, 2024, 1:54:16 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pet Pet</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 300px;
    }

    label {
      display: block;
      margin-bottom: 8px;
    }

    input {
      width: 100%;
      padding: 8px;
      margin-bottom: 16px;
      box-sizing: border-box;
    }

    button {
      background-color: #4caf50;
      color: #fff;
      padding: 10px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      width: 100%;
    }

    button:hover {
      background-color: #45a049;
    }

    .form-header {
      text-align: center;
      font-size: 24px;
      margin-bottom: 20px;
    }
    
    p{
        margin-top: 0px;
    }
  </style>
</head>
<body>
  <form method="post">
    <div class="form-header">Register</div>

    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${requestScope.oldInput.username}">
      <c:if test="${requestScope.errors != null}">
          <c:forEach items="${requestScope.errors}" var="error" >
              <c:if test="${error.name eq 'username'}">
                  <p style="color: red;">${error.message}</p>
              </c:if>
          </c:forEach>
      </c:if>

    

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="${requestScope.oldInput.password}">
    <c:if test="${requestScope.errors != null}">
        <c:forEach items="${requestScope.errors}" var="error">
            <c:if test="${error.name eq 'password'}">
                <p style="color: red;">${error.message}</p>
            </c:if>
        </c:forEach>
    </c:if>

    <label for="name">Full Name:</label>
    <input type="text" id="name" name="name" value="${requestScope.oldInput.name}" >
    <c:if test="${requestScope.errors != null}">
        <c:forEach items="${requestScope.errors}" var="error" >
            <c:if test="${error.name eq 'name'}">
                <p style="color: red;">${error.message}</p>
            </c:if>
        </c:forEach>
        
    </c:if>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${requestScope.oldInput.email}" >
    <c:if test="${requestScope.errors != null}">
        <c:forEach items="${requestScope.errors}" var="error">
            <c:if test="${error.name eq 'email'}">
                <p style="color: red;">${error.message}</p>
            </c:if>
        </c:forEach>
        
    </c:if>

    <label for="dob">Date of Birth:</label>
    <input type="date" id="dob" name="dob" value="${requestScope.oldInput.dob}">
    <c:if test="${requestScope.errors != null}">
        <c:forEach items="${requestScope.errors}" var="error">
            <c:if test="${error.name eq 'dob'}">
                <p style="color: red;">${error.message}</p>
            </c:if>
        </c:forEach>
    </c:if>

    <label for="phoneNumber">Phone Number:</label>
    <input type="tel" id="phoneNumber" name="phoneNumber" value="${requestScope.oldInput.phoneNumber}">
    <c:if test="${requestScope.errors != null}">
        <c:forEach items="${requestScope.errors}" var="error">
            <c:if test="${error.name eq 'phoneNumber'}">
                <p style="color: red; padding-top: 0px  ">${error.message}</p>
            </c:if>
        </c:forEach>
    </c:if>
                
                

    <button type="submit">Register</button>
  </form>
</body>
</html>
