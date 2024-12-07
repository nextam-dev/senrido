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
						<template v-for="(item, index) in visitingHospitalItems" :key="index">
							<div class="col-4 modal-item-value" v-if="['00001', '00002', '00003', '00004', '00005'].includes(item.code)">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="visitingHospitalInfo.medicalHistory">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
					</div>
					<div class="row">
						<div class="col-3 item-title">身体</div>
					</div>
	                <div class="row">
						<template v-for="(item, index) in visitingHospitalItems" :key="index">
							<div class="col-4 modal-item-value" v-if="['00001', '00002', '00003', '00004', '00005'].includes(item.code)">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="visitingHospitalInfo.medicalHistory">
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