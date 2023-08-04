<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>這裡要呈現所有基因</title>
</head>
<style>

h1 {
	text-align: center;
	background-color:
}

.table1 {
	border-collapse: collapse;
	border: 3px solid black;
	width: 100%;
	/*  	justify-content: center; /* 水平居中 */
	*/
	/*     align-items: center; /* 垂直居中 */
	*/
}

.table1 td, .table1 th {
	border: 1px solid gray;
	text-align: center;
	width: 100px
}

.nucleic-acid-cell {
	max-width: 200px; /* Adjust the width as needed */
	white-space: nowrap;
	overflow: hidden; /* Set overflow property to 'hidden' */
	text-overflow: ellipsis;
}

.t {
	margin-left: 10px;
}

.h {
	flex-direction: row;
	display: flex;
	justify-content: flex-start;
	margin: 10px;
}

.s {
	margin-left: 80px;
}

tbody>tr:nth-child(2n+1) {
	background-color:LightGray;
}
tbody>tr:nth-child(2n){
	background-color:LightPink;
}

tbody>tr:hover {
	background-color: Thistle;
}
</style>
<body>
	<h1>腸病毒與流行性感冒病毒基因資料</h1>
	<div class="h">
		<div class="t">
			<a href="/MidtermReport0801/TruncateTable.do"><button>刪除表格內所有資料</button></a>
		</div>
		<div class="s">
			<a href="/MidtermReport0801/ToShowLastGene.do">
				<button>新增查詢資料</button>
			</a>
		</div>
	</div>
	<table class="table1">
		<thead>
			<tr>
				<th>編號</th>
				<th>病毒編號</th>
				<th>年齡</th>
				<th>性別</th>
				<th>縣市</th>
				<th>採檢日期</th>
				<th>發病日期</th>
				<th>合約實驗室</th>
				<th>病毒種類</th>
				<th>病毒亞型</th>
				<th>核甘酸序列</th>
				<th>更新時間</th>
				<th>變更資料</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${aList}" var="gene">
				<tr>
					<td>${gene.getvID()}</td>
					<td>${gene.getCaseNumber()}</td>
					<td>${gene.getAge()}</td>
					<td>${gene.getGender()}</td>
					<td>${gene.getCity()}</td>
					<td>${gene.getComfirmedDate()}</td>
					<td>${gene.getSymptomsDate()}</td>
					<td>${gene.getCollaboratingLab()}</td>
					<td>${gene.getVirusType()}</td>
					<td>${gene.getVirusSubtype()}</td>
					<td class="nucleic-acid-cell">${gene.getNucleicAcidSequence()}</td>
					<td>${gene.getUpdateTime()}</td>
					<td><a
						href="/MidtermReport0801/ToShowGeneByID.do?vID=${gene.getvID()}"><button>修改</button></a>
						<a href="/MidtermReport0801/ToDeleteGene.do?vID=${gene.getvID()}"><button
								onclick="showAlert()">刪除</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		function showAlert() {
			var message = "這是一個警告訊息！";
			alert(message);
		}
	</script>
	<%-- <c:forEach items="${aList}" var="gene"> --%>
	<%--     <div>編號: ${ gene.getvID()} </div>   --%>
	<%--     <div>病毒編號：: ${gene.getCaseNumber() }</div> --%>
	<%--     <div>年齡: ${gene.getAge()} </div> --%>
	<%--     <div>性別: ${gene.getGender() }</div> --%>
	<%--     <div>縣市: ${gene.getCity() }</div> --%>
	<%--     <div>採檢日期: ${gene.getComfirmedDate() }</div> --%>
	<%--     <div>發病日期: ${gene.getSymptomsDate() }</div> --%>
	<%--     <div>合約實驗室: ${gene.getCollaboratingLab() }</div> --%>
	<%--     <div>病毒種類: ${gene.getVirusType() }</div> --%>
	<%--     <div>病毒亞型: ${gene.getVirusSubtype() }</div> --%>
	<%--     <div>核甘酸序列: ${gene.getNucleicAcidSequence() }</div> --%>
	<%--     <div>更新時間: ${gene.getUpdateTime() }</div> --%>

	<!--     <div>=================================</div> -->
	<%-- </c:forEach> --%>



</body>
</html>