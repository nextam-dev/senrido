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
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                        <div class="col-2 item-title">画面との距離</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    </div>
                    <div class="row">
						<div class="col-3 item-title">PC環境</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in visitingHospitalItems" :key="index">
							<div class="col-4 modal-item-value" v-if="['00001'].includes(item.code)">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="visitingHospitalInfo.medicalHistory">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
					</div>
					<div class="row">
                        <div class="col-3 item-title">タブレットの使用時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                        <div class="col-3 item-title">パソコンの使用時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                    </div>
                    <div class="row">
                    	<div class="col-6"></div>
                        <div class="col-3 item-title">画面との距離</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">読書の時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                        <div class="col-3 item-title">パソコンの使用時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">冊くらい</div>
                    </div>
                    <div class="row">
                    	<div class="col-6"></div>
                        <div class="col-3 item-title">本との距離</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    	<div class="col-6"></div>
                        <div class="col-3 item-title">字を書く時の距離</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    </div>
					<div class="row">
                        <div class="col-3 item-title">ゲームの時間・環境</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">機種:</div>
                        <div class="col-1 item-title">スマホ</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">距離： テレビで</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">m ・ 手元で</div>
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">cm</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">テレビの時間・距離/大きさ</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-2 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">時間</div>
                        <div class="col-1 item-title">約</div>
                        <div class="col-1 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-1 item-title">m/</div>
                        <div class="col-1 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">インチ</div>
                    </div>
                    <div class="row">
                        <div class="col-3 item-title">車の運転</div>
                        <div class="col-1 item-title">（毎日</div>
                        <div class="row">
							<template v-for="(item, index) in visitingHospitalItems" :key="index">
								<div class="col-4 modal-item-value" v-if="['00001'].includes(item.code)">
									<label class="input-label">
										<input type="checkbox" :value="item.code" v-model="visitingHospitalInfo.medicalHistory">
										<span class="spaceLeft">{{ item.name }}</span>
									</label>
								</div>
							</template>
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
			visitingHospitalInfo :{},
			// リスト
			visitingHospitalItems:[],
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function () {
			this.displayFlg = true;
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