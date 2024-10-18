﻿﻿/**
 * 
 */
Vue.component('order_info',{
    props:["err_message"],
    computed:{
        // c_yen:{
        //     get:function(){
        //         //return "￥" + this.item;
        //         return "￥" + String( Math.floor(this.item)).replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,');;
        //     },
        //     set:function(newValue){
        //         this.item = newValue.replace("￥","");
        //     },
        // },
	},
	data:function(){
		return {
			//ベースURL
			baseUrl,
			orderNo:"",
			t_service_contract:
			{
				orderNo: "" ,
				operationStaffCode: "" ,
				operationStaffName: "" ,
				businessStaffCode: "" ,
				businessStaffName: "" ,
				contractDate: "" ,
				secCode: "" ,
				secName: "" ,
				purchaseOnlyRecordFlg: "" ,
				period: "" ,
				seq: "" ,
				contractorName: "" ,
				decedentName: "" ,
				mournerName: "" ,
				coffinDate: "" ,
				mournerFamilyName:"",
				vigilDiv: "" ,
				vigilEndTime: "" ,
				vigilStartTime: "" ,
				funeralDiv: "" ,
				funeralEndTime: "" ,
				funeralStartTime: "" ,
				cremateDiv: "" ,
				cremateEndTime: "" ,
				cremateStartTime: "" ,
				orderDivCode: "" ,
				receiptDateTime: "" ,
				initialMotionCode: "" ,
				initialMotionName: "" ,
				infoCategoryCode: "" ,
				info1Code: "" ,
				info1Name: "" ,
				introducer1Name: "" ,
				info2Code: "" ,
				info2Name: "" ,
				introducer2Name: "" ,
				selfOtherDivCode: "" ,
				templeCode: "" ,
				sectCode: "" ,
				hallCode: "" ,
				hallName: "" ,
				cremationCode: "" ,
				cremationName: "" ,
				note: "" ,
				//createName: "" ,
				createDate: "" ,
				//updateName: "" ,
				updateDate: "" ,
				delFlg: "" ,
			},
            // 契約状況
            vProgress:
            {
                orderNo: "" ,
                coffinResult: "" ,
                printResult: "" ,
                settlementResult: "" ,
                sales: "" ,
                deposit: "" ,
                depositStatus: "" ,
                progressCd: "" ,
                progressName: "" ,
            },
		}
	},
	created(){
		this.baseUrl = $('#baseUrl').val();
		this.orderNo = this.getParameter("orderNo");

		if(this.orderNo != ""){
			axios.get(this.baseUrl + 'ContractRegistration/' + getParameter("orderNo"))
			// thenで成功した場合の処理をかける
			.then(response => {
				console.log('status:', response.status); // 200
				console.log('body:', response.data);     // response body.
				
				this.t_service_contract = response.data.tserviceContract;
				if(this.t_service_contract.contractDate != null && this.t_service_contract.contractDate != "") {
					var tmp_contractDate = moment(this.t_service_contract.contractDate , "YYYY-MM-DDTHH:mm");
					this.t_service_contract.contractDate = tmp_contractDate.format("YYYY/MM/DD");
				}

                this.vProgress =  response.data.vprogress;

            // catchでエラー時の挙動を定義する
			}).catch(err => {
				console.log('err:', err);
				//エラー処理
		        err_function(err);
			});
		}
		
	},
	methods:{
		getParameter:function(key) {
			//パラメーターを配列で取得する。
			var str = location.search.split("?");
			if (str.length < 2) {
			  return "";
			}
		
			var params = str[1].split("&");
			for (var i = 0; i < params.length; i++) {
			  var keyVal = params[i].split("=");
			  if (keyVal[0] == key && keyVal.length == 2) {
				return decodeURIComponent(keyVal[1]);
			  }
			}
			return "";
		  }
	},
	template:'\
	<div>\
		<!-- 受注情報 -->\
		<div class="clearBoth floatLeftAll searchEntry">\
			<div>\
				<label>受注No</label>\
				<input type="text" v-model="orderNo" readonly="readonly" />\
			</div>\
			<div>\
				<label>施行担当</label>\
				<label class="cdLB">{{t_service_contract.operationStaffCode}}</label>\
				<input type="text" v-model="t_service_contract.operationStaffName" readonly="readonly" />\
			</div>\
			<div>\
				<label>業務担当</label>\
				<label class="cdLB">{{t_service_contract.businessStaffCode}}</label>\
				<input type="text" v-model="t_service_contract.businessStaffName" readonly="readonly" />\
			</div>\
			<div class="status">\
				<label>進捗</label>\
				<input type="text"  readonly="readonly" v-model="vProgress.progressName" />\
			</div>\
		</div>\
		<div class="clearBoth floatLeftAll searchEntry">\
			<div>\
				<label>葬家名</label>\
				<input type="text" v-model="t_service_contract.mournerFamilyName" readonly="readonly" />\
			</div>\
			<div>\
				<label>喪主名</label>\
				<input type="text" style="width:155px;" v-model="t_service_contract.mournerName" readonly="readonly" />\
			</div>\
			<div>\
				<label>部門</label>\
				<label id="secCd" class="cdLB">{{t_service_contract.secCode}}</label>\
				<input type="text" v-model="t_service_contract.secName" readonly="readonly" />\
			</div>\
			<div>\
				<label>受注日</label>\
				<input type="text" v-model="t_service_contract.contractDate" readonly="readonly" />\
			</div>\
		</div>\
		<div class="clearBoth  fieldError" >\
			<p  v-for="(item,index) in err_message" >{{item.message}}</p>\
		</div>\
	</div>\
	',
});
