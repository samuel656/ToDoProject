<%@include file="common/header.jspf" %>

<head>
<title>Add ToDo Page</title>
</head>

<%@include file="common/navigation.jspf" %>

<div class="container">
    <h1>Enter ToDo Details</h1>
    <hr>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description"/>
            <form:errors path="description" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="mb-3">
          <form:label path="target">Target Date</form:label>
          <form:input type="text" path="target"/>
          <form:errors path="target" cssClass="text-danger"/>
        </fieldset>

       <fieldset class="mb-3">
           <form:label path="done">Is Task Completed?</form:label><br/>

           <form:radiobutton path="done" value="true" /> Yes
           <form:radiobutton path="done" value="false" /> No

           <form:errors path="done" cssClass="text-danger" />
       </fieldset>



    <form:input type="hidden" path="id" />

    <input type="submit" value="submit" class="btn btn-success">
    </form:form>
</div>



<%@include file="common/footer.jspf" %>
