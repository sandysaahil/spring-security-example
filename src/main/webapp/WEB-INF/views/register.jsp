<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<html>
<head></head>
<body>
   <h1>User Registration</h1>
   <c:url value="/register" var="regVar"/>
   <fieldset>
    <legend>User Input From</legend>
    <form:form action="${regVar}" method="post" modelAttribute="user">
      <table>
        <tr>
          <th>Name</th>
          <td>
            <form:input path="name" /> 
            <form:errors path="name" cssClass="error" />
          </td>
          </tr>
          <tr>
          <th>Email</th>
          <td>
            <form:input path="email" /> 
            <form:errors path="email" cssClass="error" />
          </td>
          </tr>
          <tr>
          <th>Username</th>
          <td>
            <form:input path="username" /> 
            <form:errors path="username" cssClass="error" />
          </td>
          </tr>
          <tr>
          <th>Password</th>
          <td>
            <form:input path="password" /> 
            <form:errors path="password" cssClass="error" />
          </td>
          </tr>
          
          <td><button type="submit">Submit</button></td>
        </tr>
      </table>
    </form:form>
  </fieldset>
</body>
</html>