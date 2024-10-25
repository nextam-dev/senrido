Vue.component('customer-edit-modal', {
    template: (function () {/*
        <div class="modal-mask" id="customerEditModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">お客様情報の編集</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
                    <div class="row">
                        <div class="col-12 item-title">顧客番号</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef">
                                <input type="text" placeholder="Zipシステムで採番されたIDを入力してください。"/>
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">お名前</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef">
                                <input type="text"/>
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">お名前（カタカナ）<label class="label-required">必須</label></div>
                        <div class="col-12 modal-item-value">
                            <label class="ef">
                                <input type="text"/>
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">電話番号<label class="label-required">必須</label></div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text" placeholder="ー(ハイフン)を入れてご記入ください。" /></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">性別</div>
                        <div class="col-12 modal-item-value">
                            <div class="row item-margin">
                                <div class="col-12">
                                    <label class="input-label"><input type="radio" name="sex" value="0"><span class="spaceLeft">男性</span></label>
                                </div>
                            </div>
                            <div class="row item-margin">
                                <div class="col-12">
                                    <label class="input-label"><input type="radio" name="sex" value="1"><span class="spaceLeft">女性</span></label>
                                </div>
                            </div>
                            <div class="row item-margin">
                                <div class="col-12">
                                    <label class="input-label"><input type="radio" name="sex" value="2"><span class="spaceLeft">回答しない</span></label>
                                </div>
                            </div>
                            <div class="row item-margin">
                                <div class="col-3">
                                    <label class="input-label"><input type="radio" name="sex" value="9"><span class="spaceLeft">その他</span></label>
                                </div>
                                <div class="col-9">
                                    <label class="ef"><input type="text" /></label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">生年月日</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="date"/></label>
                        </div>
                    </div>
                    <!-- 生年月日から自動計算するか -->
                    <div class="row">
                        <div class="col-12 item-title">年齢<label class="label-required">必須</label></div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">来店日</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="date"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">郵便番号</div>
                        <div class="col-12 modal-item-value">
                            <div class="row">
                                <div class="col-4">
                                    <label class="ef"><input type="text"/></label>
                                </div>
                                <div class="col-8">
                                    <button value="郵便番号検索" >郵便番号検索</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">ご住所</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">メールアドレス</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text" placeholder="" /></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">携帯電話番号</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text" placeholder="ー(ハイフン)を入れてご記入ください。" /></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">勤務先電話番号</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text" placeholder="ー(ハイフン)を入れてご記入ください。" /></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">ご紹介者</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text"/></label>
                        </div>
                    </div>
	            </div><!-- /modal-content -->
                <div class="row" style="margin-top: 10px;">
	                <div class="col-6">
	                    <div class="row">
	                        <div class="col-12 botton-area" style="min-height:40px;">
	                            <button class="modal-delete">削除</button>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-6">
	                    <div class="row">
	                        <div class="col-12 botton-area" style="margin-top: 10px; min-height:40px;">
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