Vue.component('glasses-trouble-modal', {
    template: (function () {/*
        <div class="modal-mask" id="glassesTroubleModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">メガネのトラブル</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
	                <div class="row">
						<div class="col-3 item-title">メガネ</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in glassesIssuesItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="troubleInfo.glassesIssues">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
					</div>
					<div class="row">
						<div class="col-3 item-title">フレーム</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in frameIssuesItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="troubleInfo.frameIssues">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
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
			// 
			troubleInfo :{
				// お客様ID
				id: null,
				// 来店日
				visitDate: null,
				// メガネトラブル
				glassesIssues : [],
				// フレームトラブル
				frameIssues : [],
			},
			// メガネトラブルリスト
            glassesIssuesItems:[],
            // フレームトラブルリスト
            frameIssuesItems:[],
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.troubleInfo.id = item.id;
			this.troubleInfo.visitDate = item.visitDate;
			this.glassesIssuesItems = item.glassesIssuesItems;
			this.frameIssuesItems = item.frameIssuesItems;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					troubleInfo: self.troubleInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertGlassesTrouble'), postItem)
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