Vue.component('impaired-vision-modal', {
    template: (function () {/*
        <div class="modal-mask" id="impairedVisionModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">視力の低下を感じたのは</label>
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
                                <input type="number" v-model="visionLossInfo.decreaseEyesight"/>
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
			// 視力の低下情報
			visionLossInfo: {
				// お客様ID
            	id: null,
            	// 来店日
            	visitDate: null,
            	// 視力の低下を感じたのは
            	decreaseEyesight : null,
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
			this.visionLossInfo.id = item.id;
			this.visionLossInfo.visitDate = item.visitDate;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					visionLossInfo: self.visionLossInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertImpairedVision'), postItem)
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