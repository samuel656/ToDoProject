<%@include file="common/header.jspf" %>

<head>
    <title>ToDO List Page</title>
</head>

<%@include file="common/navigation.jspf" %>

<div class="container">
<div>
    <h1>ToDO List Page</h1>
</div>
<div>Hello ${uname}</div>
<table class="table">
    <thead>

     <th>Decription</th>
     <th>Target Date</th>
     <th>Is Task Completed?</th>
     <th></th>
     <th></th>
    </thead>

    <tbody>
    <c:forEach items="${todos}" var="todo">
    <tr>

    <td>${todo.description}</td>
    <td>${todo.target}</td>
    <td>${todo.done}</td>
    <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<a href="add-todo" class="btn btn-success">Add ToDo</a>


</div>

<%@include file="common/footer.jspf" %>
