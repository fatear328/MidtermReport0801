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
	font-size: 10px;
	background-color: LemonChiffon;;
}
h1{
font-size:40px;
text-align: center;
}
h2{
font-size:25px;
text-align: center;
}

label {
	width: 100px;
	text-align: right;
	float: left;
}
fieldset {
	width: 500px;
	border:2px solid black;
	height: 500px;
	border-radius: 10px
}
.box{
 display:flex;
 justify-content:space-around;
}
legend{
font-size: 18px;
font-weight: bold;
margin-left: 40px
}

.a,.b{
margin:0 0 40px 0;
}
.u{
margin-top: 55px;
margin-right: 50px;

}
.q{
flex-direction: row;
display: flex;
justify-content: space-between;

}
.p{
margin-left: 108px
}
.r{
margin-left: 5px;
}
</style>
<script type="text/javascript">
function updateVirusSubtype() {
    var virusTypeSelect = document.getElementsByName("vVirusType")[0];
    var virusSubtypeSelect = document.getElementById("vVirusSubtypeSelect");

    // 獲取所選的病毒種類
    var selectedVirusType = virusTypeSelect.value;

    // 隱藏所有病毒亞型選項
    for (var i = 0; i < virusSubtypeSelect.options.length; i++) {
        virusSubtypeSelect.options[i].style.display = "none";
    }

    // 根據所選的病毒種類，顯示對應的病毒亞型選項
    if (selectedVirusType === "Influenza") {
        // 顯示Influenza病毒亞型選項
        showVirusSubtypeOptions(["AH3", "ASWH1","B"]);
    } else if (selectedVirusType === "Human Enteroviru") {
        // 顯示Human Enterovirus病毒亞型選項
        showVirusSubtypeOptions(["EV71","CA10","CA16","CA2","CA4","CA5","CB3","CB4","CB5"]);
    }
    // 添加其他病毒種類的判斷和病毒亞型選項的顯示
}

function showVirusSubtypeOptions(subtypes) {
    var virusSubtypeSelect = document.getElementById("vVirusSubtypeSelect");
    for (var i = 0; i < virusSubtypeSelect.options.length; i++) {
        if (subtypes.includes(virusSubtypeSelect.options[i].value)) {
            virusSubtypeSelect.options[i].style.display = "block";
        }
    }
}
// 	function updateVirusSubtype() {
// 		var virusTypeSelect = document.getElementsByName("vVirusType")[0];
// 		var virusSubtypeSelect = document.getElementsByName("vVirusSubtype")[0];
// 		var selectedVirusType = virusTypeSelect.value;

// 		// 清空病毒亞型下拉框
// 		virusSubtypeSelect.innerHTML = "";

// 		// 根据病毒種類设置病毒亞型下拉框选项
// 		if (selectedVirusType === "0") {
// 			addOption(virusSubtypeSelect, "", "請選擇");
// 			addOption(virusSubtypeSelect, "AH3", "AH3");
// 			addOption(virusSubtypeSelect, "ASWH1", "ASWH1");
// 			addOption(virusSubtypeSelect, "B", "B");
// 		} else if (selectedVirusType === "1") {
// 			addOption(virusSubtypeSelect, "", "請選擇");
// 			addOption(virusSubtypeSelect, "EV7", "EV71");
// 			addOption(virusSubtypeSelect, "CA10", "CA10");
// 			addOption(virusSubtypeSelect, "CA16", "CA16");
// 			addOption(virusSubtypeSelect, "CA2", "CA2");
// 			addOption(virusSubtypeSelect, "CA4", "CA4");
// 			addOption(virusSubtypeSelect, "CA5", "CA5");
// 			addOption(virusSubtypeSelect, "CB3", "CB3");
// 			addOption(virusSubtypeSelect, "CB4", "CB4");
// 			addOption(virusSubtypeSelect, "CB5", "CB5");
// 		} else {
// 			addOption(virusSubtypeSelect, "", "請選擇");
// 		}
// 	}

// 	function addOption(selectElement, value, text) {
// 		var option = document.createElement("option");
// 		option.value = value;
// 		option.text = text;
// 		selectElement.appendChild(option);
// 	}
</script>
<title>建立新腸病毒或流行性感冒病毒基因資料</title>
</head>
<body>
	<h1>腸病毒和流行性感冒病毒基因資料庫</h1>
	<h2>新增病毒資料及查詢</h2>
	<div class="box">
	
	<fieldset>
	<legend>新增病毒資料</legend>
		<form action="ToInsertGene.do" method="POST">
			<div >
				<label>病毒編號：</label> 
				<input type="text" name="vCasenumber">
			</div>	
			<div>
				腸病毒最後一筆編號:${evLastGene}
			</div>	
			<div>	
				流感病毒最後一筆編號:${infLastGene}
		    </div>
				
				
				
