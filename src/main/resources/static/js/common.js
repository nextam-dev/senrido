var baseW = 1024;	//基準となるブレークポイント
var spW = 385;	//基準となるブレークポイント
var spviewportW = 0;
var ua = navigator.userAgent.toLowerCase();
var isSp = (ua.indexOf("iphone") > -1) || (ua.indexOf("ipod") > -1) || (ua.indexOf("ipad") > -1 || ua.search(/macintosh/) > -1 && 'ontouchend' in document) || (ua.indexOf("Android") > -1);


$(function(){
	$('#Logout').on("click",function(){
		var baseUrl = $('#baseUrl').val();
		window.location.href = baseUrl + 'logout';
	});

	if(isSp){
		spviewportW = document.documentElement.clientWidth;
	}

	//イベントハンドラ登録
	window.addEventListener("resize", updateMetaViewport, false);
	window.addEventListener("orientationchange", updateMetaViewport, false);
	//初回イベント強制発動
	var ev = document.createEvent("UIEvent");
	ev.initEvent("resize", true, true)
	window.dispatchEvent(ev);
	// ページ上部に戻る:垂直方向のスクロール
	var pagetop = $('.scroll');
    $(window).scroll(function(){
        if ($(this).scrollTop() > 100) {
        	pagetop.show();
        } else {
        	pagetop.hide();
        }
    });
})

function updateMetaViewport(){
	var viewportContent;
	var w = window.outerWidth;
	if(isSp){
		w = spviewportW;
	}
	viewportContent = "width="+baseW+"px,user-scalable=no,shrink-to-fit=yes";
	document.querySelector("meta[name='viewport']").setAttribute("content", viewportContent);

}

// ajaxの戻り値を準備
var getdata = {};

var　TIMEOUT = 300;	// 300 * 100msec = 30.0sec

//---------------------------
// postでsubmitする
// （Formのデータを引き継ぐため
function postAction(url) {
	var baseUrl = $('#baseUrl').val();
	var form = document.getElementById("mainForm");
	form.action = baseUrl + url;
	form.submit();
	return true;
}
//---------------------------
//ボタン非活性&ロード中表示
function load(){
	$("#loading").css("display","");
	$(".operation").attr("disabled","disabled");
}
//---------------------------
//ボタン活性&ロード中消去
function loadClear(){
	$("#loading").css("display","none");
	$(".operation").removeAttr("disabled");
}
//---------------------------
//コンテキストパスを指定
function editUrl(val) {
	//var contextpath = '/trial';
	var contextpath = '/goitai';
	return contextpath + val;
	}
//---------------------------
// ajax実行(非同期)
// タイムアウト監視は別途個々で実施
//---------------------------
//function postAjax(url, postData) {
//
//	$.ajax({
//		type: "POST",
//		url: url,
//		data: JSON.stringify(postData),
//		headers: {
//	       	'X-XSRF-TOKEN': $.cookie('XSRF-TOKEN'),
//	    },
//		contentType: 'application/json',
//		dataType: "json",
//		success: function(data, dataType){
//			if (data.resultCd === undefined) {
//				location.href="/login";
//			}
//			getdata = data;
//		},
//		error: function(XMLHttpRequest, textStatus, errorThrown){
//			if (textStatus == 403) {
//				alert("不正なアクセスです");
//				return;
//			}
////		    $('#error').show();
//		}
//	});
//}
//---------------------------
//ajax通信１つのurlで1つresultString結果をobjに出力する共通処理
// objはinput or label
// （基本エラーがおきないことを前提の処理）
//---------------------------
//function ajaxRequestOneResult(url, postData, obj) {
//	console.log(postData);
//	getdata = {};
//	var timeoutCnt = 0;
//	postAjax(url, postData);
//	var id = setInterval(function() {
//		if (getdata.resultCd === undefined) {
//			timeoutCnt++;
//			if (timeoutCnt > TIMEOUT) {
//				// インターバル停止
//				clearInterval(id);
//				return null;
//		   	}
//		}
//		else {
//			// インターバル停止
//			clearInterval(id);
//			if (getdata.resultCd == '1') {
//				return null;
//			}
//			// 正常応答
//			if (obj.val() === undefined) {
//				obj.text(getdata.resultString);
//			}
//			else {
//				obj.val(getdata.resultString);
//			}
//			return;
//		}
//	}, 100);
//}

