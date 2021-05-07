<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
        ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>

</c:if>
<label for="report_date">日付</label>
<input type="date" name="report_date" value="<fmt:formatDate value='${report.report_date}' pattern='yyyy-MM-dd' />" />
<br  /><br  />

<label for="name">氏名</label><br  />
<c:out value="${sessionScope.login_employee.name}"/>
<br  /><br  />

<label for="title">タイトル</label><br />
<input type="text" name="title" value="${report.title}">
<br  /><br  />

<label for="content">内容</label><br  />
 <textarea name="content" rows="10" cols="50">${report.content}</textarea>
<br /><br />

<p>例のように入力をお願いします。（例　12時59分</p>
<br />

<label for="syukkin">出勤</label><br />
<input type="text" name = "syukkin" value="${report.syukkin}">
<br  /><br  />

<label for="taikin">退勤</label><br />
<input type="text" name ="taikin" value="${report.taikin}">
<br  /><br  />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>