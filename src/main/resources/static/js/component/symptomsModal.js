Vue.component('symptoms-modal', {
    template: (function () {/*
        <div class="modal-mask" id="symptomsModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">眼・身体の症状</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
	                <div class="row">
						<div class="col-3 item-title">眼</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in eyeSymptomsItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="symptomsInfo.eyeSymptoms">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
						<div class="col-9 modal-item-value">
                        	<label class="ef"><input type="text" style="widht: 100%;" v-model="symptomsInfo.eyeSymptomsOther"/></label>
                        </div>
					</div>
					<div class="row">
						<div class="col-3 item-title">身体</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in bodySymptomsItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="symptomsInfo.bodySymptoms">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
						<div class="col-9 modal-item-value">
                        	<label class="ef"><input type="text" style="widht: 100%;" v-model="symptomsInfo.bodySymptomsOther"/></label>
                        </div>
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
			symptomsInfo :{
				// お客様ID
				id: null,
				// 来店日
				visitDate: null,
				// 眼の症状
				eyeSymptoms : [],
				// 眼の症状その他
				eyeSymptomsOther: null,
				// 身体の症状
				bodySymptoms : [],
				// 身体の症状その他
				bodySymptomsOther: null,
			},
			 // 眼の症状リスト
            eyeSymptomsItems:[],
            // 身体の症状リスト
            bodySymptomsItems:[],
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.symptomsInfo.id = item.id;
			this.symptomsInfo.visitDate = item.visitDate;
			this.eyeSymptomsItems = item.eyeSymptomsItems;
			this.bodySymptomsItems = item.bodySymptomsItems;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					symptomsInfo: self.symptomsInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertSymptoms'), postItem)
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