//---------------------------
//ajax通信和暦変換
//objはinput or label
//（基本エラーがおきないことを前提の処理）
//---------------------------
//function ajaxRequestResultWareki(url, postData, objBirthDateJ, objEra) {
//	console.log(postData);
//	getdata = {};
//	var timeoutCnt = 0;
//	postAjax(url, postData);
//	var id = setInterval(function() {
//		if (getdata.resultCd === undefined) {
//			timeoutCnt++;
//			if (timeoutCnt > TIMEOUT) {
//				// インターバル停止
//				clearInterval(id);
//				return null;
//		   	}
//		}
//		else {
//			// インターバル停止
//			clearInterval(id);
//			if (getdata.resultCd == '1') {
//				return null;
//			}
//			// 正常応答
//			if (objBirthDateJ.val() === undefined) {
//				objBirthDateJ.text(getdata.resultString);
//			}
//			else {
//				objBirthDateJ.val(getdata.resultString);
//			}
//			// 正常応答
//			if (objEra.val() === undefined) {
//				objEra.text(getdata.resultEra);
//			}
//			else {
//				objEra.val(getdata.resultEra);
//			}
//			return;
//		}
//	}, 100);
//}

var subwindowArg;
var subwindowRet;

//function windowOpen(url,arg){
//	subwindowArg=arg;
//	window.open(url);
//}
//function subwindowOpen(url,windowName,width,height,arg){
//	subwindowArg=arg;
//	window.open(url,windowName,'width='+width+',height='+height);
//}

function getSubwindowArg(){
	return window.opener.subwindowArg;
}

function windowClose(ret,onSubwindowClosed){
	subwindowClose(ret,onSubwindowClosed);
}
function subwindowClose(ret,onSubwindowClosed){
	window.opener.subwindowRet = ret;
	window.close();
	onSubwindowClosed();
}

function getSubwindowRet(){
	return subwindowRet;
}

/**
 * ページ内のINPUTを収集する.
 *
 * @param selector
 *            (null可) 子要素のみを収集対象とする。
 */
function gatherInputs(selector, isId) {

	var object = {};
	function set(elem) {
		var obj = $(elem);
		var name = obj.attr("id");

		if (name) {
			var value = obj.val();
			object[name] = value;
		}
	}
	function set2(elem) {
		var obj = $(elem);
		var name = obj.attr("name");
		var id = obj.attr("id");

		if (id) {
			var value = obj.val();
			object[name] = value;
		}
	}
	if (!isId) {
		set = set2;
	}

	$("input:not(:radio):not(:button):not(:checkbox)",selector).each(function(i, elem) {
		set(elem);
	});
	$("input:radio:checked",selector).each(function(i, elem) {
		set2(elem);
	});
	$("input:checkbox",selector).each(function(i, elem) {
		var name;
		if (!isId) {
			name = $(elem).attr("name");
		} else {
			name = $(elem).attr("id");
		}
		if (name) {
			if ($(elem).is(":checked")) {
				object[name] = "true";
			} else {
				object[name] = "false";

			}
		}
	});
	$("select option:selected",selector).each(function(i, elem) {
		set($(elem).parent()[0]);
	});
	$("textarea",selector).each(function(i, elem) {
		set(elem);
	});
	return object;
}

//取得データを画面に反映させる
function fSetData(selector, data){
	var parent = $(selector);
    for (var keyString in data) {
        var obj = parent.find("input[name=" + keyString + "]");
        if(obj.is("input:checkbox")){
        	if (data[keyString] == 1) {
        		obj.get(0).checked = true;
        	} else {
        		obj.get(0).checked = false;
        	}
        }else if(obj.is("input:radio")){
        	var flg = 0;
        	var val = 99;
            obj.each(function(i, elem){
                if ($(elem).val()==data[keyString]) {
                	flg = 1;
                	$(elem).get(0).checked = true;
                } else {
                	$(elem).get(0).checked = false;
                }
                if (val > $(elem).val()) {
                	val = $(elem).val();
                }
            });
            if (flg == 0) {
            	obj.each(function(i, elem){
                    if ($(elem).val()==val) {
                    	$(elem).get(0).checked = true;
                    }
                });
            }
        }else{
			$("#"+keyString+":not(:input)").html(data[keyString]);

			$("#"+keyString+":not(label):not(:checkbox)").val(data[keyString]);
        }
    }
}