<!-- 				<select name="vCasenumber"> -->
<!-- 					<option value="">請選擇</option> -->
<%-- 					<option value="${newEVNumber.getCaseNumber()}">${newEVNumber.getCaseNumber()}</option> --%>
<%-- 					<option value="${newINFNumber.getCaseNumber()}">${newINFNumber.getCaseNumber()}</option> --%>
<!-- 				</select> -->
				<!-- 				<label>病毒編號：</label> <select name="vCasenumber"> -->
				<!-- 					<option value="">請選擇</option> -->
				<!-- 					<option value="0">EV-16-00000</option> -->
				<!-- 					<option value="1">INF-16-00000</option> -->
				<!-- 				</select> -->
			
			<div>
				<label>年齡：</label><input type="number" name="pAge">
			</div>
			<div>
				<label>性別：</label> <select name="pGender">
					<option value="">請選擇</option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
			<div>
				<label>縣市：</label> <select name="pCity">
					<option value="">請選擇</option>
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
				<label>採檢日期：</label> <input type="date" name="pComfirmedDate" id="pComfirmedDate" >
			</div>
			<div>
				<label>發病日期： </label> <input type="date" name="pSymptomsDate" id="pSymptomsDate" >
			</div>
			<div>
				<label>合約實驗室：</label> <select name="vCollaboratingLab">
					<option value="">請選擇</option>
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
					<option value="">請選擇</option>
					<option value="Influenza">Influenza</option>
					<option value="Human Enterovirus">Human Enterovirus</option>

				</select>
			</div>
			<div>
				<label>病毒亞型：</label> <select name="vVirusSubtype">
					<option value="">請選擇</option>
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
					maxlength="1500"></textarea>
			</div>

			<button onclick="showAlert()">新增病原基因資料</button>
		</form>
	</fieldset>



	<fieldset class="add">
	<legend>查詢病毒資料</legend>
	<div class="q">
		<form  class="a" action="ToShowGeneByVirusLab.do" method="POST">
			<div>
				<label>病毒種類：</label> <select name="vVirusType">
					<option value="">請選擇</option>
					<option value="Influenza">Influenza</option>
					<option value="Human Enterovirus">Human Enterovirus</option>

				</select>
			</div>
			<div>
				<label>合約實驗室：</label> <select name="collaboratingLab">
					<option value="">請選擇</option>
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
			<div >
			<button class="p">查詢病原基因資料</button>
			</div>
		</form>
		<div class="u">
			<a href="/MidtermReport0801/ToShowAllGene.do"><button>查詢全部病原基因</button></a>
	   </div>
	</div>
	<div class="r">
	 <form class="b" action="ToUpLoadFile.do" method="post" enctype="multipart/form-data" onsubmit="return showUploadSuccessAlert()">
	    <label>上傳檔案：</label>
        <input type="file" name="EnteroInfluGeneFile" id="file" />
        <input type="submit" value="上傳" />
    </form>
    </div>
	</fieldset>
</div>	
<script>
    function showAlert() {
        alert("新增資料成功！");
    }
</script>
<script>
function showUploadSuccessAlert() {
    // 這裡可以在實際上傳成功時觸發，這裡假設上傳成功了
    var uploadSuccess = true;

    if (uploadSuccess) {
        // 顯示上傳成功的 alert 彈窗
        alert('上傳成功！');
    }

    // 如果你需要在上傳失敗時顯示 alert 彈窗，可以使用類似的方式檢查失敗情況並顯示相應的訊息。

    // 返回 true，讓表單繼續提交；返回 false，阻止表單提交。
    return true;
}
</script>


<script>
    // 获取今天的日期并格式化为YYYY-MM-DD的字符串
    function getToday() {
        var today = new Date();
        var year = today.getFullYear();
        var month = today.getMonth() + 1;
        var day = today.getDate();

        month = (month < 10) ? '0' + month : month;
        day = (day < 10) ? '0' + day : day;

        return year + '-' + month + '-' + day;
    }

    // 设置日期输入框的最大日期为今天
    var pComfirmedDateInput = document.getElementById("pComfirmedDate");
    var pSymptomsDateInput = document.getElementById("pSymptomsDate");

    var today = getToday();
    pComfirmedDateInput.setAttribute("max", today);
    pSymptomsDateInput.setAttribute("max", today);
</script>


</body>
</html>