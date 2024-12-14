Vue.component('usage-status-modal', {
    template: (function () {/*
        <div class="modal-mask" id="usageStatusModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">眼の使用状況</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
	            	<div class="row">
                        <div class="col-3 item-title">携帯・スマホの使用時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.useTimeMobilePhone"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                        <div class="col-2 item-title">画面との距離</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.distanceMobilePhone"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    </div>
                    <div class="row">
						<div class="col-3 item-title">PC環境</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in computerTypeList" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="eyeUsageStatusInfo.computerType">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
						<div class="col-9 modal-item-value">
                        	<label class="ef"><input type="text" style="widht: 100%;" v-model="eyeUsageStatusInfo.computerTypeOther"/></label>
                        </div>
					</div>
					<div class="row">
                        <div class="col-3 item-title">タブレットの使用時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.useTimeTablet"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                        <div class="col-3 item-title">パソコンの使用時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.useTimePC"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                    </div>
                    <div class="row">
                    	<div class="col-6"></div>
                        <div class="col-3 item-title">画面との距離</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.monitorDistance"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">読書の時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.readingTime"/>
                            </label>
                        </div>
                        <template v-for="(item, index) in readingHabitsItems" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="radio" :value="item.code" v-model="eyeUsageStatusInfo.readingHabits">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
                        <div class="col-1 item-title">
                        	<label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.numberOfBooks"/>
                            </label>冊くらい
                        </div>
                    </div>
                    <div class="row">
                    	<div class="col-6"></div>
                        <div class="col-3 item-title">本との距離</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.distanceBook"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    	<div class="col-6"></div>
                        <div class="col-3 item-title">字を書く時の距離</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.distanceWriting"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    </div>
					<div class="row">
                        <div class="col-3 item-title">ゲームの時間・環境</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.gameTime"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">機種:</div>
                        <div class="col-1 item-title">スマホ</div>
                    </div>
	                <div class="row">
						<template v-for="(item, index) in gamingNameList" :key="index">
							<div class="col-4 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="eyeUsageStatusInfo.gaming">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
						<div class="col-9 modal-item-value">
                        	<label class="ef"><input type="text" style="widht: 100%;" v-model="eyeUsageStatusInfo.gamingOther"/></label>
                        </div>
					</div>
                    <div class="row">
                        <div class="col-3 item-title">距離： テレビで</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.distanceTVGame"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">m ・ 手元で</div>
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.distanceGame"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">テレビの時間・距離/大きさ</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.tvTime"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-1 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.distanceTV"/>
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-1 item-title">m/</div>
                        <div class="col-1 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="eyeUsageStatusInfo.tvSize"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">インチ</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">車の運転</div>
                        <div class="col-1 item-title">（毎日</div>
                        <div class="row">
							<template v-for="(item, index) in drivingItems" :key="index">
								<div class="col-4 modal-item-value">
									<label class="input-label">
										<input type="checkbox" :value="item.code" v-model="eyeUsageStatusInfo.driving">
										<span class="spaceLeft">{{ item.name }}</span>
									</label>
								</div>
							</template>
							<div class="col-9 modal-item-value">
                        		<label class="ef"><input type="text" style="widht: 100%;" v-model="eyeUsageStatusInfo.drivingCount"/>回くらい</label>
                        	</div>
						</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">免許の種類</div>
                        <div class="row">
							<template v-for="(item, index) in licenseTypeList" :key="index">
								<div class="col-4 modal-item-value">
									<label class="input-label">
										<input type="checkbox" :value="item.code" v-model="eyeUsageStatusInfo.licenseType">
										<span class="spaceLeft">{{ item.name }}</span>
									</label>
								</div>
							</template>
						</div>
                    </div>
                    <div class="row">
                        <div class="col-1 item-title">次回免許更新/</div>
                        <div class="col-1 modal-item-value">
                            <label class="ef">
                                <input type="date" v-model="eyeUsageStatusInfo.nextLicenseRenewalDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">インチ</div>
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
	                            <button class="modal-regist">登録</button>
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
			eyeUsageStatusInfo :{
				// お客様ID
				id: null,
				// 来店日
				visitDate: null,
				// 
				useTimeMobilePhone: null,
				// 
				distanceMobilePhone: null,
				// 
				computerType: [],
				// 
				computerTypeOther: null,
				// 
				useTimeTablet: null,
				// 
				useTimePC: null,
				// 
				monitorDistance: null,
				// 
				readingTime: null,
				// 
				readingHabits: [],
				// 
				numberOfBooks: null,
				// 
				distanceBook: null,
				// 
				distanceWriting: null,
				// 
				gameTime: null,
				// 
				gaming: [],
				// 
				gamingOther: null,
				// 
				distanceTVGame: null,
				// 
				distanceGame: null,
				// 
				tvTime: null,
				// 
				distanceTV: null,
				// 
				tvSize: null,
				// 
				driving: [],
				// 
				drivingCount: null,
				// 
				licenseType: [],
				// 
				nextLicenseRenewalDate: null,
			},
			// リスト
			computerTypeList:[],
			// リスト
			readingHabitsItems:[],
			// リスト
			gamingNameList:[],
			// リスト
			drivingItems:[],
			// リスト
			licenseTypeList:[],
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.eyeUsageStatusInfo.id = item.id;
			this.eyeUsageStatusInfo.visitDate = item.visitDate;
			this.computerTypeList = item.computerTypeList;
			this.readingHabitsItems = item.readingHabitsItems;
			this.gamingNameList = item.gamingNameList;
			this.drivingItems = item.drivingItems;
			this.licenseTypeList = item.licenseTypeList;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					eyeUsageStatusInfo: self.eyeUsageStatusInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertUsageStatus'), postItem)
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