//取得データを画面に反映させる
function clearSetData(selector, data){
	var parent = $(selector);
    for (var keyString in data) {
        var obj = parent.find("input[name=" + keyString + "]");
        if(obj.is("input:checkbox")){
        	if (data[keyString] == 1) {
        		obj.get(0).checked = true;
        	} else {
        		obj.get(0).checked = false;
        	}
        }else if(obj.is("input:radio")){
        	var flg = 0;
        	var val = 99;
            obj.each(function(i, elem){
                if ($(elem).val()==data[keyString]) {
                	flg = 1;
                	$(elem).get(0).checked = true;
                } else {
                	$(elem).get(0).checked = false;
                }
                if (val > $(elem).val()) {
                	val = $(elem).val();
                }
            });
            if (flg == 0) {
            	obj.each(function(i, elem){
                    if ($(elem).val()==val) {
                    	$(elem).get(0).checked = true;
                    }
                });
            }
        }else{
        	if (keyString != "list") {
				$("#"+keyString+":not(:input)").html(data[keyString]);

				$("#"+keyString+":not(label):not(:checkbox)").val(data[keyString]);
        	}
        }
    }
}

//金額カンマ整形
function addComma(id){
	var num = new String($("#"+id).val()).replace(/,/g, "");
	while(num != (num = num.replace(/^(-?\d+)(\d{3})/, "$1,$2")));
	$("#"+id).val(num);
}
//金額カンマ整形
function addCommaStr(str){
	var num = new String(str).replace(/,/g, "");
	while(num != (num = num.replace(/^(-?\d+)(\d{3})/, "$1,$2")));
	return num;
}

//日付フォーマット(和暦)チェック及び変換
function FormatDateJ(obj, era){
	if(obj.val().length == 8 || obj.val().length == 6) {
		date_formatJ(obj, era);
	}
	else {
		obj = obj.val("");
		// @@@ TODO エラーを出す
	}
}
function date_formatJ(text_obj, era){
	var in_s = jQuery.trim(text_obj.val());
	var out_s = _date_formatJ(in_s, era);
	text_obj.val(out_s);
}
function _date_formatJ(in_s, era){
	in_s = in_s.replace(/１/ig, "1").replace(/２/ig, "2").replace(/３/ig, "3").replace(/４/ig, "4").replace(/５/ig, "5")
			.replace(/６/ig, "6").replace(/７/ig, "7").replace(/８/ig, "8").replace(/９/ig, "9").replace(/０/ig, "0")
			.replace(/／/ig, "/").replace(/／/ig, "/");

	var out_s = "";
	var spl = "/";

	var sl1 = 0;
	var sl2 = 1;

	if(in_s == ""){
	}else if(in_s.match(RegExp("^[0-9][0-9](0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$"))) {
		// ggmmdd
		out_s = in_s.substr(0, 2) + spl + zeroPadding(in_s.substr(2, 2), 2) + spl + zeroPadding(in_s.substr(4, 2), 2);

	}else if(in_s.match(RegExp("^[0-9][0-9][/|-](0?[1-9]|1[0-2])[/|-](0?[1-9]|[12][0-9]|3[01])$"))) {
		// gg/mm/dd
		sl1 = in_s.indexOf("/", 0);
		sl2 = in_s.indexOf("/", sl1+1);
		out_s = in_s.substr(0, 2) + spl + zeroPadding(in_s.substr(3, sl2-sl1-1), 2) + spl + zeroPadding(in_s.substr(sl2+1), 2);

	}
	return out_s
}

