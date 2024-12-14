Vue.component('wearing-situation-modal', {
    template: (function () {/*
        <div class="modal-mask" id="wearingSituationModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">メガネ・CLの装用状況</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
	            	<div class="row">
						<div class="col-3 item-title">現状</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in useGlassesCurrentItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="usageStatusInfo.currentStatusCd">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
					</div>
					<div class="row">
						<div class="col-3 item-title">CL併用</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in useGlassesWithClItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="usageStatusInfo.combinedUseClCd">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
					</div>
					<div class="row">
						<div class="col-3 item-title">メガネ用途</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in useGlassesPurposeItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="usageStatusInfo.glassesPurpose">
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
			usageStatusInfo :{
				// お客様ID
				id: null,
				// 来店日
				visitDate: null,
				// メガネ・CL の装用状況-現状
				currentStatusCd : [],
				// メガネ・CL の装用状況-CL併用
				combinedUseClCd : [],
				// メガネ用途
				glassesPurpose : [],
			},
			// メガネの装用－現状
            useGlassesCurrentItems:[],
            // メガネの装用－CL装用
            useGlassesWithClItems:[],
            // メガネの装用－用途
            useGlassesPurposeItems:[],
			
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.usageStatusInfo.id = item.id;
			this.usageStatusInfo.visitDate = item.visitDate;
			this.useGlassesCurrentItems = item.useGlassesCurrentItems;
			this.useGlassesWithClItems = item.useGlassesWithClItems;
			this.useGlassesPurposeItems = item.useGlassesPurposeItems;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					usageStatusInfo: self.usageStatusInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertWearingSituation'), postItem)
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