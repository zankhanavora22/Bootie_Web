<% 
session.removeAttribute("data");
session.invalidate();
response.sendRedirect("index.jsp");
%>