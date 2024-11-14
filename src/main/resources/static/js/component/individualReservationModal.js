Vue.component('individual-reservation-modal', {
    template: (function () {/*
        <div class="modal-mask" id="individualReservationModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">予約</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
	            	<div class="row">
	            		<div class="col-12">
	                    	<select class="individualSelect" style="width: 300px;">
	                    		<option></option>
	                    		<option>山田太郎</option>
							</select>
	                	</div>
	            	</div>
	            	<div class="row">
	            		<div class="col-10" style="margin-top: 30px; font-size: 20px;">
	                    	<label class="modal-hedder-title">測定時間</label>
	                	</div>
	                	<div class="col-6" style="font-size: 30px;">
	                    	<label class="input-label"><input type="checkbox"><span class="spaceLeft">1時間</span></label>
	                	</div>
	                	<div class="col-6" style="font-size: 30px;">
	                    	<label class="input-label"><input type="checkbox"><span class="spaceLeft">30分</span></label>
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