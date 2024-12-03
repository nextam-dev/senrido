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
	                        <label class="input-label"><input type="radio" name="visitingHospital" v-model="visitingHospitalInfo.visitEyeDoctor" value="true"><span class="spaceLeft">あり</span></label>
	                    </div>
	                    <div class="col-2"></div>
	                    <div class="col-3">
	                        <label class="input-label"><input type="radio" name="visitingHospital" v-model="visitingHospitalInfo.visitEyeDoctor" value="false"><span class="spaceLeft">なし</span></label>
	                    </div>
	                    <div class="col-2"></div>
	                </div>
                    <div class="row">
                        <div class="col-2 item-title">受信日</div>
                        <div class="col-3 modal-item-value">
                            <label class="ef">
                                <input type="date" v-model="visitingHospitalInfo.consultationDate"/>
                            </label>
                        </div>
                        <div class="col-2 item-title">眼科名</div>
                        <div class="col-5 modal-item-value">
                            <label class="ef">
                                <input type="text" v-model="visitingHospitalInfo.ophthalmologyName"/>
                            </label>
                        </div>
                    </div>
		            <div class="row">
	                    <div class="col-12">
							<div class="row">
							    <template v-for="(item, index) in visitingHospitalItems" :key="index">
							        <div class="col-4 modal-item-value" v-if="['00001', '00002', '00003', '00004', '00005', '00006', '00007', '00008', '00009', '00010', '00011', '00012', '00013', '00014', '00015', '00016', '00017', '00018'].includes(item.code)">
									    <label class="input-label">
									        <input type="checkbox" :value="item.code" v-model="visitingHospitalInfo.medicalHistory">
									        <span class="spaceLeft">{{ item.name }}</span>
									    </label>
									</div>
							    </template>
							</div>
							<div class="row">
							    <template v-for="(item, index) in visitingHospitalItems" :key="index">
							        <div class="col-6 modal-item-value" v-if="['00019', '00020'].includes(item.code)">
							            <label class="input-label">
							                <input type="checkbox" :value="item.code" v-model="visitingHospitalInfo.medicalHistory">
									        <span class="spaceLeft">{{ item.name }}</span>
							            </label>
							        </div>
							    </template>
							</div>
                            <div class="row">
		                       <template v-for="(item, index) in visitingHospitalItems" :key="index">
								    <template v-if="item.code === '00021'">
								        <div class="col-3 modal-item-value">
								            <label class="input-label">
								                <input type="checkbox" :value="item.code" v-model="visitingHospitalInfo.medicalHistory">
									        	<span class="spaceLeft">{{ item.name }}</span>
								            </label>
								        </div>
								    </template>
								</template>
								<div class="col-9 modal-item-value">
                                    <label class="ef"><input type="text" style="widht: 100%;" v-model="visitingHospitalInfo.medicalHistoryOther"/></label>
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
					                        <label class="input-label"><input type="radio" name="sakuseiSiji" v-model="visitingHospitalInfo.glassesMaking" value="true"><span class="spaceLeft">あり</span></label>
					                    </div>
					                    <div class="col-3">
					                        <label class="input-label"><input type="radio" name="sakuseiSiji" v-model="visitingHospitalInfo.glassesMaking" value="false"><span class="spaceLeft">なし</span></label>
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
					                        <label class="input-label"><input type="radio" name="prescription" v-model="visitingHospitalInfo.prescription" value="true"><span class="spaceLeft">あり</span></label>
					                    </div>
					                    <div class="col-3">
					                        <label class="input-label"><input type="radio" name="prescription" v-model="visitingHospitalInfo.prescription" value="false"><span class="spaceLeft">なし</span></label>
					                    </div>
					                </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
                    <div class="row">
                        <div class="col-12 item-title">眼科医の指示・意見</div>
                        <div class="col-12 modal-item-value">
			                <label class="ef"><textarea placeholder="" rows="2" cols="70" v-model="visitingHospitalInfo.ophthalmologistInstructions"></textarea></label>
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
	                            <button class="modal-regist" @click="update">登録</button>
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
			visitingHospitalInfo: {
			      medicalHistory: [] // ここは配列として初期化
			},
			// 眼科への通院リスト
            visitingHospitalItems:[],
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.id = item.id;
			this.visitDate = item.visitDate;
			this.visitingHospitalItems = item.visitingHospitalItems;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
				id: this.id,
				visitData: this.visitDate,
				visitingHospitalInfo: self.visitingHospitalInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertVisitingHospital'), postItem)
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