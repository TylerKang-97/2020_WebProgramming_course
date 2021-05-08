<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project"
	prefix="e"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<style>
	table.horizontal {

    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
}

table.horizontal thead th {

    width: 170px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: white;
    background: black;
}

table.horizontal td {

    width: 170px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: white;
}</style>
</head>
<body>
<h1>댓글창</h1>

<form action="./app/story/addStory" method="post">
<table class="horizental">
<thead>
<tr>
<th scope="cols">스토리 입력</th>
</tr>
</thead>

<tbody>
<tr>
<td><input type="text" name="content" placeholder="스토리" style="width: 100%; height: 200px;"/></td>
<td><input type="text" name="name" placeholder="이름" style="width: 40%; height: 100px;"/></td> 
<td><button type="submit">저장</button></td>
</tr>
</tbody>
</table>

</form>
<hr>

<c:forEach var="story" items="${e:forHtml(story.title) }">
<p>${story.name } | ${story.date }</p>
<p>${e:forHtml(story.content) }</p>
</c:forEach>
</body>
</html>