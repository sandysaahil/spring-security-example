<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head></head>
<body>
   <h1>Custom Login</h1>
   <c:url value="/login" var="loginVar"/>
   <form name='f' action="${loginVar}" method='POST'>
      <table>
      
      <c:if test="${param.err != null }">
      	<tr>
            <td><p>Invalid username or password</p></td>
         </tr>
      </c:if>
      
         
         
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html>