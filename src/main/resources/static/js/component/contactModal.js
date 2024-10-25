Vue.component('contact-modal', {
    template: (function () {/*
        <div class="modal-mask" id="contactModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">お客様情報連絡先</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
                    <div class="row">
                        <div class="col-4 item-title">郵便番号</div>
                        <div class="col-8 modal-item-value">
                            <label class="ef">141-0031</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">ご住所</div>
                        <div class="col-8 modal-item-value">
                            <label class="ef">東京都品川区西五反田1-2-10 CIRCLES五反田5階</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">メールアドレス</div>
                        <div class="col-8 modal-item-value">
                            <label class="ef">test@sample.jp</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">電話番号</div>
                        <div class="col-8 modal-item-value">
                            <label class="ef">01-1111-2222</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">携帯電話番号</div>
                        <div class="col-8 modal-item-value">
                            <label class="ef">090-1111-2222</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">勤務先電話番号</div>
                        <div class="col-8 modal-item-value">
                            <label class="ef">01-9999-9999</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">ご紹介者</div>
                        <div class="col-8 modal-item-value">
                            <label class="ef">札幌次郎</label>
                        </div>
                    </div>
	            </div><!-- /modal-content -->
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