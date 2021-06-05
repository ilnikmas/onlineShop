<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BOOKS</title>
</head>
<body>

<h2>Books</h2>
<table>
    <tr>
        <th>№</th>
        <th>isbn</th>
        <th>book title</th>
        <th>authors</th>
        <th>book type</th>
        <th>publishing year</th>
        <th>pages</th>
        <th>price</th>
        <th>genre</th>
        <th colspan="2">action</th>
    </tr>
    <c:forEach var="book" items="${booksList}" varStatus="i">
        <tr>
            <td>${i.index + 1 + (page - 1) * 10}</td>
            <td>${book.isbn}</td>
            <td>${book.bookTitle}</td>
            <td>${book.authors}</td>
            <td>${book.bookType}</td>
            <td>${book.publishingYear}</td>
            <td>${book.pages}</td>
            <td>${book.price}</td>
            <td>${book.genre}</td>
            <td><a href="<c:url value="/edit/${book.isbn}"/>">edit</a></td>
            <td><a href="<c:url value="/delete/${book.isbn}"/>">delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
            <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
                <c:url value="/" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href="${url}">${i.index}</a>
            </c:forEach>
            <p>
                <a href="<c:url value="/add"/>">Add new book</a>
            </p>
        </td>
