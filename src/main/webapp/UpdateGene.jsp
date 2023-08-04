<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
* {
	margin: 3px;
	
}
h2{
text-align: center;
}
/* label { */
/* 	width: 100px; */
/* 	text-align: right; */
/* 	display: flex; */
/* 	flex-direction: row; */
/* 	align-items: flex-start; */
/* } */

fieldset {
	width: 600px;
	border: 2px solid black;
	height: 500px;
	border-radius: 10px;
	background-color: #CF9;
}

label {
	width: 100px;
	text-align: right;
	float: left;
}

.box {
	display: flex;
	justify-content: space-around;
}
textarea {
	margin-left: 100px
}
legend{
font-size: 18px;
font-weight: bold;
margin-left: 40px;
margin-top: 10px;
}
</style>
<script type="text/javascript">
	function updateVirusSubtype() {
		var virusTypeSelect = document.getElementsByName("vVirusType")[0];
		var virusSubtypeSelect = document.getElementsByName("vVirusSubtype")[0];
		var selectedVirusType = virusTypeSelect.value;

		// 清空病毒亞型下拉框
		virusSubtypeSelect.innerHTML = "";

		// 根据病毒種類设置病毒亞型下拉框选项
		if (selectedVirusType === "0") {
			addOption(virusSubtypeSelect, "", "請選擇");
			addOption(virusSubtypeSelect, "0", "AH3");
			addOption(virusSubtypeSelect, "1", "ASWH1");
			addOption(virusSubtypeSelect, "2", "B");
		} else if (selectedVirusType === "1") {
			addOption(virusSubtypeSelect, "", "請選擇");
			addOption(virusSubtypeSelect, "11", "EV71");
			addOption(virusSubtypeSelect, "3", "CA10");
			addOption(virusSubtypeSelect, "4", "CA16");
			addOption(virusSubtypeSelect, "5", "CA2");
			addOption(virusSubtypeSelect, "6", "CA4");
			addOption(virusSubtypeSelect, "7", "CA5");
			addOption(virusSubtypeSelect, "8", "CB3");
			addOption(virusSubtypeSelect, "9", "CB4");
			addOption(virusSubtypeSelect, "10", "CB5");
		} else {
			addOption(virusSubtypeSelect, "", "請選擇");
		}
	}

	function addOption(selectElement, value, text) {
		var option = document.createElement("option");
		option.value = value;
		option.text = text;
		selectElement.appendChild(option);
	}
</script>
<title>建立新腸病毒或流感病毒基因資料</title>
</head>
<body>
	<h2>修改病毒資料</h2>
	<div class="box">
		<fieldset>
		
			<form action="ToUpdateGene.do" method="POST">
				<div>
					<label>ID：</label> <input type="text" name="vID"
						value="${data.vID }"> 
				</div>
				<div>
						<label>病毒編號：</label> <input
						type="text" name="vCasenumber" value="${data.getCaseNumber()}">

				</div>
				<div>
					<label>年齡：</label><input type="number" name="pAge"
						value="${data.getAge() }">
				</div>
				<div>
					<label>性別：</label> <select name="pGender">
						<option value="${data.getCity() }">${data.getCity() }</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</div>
				<div>
					<label>縣市：</label> <select name="pCity">
						<option value="${data.getGender() }">${data.getGender() }</option>
						<option value="台北市">台北市</option>
						<option value="基隆市">基隆市</option>
						<option value="台北縣">台北縣</option>
						<option value="宜蘭縣">宜蘭縣</option>
						<option value="新竹市">新竹市</option>
						<option value="新竹縣">新竹縣</option>
						<option value="桃園縣">桃園縣</option>
						<option value="苗栗縣">苗栗縣</option>
						<option value="台中市">台中市</option>
						<option value="台中縣">台中縣</option>
						<option value="彰化縣">彰化縣</option>
						<option value="南投縣">南投縣</option>
						<option value="嘉義市">嘉義市</option>
						<option value="嘉義縣">嘉義縣</option>
						<option value="雲林縣">雲林縣</option>
						<option value="台南市">台南市</option>
						<option value="台南縣">台南縣</option>
						<option value="高雄市">高雄市</option>
						<option value="高雄縣">高雄縣</option>
						<option value="澎湖縣">澎湖縣</option>
						<option value="屏東縣">屏東縣</option>
						<option value="台東縣">台東縣</option>
						<option value="花蓮縣">花蓮縣</option>
						<option value="金門縣">金門縣</option>
						<option value="連江縣">連江縣</option>

					</select>
				</div>
				<div>
					<label>採檢日期：</label> <input type="date" name="pComfirmedDate"
						value="${data.getComfirmedDate()}">
				</div>
				<div>
					<label>發病日期： </label> <input type="date" name="pSymptomsDate"
						value="${data.getSymptomsDate()}">
				</div>
				<div>
					<label>合約實驗室：</label> <select name="vCollaboratingLab">
						<option value="${data.getCollaboratingLab() }">${data.getCollaboratingLab() }</option>
						<option value="三總">三總</option>
						<option value="中榮">中榮</option>
						<option value="台大">台大</option>
						<option value="成大">成大</option>
						<option value="林口長庚">林口長庚</option>
						<option value="高長">高長</option>
						<option value="慈濟">慈濟</option>
						<option value="彰基">彰基</option>
					</select>
				</div>
				<div>
					<label>病毒種類：</label> <select name="vVirusType"
						onchange="updateVirusSubtype()">
						<option value="${data.getVirusType()}">${data.getVirusType()}</option>
						<option value="0">Influenza</option>
						<option value="1">Human Enterovirus</option>

					</select>
				</div>
				<div>
					<label>病毒亞型：</label> <select name="vVirusSubtype">
						<option value="${data.getVirusSubtype()}">${data.getVirusSubtype()}</option>
						<option value="AH3">AH3</option>
						<option value="ASWH1">ASWH1</option>
						<option value="B">B</option>
						<option value="CA10">CA10</option>
						<option value="CA16">CA16</option>
						<option value="CA2">CA2</option>
						<option value="CA4">CA4</option>
						<option value="CA5">CA5</option>
						<option value="CB3">CB3</option>
						<option value="CB4">CB4</option>
						<option value="CB5">CB5</option>
						<option value="EV71">EV71</option>
					</select>
				</div>
				<div>
					<label>核甘酸序列：</label>
					<textarea name="vNucleicAcidSequence" rows="4" cols="50"
						maxlength="1500">${data.getNucleicAcidSequence()}</textarea>
				</div>

				<button>修改病原基因資料</button>
			</form>
		</fieldset>
	</div>






</body>
</html>