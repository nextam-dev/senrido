Vue.component('roll-call-record', {
    template: (function () {/*
        <div class="modal-mask" id="rollCallRecordModal" v-show="displayFlg">
            <div class="modalWrapperRecord">
	            <!--　ヘッダー　 -->
	            <div class="modalHedder row">
	                <div class="col-1">
	                    <button class="hedderBackButton" @click="close">
	                        <span>
	                            <i class="fas">×</i>
	                        </span>
	                        <br>閉じる
	                    </button>
	                </div>
	                <div class="col-2">
	                    <label class="hedderLabel-position">移動申請</label>
	                </div>
	            </div>
	            <div class="contents mt-5 form-body">
	                <!-- BP -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="ps-path"><b>BP</b></label>
	                    </div>
	                    <div class="col-9">
	                        <label></label>
	                    </div>
	                </div>
	                <!-- 足バンド① -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="ps-path"><b>足バンド①<br>
	                            <span class="small-moji">足についているものを添付。<br>目張りの場合は故柩紙</span></b></label>
	                    </div>
	                    <div class="col-9">
	                        <input type="file" name="test">
	                    </div>
	                </div>
	                <!-- 足バンド② -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="ps-path"><b>足バンド② <br>
	                            <span class="small-moji">ジップロックに入れたものを添付。<br>※火葬事案のみ</span></b></label>
	                    </div>
	                    <div class="col-9">
	                        <input type="file" name="test">
	                    </div>
	                </div>
	                <!-- 移動先 -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="recognition-path"><b>移動先</b></label><br>
	                    </div>
	                    <div class="col-9">
	                        <input type="text" id="other-input" class="form-control">
	                    </div>
	                </div>	
	                <!-- 搬送者 -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="recognition-path"><b>搬送者</b></label><br>
	                    </div>
	                    <div class="col-9">
	                        <input type="text" id="other-input" class="form-control">
	                    </div>
	                </div>
	                <!-- 立ち合い -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="recognition-path"><b>立ち合い</b></label><br>
	                    </div>
	                    <div class="col-9">
	                        <input type="radio">あり　
	                        <input type="radio">なし
	                    </div>
	                </div>
	                <!-- 面会 -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="recognition-path"><b>面会</b></label><br>
	                    </div>
	                    <div class="col-9">
	                        <input type="radio">あり　
	                        <input type="radio">なし
	                    </div>
	                </div>	
	                <!-- 確認者 -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="storage-division"><b>確認者</b></label>
	                    </div>
	                    <div class="col-9">
	                        <label>ダブルチェックが「朝やることの⑭移動メールの確認者」になりました。<br>フォーム送信後に確認者に電話をしてチェックを受けてから出発してください。<br>確認者の打ち込みは不要です。</label>
	                    </div>
	                </div>
	                <!-- 送信者 -->
	                <div class="form-group row">
	                    <div class="col-3">
	                        <label for="recognition-path"><b>送信者</b></label><br>
	                    </div>
	                    <div class="col-9">
	                        <input type="text" id="other-input" class="form-control">
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
    	getData: function() {
			var self = this;
			self.showModalProcessing();
		},
    	showModalProcessing: function() {
			this.processingFlg = true;
		},
		closeModalProcessing: function() {
			this.processingFlg = false;
		},
    },
});