//日付の正当性チェック
function check_dateJ(str_val, era){
	//桁数チェック era gg/mm/dd
	if(str_val.length != 8) return false;

	var n_g = parseInt(str_val.substr(0,2));
	var n_m = parseInt(str_val.substr(3,2));
	var n_d = parseInt(str_val.substr(6,2));
	var startYearJ  = new Array(1868, 1912, 1926, 1989);
	var lastYearJ  = new Array(45, 15, 64, 31);
	var lastMonthJ = new Array( 7, 12,  1,  4);
	var lastDayJ   = new Array(30, 24,  7, 30);
	var monthEndDay = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	var cal = new Date;
	var n_day = 0;

	var n_era = parseInt(era);
	var n_y = n_g + startYearJ[n_era] - 1;

	//月チェック
	if((n_m < 1) || (12 < n_m)) return false;

	//うるう年計算
	cal.setYear(n_y);
	cal.setMonth(n_m - 1);
	n_day = monthEndDay[n_m - 1];
	if((n_m == 2)&&(((n_y%4 == 0)&&(n_y%100 != 0))||(n_y%400 == 0))) n_day = 29;

	//日チェック
	if((n_d < 0) || (n_day < n_d)) return false;

	if (n_era > 3) {
		// 新年号はOKで通す
		return true;
	}
	// 各和暦の最後日より大きい場合はエラー
	if (n_g > lastYearJ[n_era]) {
		return false;
	}
	if (n_g == lastYearJ[n_era] && n_m > lastMonthJ[ear]) {
		return false;
	}
	if (n_g == lastYearJ[n_era] && n_m == lastMonthJ[n_era] && n_d > lastDayJ[n_era]) {
		return false;
	}

	return true;
}

