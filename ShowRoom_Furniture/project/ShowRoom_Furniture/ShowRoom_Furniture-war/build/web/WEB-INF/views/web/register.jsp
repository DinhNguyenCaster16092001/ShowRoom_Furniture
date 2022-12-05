<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="apiUserURl" value="/api/users/checkEmail"/>
<c:url var="addUrl" value='/register'/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="span9">
            <ul class="breadcrumb">
                <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                <li class="active">Registration</li>
            </ul>
            <h3> Registration</h3>	
            <hr class="soft"/>
            <div class="well">
                <form:form id="formRegister" action="${addUrl}" onsubmit="checkEmailUnique(this);" class="form-horizontal" modelAttribute="user" method="POST">
                    <h3>Your Personal Details</h3>
                    <div class="control-group">
                        <label class="control-label" for="inputFname">Họ <sup>*</sup></label>
                        <div class="controls">
                            <form:input path="firstName" class="form-control"  required="required"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputLname">Tên <sup>*</sup></label>
                        <div class="controls">
                            <form:input path="lastName" class="form-control" required="required"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">Email <sup>*</sup></label>
                        <div class="controls">
                            <form:input path="email" class="form-control" required="required" placeholder="Nhập Email" type="email"/>
                        </div>
                    </div>	  
                    <div class="control-group">
                        <label class="control-label">Password <sup>*</sup></label>
                        <div class="controls">
                            <form:input path="password" type="password" class="form-control"  required="required" maxlength="226" minlength="6"
                                        placeholder="Nhập Password"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <input type="submit" name="submitAccount" value="Đăng Kí" class="exclusive shopBtn">
                        </div>
                    </div>
                </form:form>
            </div>

            <script>
                function checkEmailUnique(form) {
                    event.preventDefault()
                    url = "${apiUserURl}";
                    userEmail = $("#email").val();
                    userId = $("#id").val();
                    params = {
                        id: userId,
                        email: userEmail,
                    }
                    $.get(url, params, function (response) {
                        if (response === "OK") {
                            console.log("OK");
                            form.submit();
                            return true;
                        } else if (response === "Duplicated") {
                            alert("There is another user using email " + userEmail + " please try another!!!!")
                            return false;
                        } else {
                            alert("Unknow Error Please Try Again!!!")
                            return false;
                        }
                    }).fail(function () {
                        alert("Error Accurr!!!!")
                    });
                    return false;
                }
            </script>
    </body>

</html>
