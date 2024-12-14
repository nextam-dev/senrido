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
                                <input type="text" v-model="upsertCustomerInfo.customerCd" placeholder="Zipシステムで採番されたIDを入力してください。"/>
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">お名前</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef">
                                <input type="text"　v-model="upsertCustomerInfo.name"/>
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">お名前（カタカナ）<label class="label-required">必須</label></div>
                        <div class="col-12 modal-item-value">
                            <label class="ef">
                                <input type="text" v-model="upsertCustomerInfo.nameKana" />
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">性別</div>
                        <div class="col-12 modal-item-value">
                           <div v-for="item in sexList" >
	                            <div class="row item-margin" v-if="item.name != 'その他'">
	                                <div class="col-12">
	                                    <label class="input-label"><input type="radio" name="sex" v-bind:value="item.code" v-model="upsertCustomerInfo.sex"><span class="spaceLeft">{{item.name}}</span></label>
	                                </div>
	                            </div>
	                            <div class="row item-margin" v-else>
	                                <div class="col-4">
	                                    <label class="input-label"><input type="radio" name="sex" v-bind:value="item.code" v-model="upsertCustomerInfo.sex"><span class="spaceLeft">{{item.name}}</span></label>
	                                </div>
	                                <div class="col-8">
	                                    <label class="ef"><input type="text" v-model="upsertCustomerInfo.sexOther" /></label>
	                                </div>
	                            </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">生年月日</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="date" v-model="upsertCustomerInfo.birthday"/></label>
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
                            <label class="ef"><input type="date" v-model="upsertCustomerInfo.nextVisitDate"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">郵便番号</div>
                        <div class="col-12 modal-item-value">
                            <div class="row">
                                <div class="col-4">
                                    <label class="ef"><input type="text" v-model="upsertCustomerInfo.zipcode" /></label>
                                </div>
                                <div class="col-8">
                                    <button value="郵便番号検索">郵便番号検索</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">ご住所</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text" v-model="upsertCustomerInfo.address"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">メールアドレス</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="mail" v-model="upsertCustomerInfo.mail" placeholder="" /></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">電話番号<label class="label-required">必須</label></div>
                        <div class="col-4 item-title"><label class="input-label"><input type="radio" name="mainTel" v-model="upsertCustomerInfo.mainContactType"　value="00001"><span class="spaceLeft">主番号</span></label></div>
                        <div class="col-12 item-value">
                           <label class="ef"><input type="text" v-model="upsertCustomerInfo.telephone" placeholder="ー(ハイフン)を入れてご記入ください。" /></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">携帯電話番号</div>
                        <div class="col-4 item-title"><label class="input-label"><input type="radio" name="mainTel" v-model="upsertCustomerInfo.mainContactType" value="00002"><span class="spaceLeft">主番号</span></label></div>
                        <div class="col-12 item-value">
                            <label class="ef"><input type="text" v-model="upsertCustomerInfo.mobilePhone" placeholder="ー(ハイフン)を入れてご記入ください。" /></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 item-title">勤務先電話番号</div>
                        <div class="col-4 item-title"><label class="input-label"><input type="radio" name="mainTel" v-model="upsertCustomerInfo.mainContactType" value="00003"><span class="spaceLeft">主番号</span></label></div>
                        <div class="col-12 item-value">
                           <label class="ef"><input type="text" v-model="upsertCustomerInfo.workPhone" placeholder="ー(ハイフン)を入れてご記入ください。" /></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 item-title">ご紹介者</div>
                        <div class="col-12 modal-item-value">
                            <label class="ef"><input type="text" v-model="upsertCustomerInfo.referrer"/></label>
                        </div>
                    </div>
	            </div><!-- /modal-content -->
                <div class="row" style="margin-top: 10px;">
	                <div class="col-12">
	                    <div class="row">
	                        <div class="col-12 botton-area" style="margin-top: 10px; min-height:40px;">
	                            <button class="modal-regist" v-on:click="update">登録</button>
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
			// お客様情報
			upsertCustomerInfo: {
				// お客様ID
            	id: null,
            	// 顧客番号
            	customerCd: null,
            	// 来店日
            	nextVisitDate: null,
            	// 客様名
            	name: null,
            	// お客様名カナ
            	nameKana: null,
            	// 生年月日
            	birthday: null,
            	// メールアドレス
            	mail: null,
            	// 性別
            	sex: null,
            	// 性別その他
            	sexOther: null,
            	// 郵便番号
            	zipcode: null,
            	// 
            	mainContactType: null,
            	// 住所
            	address: null,
            	// 電話番号
            	telephone: null,
            	// 紹介者
            	referrer: null,
			},
			// プルダウン情報
            sexList: [],
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.upsertCustomerInfo = JSON.parse(JSON.stringify(item.customerInfo));
			this.sexList = item.sexList;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					customerInfo: self.upsertCustomerInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertCustomer'), postItem)
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