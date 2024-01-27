<%-- 
    Document   : ViewService
    Created on : Jan 27, 2024, 8:21:00 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Service Table</title>
        <link rel="stylesheet" href="././CSS/Admin/viewService.css" />
</head>

<body>

    <h2>Service Table</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Details</th>
                <th>Min Weight</th>
                <th>Max Weight</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${sessionScope.serviceList != null}">
                <c:forEach items="${sessionScope.serviceList}" var="service" varStatus="serviceListStatus">
                   
                        <tr>
                            <td>${service.id}</td>
                            <td>${service.name}</td>
                            <td class="details-cell">${service.details}</td>
                            <td>${service.minimumWeight}</td>
                            <td>${service.maximumWeight}</td>
                            <td>${service.price}$</td>
                            <td class="button-cell">
                                <button class="edit-button" onclick="showEditForm(1)">Edit</button>
                                <button class="disable-button">Disable</button>
                            </td>
                        </tr>
                   
                </c:forEach>
            </c:if>
            
            <!-- Add similar rows for other services -->
        </tbody>
    </table>

    <form class="edit-form" id="editForm1" method="post">
        <div class="form-container">
            <button class="close-button" onclick="closeEditForm(1)">Close</button>
            <input type="text" placeholder="Service Name">
            <textarea placeholder="Service Details"></textarea>
            <input type="number" placeholder="Min Weight">
            <input type="number" placeholder="Max Weight">
            <input type="number" placeholder="Price">
            <button onclick="saveChanges(1)">Save Changes</button>
        </div>
    </form>

    <script src="././JavaScript/Admin/viewService.js" ></script>

</body>

</html>
