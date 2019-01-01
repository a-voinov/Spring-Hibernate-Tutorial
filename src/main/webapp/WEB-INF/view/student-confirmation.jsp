<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Student Confirmation</title>
  </head>
  <body>
    The student is confirmed:  ${student.firstName} ${student.lastName} ${student.country} ${student.favoriteLanguage}
    <br>
    Operating systems :
    <ul>
      <c:forEach var="temp" items="${student.operatingSystems}" >
        <li><c:out value="${temp}"></c:out></li>
      </c:forEach>
    </ul>

  </body>
</html>
