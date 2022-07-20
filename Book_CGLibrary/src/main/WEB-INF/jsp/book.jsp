<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1 class="text-danger text-center">BOOK</h1>


<form:form method="post" action="${action}" modelAttribute="book" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    <div class="form-group">
        <label for="name">Tên sản phẩm</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
        <form:errors path="name" cssClass="alert alert-danger" element="div"/>
    </div>

    <div class="form-group">
        <label for="description">Tác giả</label>
        <form:textarea id="author" path="author" cssClass="form-control"></form:textarea>
    </div>

     <div class="form-group">
        <label for="price">Trạng thái</label>
        <form:input type="text" id="isReady" path="isReady" cssClass="form-control"/>
        <form:errors path="price" cssClass="alert alert-danger" element="div"/>
    </div>


        <div class="form-group">
            <input type="submit" value="Thêm sach" class="btn btn-outline-success" />
        </div>
</form:form>