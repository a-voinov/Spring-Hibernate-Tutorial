<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Customer Confirmation</title>
  </head>
  <body>
    The customer is confirmed:  ${customer.firstName} ${customer.lastName}
    <br><br>
    Free passes : ${customer.freePasses}
    <br><br>
    Postal code : ${customer.postalCode}
    <br><br>
    Course code : ${customer.courseCode}
    <br><br>
  </body>
</html>
