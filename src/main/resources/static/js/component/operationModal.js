Vue.component('operation-modal', {
    template: (function () {/*
        <div class="modal-mask" id="operationModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">眼の手術</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
                    <div class="row">
                        <div class="col-2 item-title">手術時期：</div>
                        <div class="col-3 modal-item-value">
                            <select id="era" v-model="surgeryInfo.surgeryWareki" aria-label="和暦年号">
						        <option value="reiwa">令和</option>
						        <option value="heisei">平成</option>
						        <option value="showa">昭和</option>
						        <option value="taisho">大正</option>
						    </select>
                        </div>
                        <div class="col-4 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="surgeryInfo.surgeryYear"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">年</div>
                        <div class="col-4 modal-item-value">
                            <label class="ef">
                                <input type="number" v-model="surgeryInfo.surgeryMonth"/>
                            </label>
                        </div>
                        <div class="col-1 item-title">月</div>
                        <div class="col-2 item-title">予定：</div>
                        <div class="col-3 modal-item-value">
                            <label class="ef">
                                <input type="date"/>
                            </label>
                        </div>
                        <div class="col-2"></div>
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
			// 目の手術情報
			surgeryInfo: {},
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