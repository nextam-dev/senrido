Vue.component('wearing-glasses-modal', {
    template: (function () {/*
        <div class="modal-mask" id="wearingGlassesModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">メガネの装用</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
	                <div class="row">
	                 	<div class="col-3"></div>
                        <div class="col-4 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="glassesUsageInfo.useGlasses"/>
                            </label>
                        </div>
                        <div class="col-2 item-title">歳頃</div>
                        <div class="col-3"></div>
                    </div>
	            </div><!-- /modal-content -->
                <div class="row">
	                <div class="col-6">
	                    <div class="row">
	                        <div class="col-12 botton-area" style="min-height:40px;">
	                            <button class="modal-delete">削除</button>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-6">
	                    <div class="row">
	                        <div class="col-12 botton-area" style="min-height:40px;">
	                            <button class="modal-regist" @click="update">登録</button>
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
            <processing v-if="processingFlg"></processing>
        </div>
    */}).toString().match(/\/\*([^]*)\*\//)[1],
    data: function () {
    	return {
			displayFlg: false,
			// 進捗フラグ
			processingFlg:false,
			// メガネの装用情報
			glassesUsageInfo: {
				// お客様ID
            	id: null,
            	// 来店日
            	visitDate: null,
            	// メガネの装用
            	useGlasses : null,
			},
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.glassesUsageInfo.id = item.id;
			this.glassesUsageInfo.visitDate = item.visitDate;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					glassesUsageInfo: self.glassesUsageInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertWearingGlasses'), postItem)
			.then(response => {
				console.log("リクエスト成功:", response.data);
				// バリデーション・システムエラーチェック
				var alertMessage = checkValid(response.data.resultCd, response.data.messageList);
                if(alertMessage.length != 0) {
                	alert(alertMessage);
                	self.closeModalProcessing();
                	return;
                }
				// 処理後メッセージ
				alert(response.data.message);
				self.closeModalProcessing();
			})
			.catch(err => {
				console.log('err:', err);
				err_function(err);
				self.closeModalProcessing();
			});
		},
    	close: function () {
            this.displayFlg = false;
            this.$parent.getData();
        },
    	back: function () {
    		this.displayFlg = false;
		},
    	showModalProcessing: function() {
			this.processingFlg = true;
		},
		closeModalProcessing: function() {
			this.processingFlg = false;
		},
    },
});