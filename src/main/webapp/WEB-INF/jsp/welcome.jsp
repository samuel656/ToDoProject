<%@include file="common/header.jspf" %>

<head>
    <title>Welcome Page</title>
</head>

<%@include file="common/navigation.jspf" %>

<div class="container">
<div>
    <h1>Welcome Page</h1>
</div>
<div class="container">Your Name: ${uname}</div>
<div class="container"><a href="list-todos">Manage</a>Your Todos</div>

</div>

<%@include file="common/footer.jspf" %>
