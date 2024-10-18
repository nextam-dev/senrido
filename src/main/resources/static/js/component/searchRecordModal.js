Vue.component('search-record-modal', {
    template: (function () {/*
        <div class="modal-mask" id="searchRecordModal" v-show="displayFlg">
            <div class="modalWrapperSearch">
				<div class="content-search-form">
					<div class="content-search-flex row">
						<div class="content-label col-3"><label>担当者:</label></div>
						<div class="col-9">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="content-search-flex row"　style="margin-top: 15px;">
						<div class="content-label col-3"><label>入電日:</label></div>
						<div class="col-9"><input type="date" style="margin-right: 10px;" id="startDate">～<input type="date" style="margin-left: 10px;" id="endDate"></div>
					</div>
					<div class="content-search-flex row" style="margin-top: 15px;">
						<div class="content-label col-3"><label>火葬日:</label></div>
						<div class="col-9">
							<label><input type="checkbox" value="1" id="completeStatus" checked>過去の情報表示</label>
						</div>
					</div>
					<div>
						<button style="margin-left: 50px; margin-right: 30px; width: 110px;" v-on:click.prevent="searchData">検索実行</button>
						<button style="width: 110px;" v-on:click.prevent="close">キャンセル</button>
					</div>
				</div>
            </div>
            <processing v-if="processingFlg"></processing>
        </div>
    */}).toString().match(/\/\*([^]*)\*\//)[1],
    data: function () {
    	return {
			displayFlg: false,
			processingFlg:false,
			selectedVehicleNo: '',
			selectedVoter: '',
			// 車両番号
            vehicleList:[],
			// 起票者
			voterList:[],
			// 運行区分
			operationDivCodeList:[],
			completeStatus: [] // completeStatusを配列として定義
    	}
    },
    methods: {
		open: function (item) {
			this.displayFlg = true;
			this.vehicleList = [];
			item.vehicleList.forEach(element => this.vehicleList.push({vehicleNo: element.vehicleNo}));
			this.voterList = [];
			item.voterList.forEach(element => this.voterList.push({name: element.employeeName}));
			this.operationDivCodeList = item.operationDivCodeList;
    	},
    	close: function () {
    		this.displayFlg = false;
    	},
    	updateVehicleNo() {
    		if (this.selectedVehicleNo.trim() === '') {
    	        this.vehicleNo = null;
    	    } else {
    	        this.vehicleNo = this.selectedVehicleNo;
    	    }
  	    },
    	updateVoterName() {
  	    	if (this.selectedVoter.trim() === '') {
  	          this.voterName = null;
  	      } else {
  	          this.voterName = this.selectedVoter;
  	      }
    	},
    	updateOperationDivCode(event) {
	        this.operationDivCode = event.target.value;
	    },
    	searchData: function () {
    		// エラーチェック
    		this.alertMessage = [];
    		let startDate = document.getElementById('startDate').value;
    		let endDate = document.getElementById('endDate').value;

    		if (endDate && startDate > endDate) {
    		    this.alertMessage.push('開始日は終了日以前でなくてはいけません。\n');
    		}

    		if (this.alertMessage.length > 0) {
    		    alert(this.alertMessage.join('\n'));
    		    return;
    		}

    		this.showModalProcessing();
    		// 変数の宣言と初期化
    		const completeStatusCheckbox = document.getElementById('completeStatus');
    		const inCompleteStatusCheckbox = document.getElementById('inCompleteStatus');

    		// オブジェクトの初期化
    		var postItem = {
    		    vehicleNo: this.vehicleNo,
    		    startDate: document.getElementById('startDate').value,
    		    endDate: document.getElementById('endDate').value,
    		    voterName: this.voterName,
    		    operationDivCode: this.operationDivCode,
    		    completeStatus: null,
    		    inCompleteStatus: null
    		};

    		// チェックボックスの状態によって値を代入
    		if (completeStatusCheckbox.checked) {
    		    postItem.completeStatus = completeStatusCheckbox.value;
    		}

    		if (inCompleteStatusCheckbox.checked) {
    		    postItem.inCompleteStatus = inCompleteStatusCheckbox.value;
    		}

    		var self = this;
			axios.post(editUrl('/j003RollCallRecordList/searchList'), postItem)
			.then(response => {
				// エラーの場合
				if(response.data.message != null){
					alert(response.data.message);
					self.closeModalProcessing();
					return;
				}
				self.closeModalProcessing();

				self.moveRollCallRecordListInformation(response.data.rollCallRecordList);
			})
			.catch(err => {
				console.log('err:', err);
				err_function(err);
				self.closeModalProcessing();
			})
    	},
    	moveRollCallRecordListInformation: function (rollCallRecordList) {
    		this.displayFlg = false;
    		this.$emit('move-main', rollCallRecordList);
    	},
    	showModalProcessing:function() {
			this.processingFlg = true;
		},
		closeModalProcessing:function() {
			this.processingFlg = false;
		},
    },
});
