<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:choose>
        <c:when test="${empty book.bookTitle}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>
<c:url value="/add" var="addUrl"/>
<c:url value="/edit" var="editUrl"/>
<form action="${empty book.bookTitle ? addUrl : editUrl}" name="book" method="POST">
    <c:choose>
        <c:when test="${!empty book.bookTitle}">
            <p>Edit book</p>
            <input type="hidden" name="id" value="${book.isbn}">
        </c:when>
        <c:otherwise>
            <p>Add new book</p>
        </c:otherwise>
    </c:choose>
    <p><input type="text" name="isbn" placeholder="isbn" value="${book.isbn}" maxlength="20" required>
    <p><input type="text" name="title" placeholder="title" value="${book.bookTitle}" maxlength="100" required>
    <p><input type="text" name="author" placeholder="author" value="${book.authors}" maxlength="100" required>
    <p><input type="text" name="book type" placeholder="book type" value="${book.bookType}" maxlength="20" required>
    <p><input type="number" name="year" placeholder="year" value="${book.publishingYear}" maxlength="4" required>
    <p><input type="number" name="pages" placeholder="pages" value="${book.pages}" maxlength="5" required>
    <p><input type="number" name="price" placeholder="price" value="${book.price}" maxlength="10" required>
    <p><input type="text" name="genre" placeholder="genre" value="${book.price}" maxlength="20" required>
    <p>
        <c:set value="add" var="add"/>
        <c:set value="edit" var="edit"/>
        <input type="submit" value="${empty book.bookTitle ? add : edit}">
    </p>
    <p>${message}</p>
</form>
</body>
</html>
