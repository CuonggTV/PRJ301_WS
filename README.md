# Document
## <ins>I. Techstack</ins>
  - Front-end: HTML, CSS, JSP, Javascript
  - Backend: Java (Servlet)
  - Database: SQL Server

## <ins>II. Requirement</ins>
  - Build a servlet website for the pet center. The website has two roles: Customer and Admin.
  1. Customer
     - Log in, register.
     - CRUD pets in the system.
     - Can view services and book a service for a pet.
     - Can cancel the booking.
     - View booking history.
     - Send feedback after checkout.
  2. Admin
     - Search, view, block/unblock customer.
     - CRUD services (just disable. don't delete).
     - Manage services's price.
     - View and update the booking's status (confirm, check-in, checkout).
     - View and reply to feedback.
     - Change booking information if the customer’s pet is not fit.

## <ins>III. Diagrams</ins>
  1. ERD
![ERD](/Diagrams/ERD.png)

  2. Relational Schema
![RS](/Diagrams/RS.png)

## <ins>IV. Tasks</ins>
#### Customer
<details>
  <summary>Log in</summary>
  
  - [ ] Check input empty or full spaces (use trim).
  - [ ] Check if username and password match -> send redirect to home page.
  - [ ] If not match, send error.
</details>

<details>
  <summary>Register</summary>
  
  - [x] Register has these inputs: username, password, email name, date of birth, and phone number.
  - [x] Check input empty or full spaces (use trim).
  - [x] Check username exists -> if yes, send error.
  - [x] Check password is equal to confirmed password.
  - [ ] Check email format (abc123@gmail.com)
  - [x] Check dob -> if pass 18 years from now, send error.
  - [x] Check phone number (10 digits only)
</details>