//日付フォーマット
function FormatDate(obj){
	len = obj.val().length;
	if(len == 10 || len == 8 || len == 6 || len == 4 || len == 2) {
		date_format(obj);
	}
	else {
		obj = obj.val("");
		// @@@ TODO エラーを出す
	}
}
function date_format(text_obj){
	var in_s = jQuery.trim(text_obj.val());
	var out_s = _date_format(in_s);
	text_obj.val(out_s);
}
function date_format_yy(text_obj){
	var in_s = jQuery.trim(text_obj.val());
	var out_s = _date_format(in_s);
    out_s = out_s.substr(2);
	text_obj.val(out_s);
}
function _date_format(in_s){
	in_s = in_s.replace(/１/ig, "1").replace(/２/ig, "2").replace(/３/ig, "3").replace(/４/ig, "4").replace(/５/ig, "5")
			.replace(/６/ig, "6").replace(/７/ig, "7").replace(/８/ig, "8").replace(/９/ig, "9").replace(/０/ig, "0")
			.replace(/／/ig, "/").replace(/／/ig, "/");

	var out_s = "";
	var spl = "/";
	var c_year = get_current_year();
	var c_month = get_current_month();

	var sl1 = 0;
	var sl2 = 1;

	if(in_s == ""){

	}else if(in_s.match(RegExp("^(0[1-9]|[12][0-9]|3[01])$"))) { // dd
		out_s = c_year + spl + zeroPadding(c_month, 2) + spl + zeroPadding(in_s.substr(0, 2), 2);
	}else if(in_s.match(RegExp("^(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$"))) { // mmdd
		out_s = c_year + spl + zeroPadding(in_s.substr(0, 2), 2) + spl + zeroPadding(in_s.substr(2, 2), 2);

	}else if(in_s.match(RegExp("^[0-9][0-9](0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$"))) { // yymmdd
		out_s = "20" + in_s.substr(0, 2) + spl + zeroPadding(in_s.substr(2, 2), 2) + spl + zeroPadding(in_s.substr(4, 2), 2);

	}else if(in_s.match(RegExp("^[0-2][0-9][0-9][0-9](0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$"))) { // yyyymmdd
		out_s = in_s.substr(0, 4) + spl + zeroPadding(in_s.substr(4, 2), 2) + spl + zeroPadding(in_s.substr(6, 2), 2);

	}else if(in_s.match(RegExp("^(0?[1-9]|1[0-2])[/|-](0?[1-9]|[12][0-9]|3[01])$"))) { // mm/dd
		sl1 = in_s.indexOf("/", 0);
		out_s = c_year + spl + zeroPadding(in_s.substr(0, sl1), 2) + spl + zeroPadding(in_s.substr(sl1+1), 2);

	}else if(in_s.match(RegExp("^[0-9][0-9][/|-](0?[1-9]|1[0-2])[/|-](0?[1-9]|[12][0-9]|3[01])$"))) { // yy/mm/dd
		sl1 = in_s.indexOf("/", 0);
		sl2 = in_s.indexOf("/", sl1+1);
		out_s = "20" + in_s.substr(0, 2) + spl + zeroPadding(in_s.substr(3, sl2-sl1-1), 2) + spl + zeroPadding(in_s.substr(sl2+1), 2);

	}else if(in_s.match(RegExp("^[0-2][0-9][0-9][0-9]-(0?[1-9]|1[0-2])-(0?[1-9]|[12][0-9]|3[01])$"))) { // yyyy/mm/dd
		out_s = in_s;
	}else if(in_s.match(RegExp("^[0-2][0-9][0-9][0-9][/|-](0?[1-9]|1[0-2])[/|-](0?[1-9]|[12][0-9]|3[01])$"))) { // yyyy/mm/dd
		sl1 = in_s.indexOf("/", 0);
		sl2 = in_s.indexOf("/", sl1+1);
		out_s = in_s.substr(0, 4) + spl + zeroPadding(in_s.substr(5, sl2-sl1-1), 2) + spl + zeroPadding(in_s.substr(sl2+1), 2);
	}

	if(!check_date(out_s)) return "";

	//0埋しない場合
	//out_s = out_s.replace(/\/0/ig, "/");
	return out_s
}
//現在年の取得
function get_current_year(){
	var date = new Date();
	return date.getFullYear();
}
//現在月の取得
function get_current_month(){
	var date = new Date();
	return date.getMonth() + 1;
}
//日付の正当性チェック
function check_date(str_val){
	//桁数チェック yyyy/mm/dd
	if(str_val.length != 10) return false;

	var n_y = str_val.substring(0,4);
	var n_m = str_val.substring(5,7);
	var n_d = str_val.substring(8,10);
	var monthEndDay = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	var cal = new Date;
	var n_day = 0;

	//月チェック
	if((n_m < 1) || (12 < n_m)) return false;

	//うるう年計算
	cal.setYear(n_y);
	cal.setMonth(n_m - 1);
	n_day = monthEndDay[n_m - 1];
	if((n_m == 2)&&(((n_y%4 == 0)&&(n_y%100 != 0))||(n_y%400 == 0))) n_day = 29;

	//日チェック
	if((n_d < 0) || (n_day < n_d)) return false;

	return true;
}

//0埋め処理
function zeroPadding(numStr, num) {
	if(numStr == "") return "";
	return ("00000000" + numStr).slice(-1 * num);
}

//datepicker表示左上
function datepickerLeftTop(id) {
	$("#"+ id).datepicker({
	    beforeShow: function(input, inst) {
	        var calendar = inst.dpDiv;    // Datepicker

	        setTimeout(function() {
	            calendar.position({
	                my: 'right bottom',    // カレンダーの左下
	                at: 'right top',       // 表示対象の左上
	                of: input             // 対象テキストボックス
	            });
	        }, 1);
	    }
	});
}

/* 半角数字チェック */
function NumberCheck(obj) {
   var str = obj.val();
   if( str.match( /[^0-9]+/ ) ) {
      return 1;
   }
   return 0;
}
/* 半角数字チェック */
function NumberCheckStr(str) {
	if (str === undefined || str == "") {
		return 1;
	}
	if( str.match( /[^0-9]+/ ) ) {
		return 1;
	}
	return 0;
}

/* 半角数字(小数)チェック */
function FloatCheck(obj) {
   var str = obj.val();
   if( str.match( /[^0-9.]+/ ) ) {
      return 1;
   }
   return 0;
}

//半角英数チェック
function HankakuEisuCheck(obj){
	var str = obj.val();
	if( str.match( /[^0-9A-Za-z]+/ ) ){
		return 1;
	}
	return 0;
}

