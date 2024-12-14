Vue.component('dazzling-things-modal', {
    template: (function () {/*
        <div class="modal-mask" id="dazzlingThingsModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">眩しさを感じる物事</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
	            	<div class="row">
						<div class="col-3 item-title">眩しさを感じる物事</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in glareSourcesItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="glareInfo.glareSources">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
						<div class="col-9 modal-item-value">
                        	<label class="ef"><input type="text" style="widht: 100%;" v-model="glareInfo.glareSourcesOther"/></label>
                        </div>
					</div>
					<div class="row">
	                    <div class="col-12">
		                    <div class="row">
		                        <div class="col-4 item-title">強い光を感じたとき目に痛みは？</div>
		                        <div class="col-8 modal-item-value">
					                <div class="row">
					                    <div class="col-3">
					                        <label class="input-label"><input type="radio" name="sakuseiSiji" v-model="glareInfo.eyePainStrongLight" value="true"><span class="spaceLeft">ある</span></label>
					                    </div>
					                    <div class="col-3">
					                        <label class="input-label"><input type="radio" name="sakuseiSiji" v-model="glareInfo.eyePainStrongLight" value="false"><span class="spaceLeft">なし</span></label>
					                    </div>
					                </div>
		                        </div>
		                    </div>
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
			glareInfo :{
				// お客様ID
				id: null,
				// 来店日
				visitDate: null,
				// 眩しさを感じる物事
				glareSources : [],
				// 眩しさを感じる物事その他
				glareSourcesOther: null,
				// 強い光を感じたとき目に痛み
				eyePainStrongLight: null,
			},
			// 眩しさを感じる物事リスト
            glareSourcesItems:[],
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.glareInfo.id = item.id;
			this.glareInfo.visitDate = item.visitDate;
			this.glareSourcesItems = item.glareSourcesItems;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					glareInfo: self.glareInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertDazzlingThings'), postItem)
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