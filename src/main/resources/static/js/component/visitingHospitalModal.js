Vue.component('visiting-hospital-modal', {
    template: (function () {/*
        <div class="modal-mask" id="visitingHospitalModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">眼科への通院</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
	                <div class="row">
	                	<div class="col-2"></div>
	                    <div class="col-3">
	                        <label class="input-label"><input type="radio" name="visitingHospital" value="0"><span class="spaceLeft">あり</span></label>
	                    </div>
	                    <div class="col-2"></div>
	                    <div class="col-3">
	                        <label class="input-label"><input type="radio" name="visitingHospital" value="0"><span class="spaceLeft">なし</span></label>
	                    </div>
	                    <div class="col-2"></div>
	                </div>
	                <!-- 送信者 -->
                    <div class="row">
                        <div class="col-2 modal-item-title">受信日</div>
                        <div class="col-10 item-value">
                            <label class="ef">
                                <input type="date" />
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-2 modal-item-title">眼科名</div>
                        <div class="col-10 item-value">
                            <label class="ef">
                                <input type="text" />
                            </label>
                        </div>
                    </div>
		            <div class="row">
	                    <div class="col-12">
		                    <div class="row">
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">近視</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">遠視</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">乱視</span></label>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">不同視</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">仮性近視</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">斜視/ 内</span></label>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">斜視/ 外</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">白内障</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">緑内障</span></label>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">黄斑変性症</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">網膜色素変性症</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">翼状片</span></label>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">飛蚊症</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">ドライアイ</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">色覚異常</span></label>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">斜視</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">レーシック</span></label>
		                        </div>
		                        <div class="col-4 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">ICL/IOL</span></label>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col-6 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">近視抑制（アトロピン）</span></label>
		                        </div>
		                        <div class="col-6 modal-item-value">
		                            <label class="input-label"><input type="checkbox"><span class="spaceLeft">近視抑制（オルソケラトロジー）</span></label>
		                        </div>
		                    </div>
		                    <div class="row">
                                <div class="col-3 modal-item-value">
                                    <label class="input-label"><input type="checkbox"><span class="spaceLeft">その他:</span></label>
                                </div>
                                <div class="col-9 modal-item-value">
                                    <label class="ef"><input type="text" style="widht: 100%;" /></label>
                                </div>
                            </div>
		                </div>
	                </div>
	                <div class="row">
	                    <div class="col-12">
		                    <div class="row">
		                        <div class="col-4 item-title">メガネの作成指示</div>
		                        <div class="col-8 modal-item-value">
					                <div class="row">
					                    <div class="col-3">
					                        <label class="input-label"><input type="radio" name="sakuseiSiji" value="0"><span class="spaceLeft">あり</span></label>
					                    </div>
					                    <div class="col-3">
					                        <label class="input-label"><input type="radio" name="sakuseiSiji" value="0"><span class="spaceLeft">なし</span></label>
					                    </div>
					                </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
	                <div class="row">
	                    <div class="col-12">
		                    <div class="row">
		                        <div class="col-4 item-title">処方箋</div>
		                        <div class="col-8 modal-item-value">
					                <div class="row">
					                    <div class="col-3">
					                        <label class="input-label"><input type="radio" name="sakuseiSiji" value="0"><span class="spaceLeft">あり</span></label>
					                    </div>
					                    <div class="col-3">
					                        <label class="input-label"><input type="radio" name="sakuseiSiji" value="0"><span class="spaceLeft">なし</span></label>
					                    </div>
					                </div>
		                        </div>
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