function HankakuCheck(obj) {
	var str = obj.val();
	if( str.match( /[^a-zA-Z0-9!-\/:-@¥[-`{-~]+/ ) ){
		return 1;
	}
	return 0;

//
//	var str = obj.val();
//    for (var i = 0; i < str.length; i++) {
//        var c = str.charCodeAt(i);
//        alert(c)
//        // Shift_JIS: 0x0 ～ 0x80, 0xa0 , 0xa1 ～ 0xdf , 0xfd ～ 0xff
//        // Unicode : 0x0 ～ 0x80, 0xf8f0, 0xff61 ～ 0xff9f, 0xf8f1 ～ 0xf8f3
//        if ( (c >= 0x0 && c < 0x81) || (c == 0xf8f0) || (c >= 0xff61 && c < 0xffa0) || (c >= 0xf8f1 && c < 0xf8f4)) {
//            return 1;
//        }
//    }
//    return 0;
}

function compareDate(year1, month1, day1, year2, month2, day2) {
    var dt1 = new Date(year1, month1 - 1, day1);
    var dt2 = new Date(year2, month2 - 1, day2);
    var diff = dt1 - dt2;
    var diffDay = diff / 86400000;//1日は86400000ミリ秒
    return diffDay;
}

function errorBg(id) {
	$("#"+id).removeClass('bgRed');
	$("#"+id).addClass('bgError');
}

function errorBgClear(id) {
	$("#"+id).removeClass('bgRed');
	$("#"+id).removeClass('bgError');
	$("#"+id).addClass('bgRed');
}

function errorBgClearYen(id) {
	$("#"+id).removeClass('bgRed');
	$("#"+id).removeClass('bgError');
}

function toBoolean(bool) {
	if (bool === 'true')
		return true;
	return false;
}

// ---------------------------
// エラー表示
//---------------------------
function errorDisp(str) {
	$("div.fieldError").append("<li class='fieldError'>" + str + "</li>");
}

//---------------------------
// エラークリア
//---------------------------
function errorClear() {
	$("li.fieldError").remove();
}

//---------------------------
//消費税計算
//---------------------------
function calcTax(unitPrice, amount, tax) {
	return Math.round(((unitPrice * amount) * tax) / 100);
}

//---------------------------
//空白文字チェック
//---------------------------
function emptyToZero(val) {
	var result = val;
	//
	if (val == null || val == "") {
		result = 0;
	}
	return result;
}

//---------------------------
//エスケープシーケンス文字変換
//---------------------------
function escapeSequence(str) {
	str = str.replace(/\./g, '\\.');
	str = str.replace(/\[/g, '\\[');
	str = str.replace(/\]/g, '\\]');
	return str;
}

//---------------------------
//URLからパラメータ取得
//---------------------------
function getParam(name, url) {
	if (!url) url = window.location.href;
	name = name.replace(/[\[\]]/g, "\\$&");
	var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
	    results = regex.exec(url);
	if (!results) return null;
	if (!results[2]) return '';
	return decodeURIComponent(results[2].replace(/\+/g, " "));
}

//---------------------------
//バリデーション、エラーチェック
//---------------------------
function checkValid(resultCd, messageList) {
	var bisError = "400";
	var sysError = "999";

	this.message = [];
	var alertMessage = [];
	if(resultCd == bisError || resultCd == sysError) {
	if(messageList === undefined){
		this.message.push("予期せぬシステムエラーが発生しました。\r\n事象が改善されないときは画面コピー添付の上、管理者までご連絡ください。");
	}else{
		this.message = messageList;
	}
	for(var item in this.message) {
		alertMessage.push(this.message[item].message + "\r\n");
	}
}
	return alertMessage;
}

//---------------------------
//印刷プレビュー表示（タブレット）
//---------------------------
function printJSFixed(options) {
	if (isSp) {
		const printWindow = window.open(options.printable, 'print');
		setTimeout(function() {
			printWindow.print();
		}, 1000);

	} else {
		printJS(options);
	}
}
function printJSFixedAll(options) {
	if (isSp) {
		const printWindow = window.open(options.printable, 'print');
		setTimeout(function() {
			printWindow.print();
		}, 3000);

	} else {
		printJS(options);
	}
}
