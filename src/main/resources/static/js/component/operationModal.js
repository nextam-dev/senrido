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
                        <div class="col-3 item-title">手術時期：</div>
                        <div class="col-3 modal-item-value">
                             <label class="ef">
                                <input type="date" v-model="surgeryInfo.surgeryDate"/>
                            </label>
                        </div>
                        <div class="col-3 item-title">予定：</div>
                        <div class="col-3 modal-item-value">
                             <label class="ef">
                                <input type="date" v-model="surgeryInfo.surgeryPlannedDate"/>
                            </label>
                        </div>
                    </div>
		             <div class="row">
		              <div class="col-4 item-title">白内障：</div>
		                <template v-for="(item, index) in surgeryTargetItems" :key="index">
							 <div class="col-3 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="surgeryInfo.cataract">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
		             </div>
		             <div class="row">
		              <div class="col-4 item-title">緑内障：</div>
		                <template v-for="(item, index) in surgeryTargetItems" :key="index">
							 <div class="col-3 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="surgeryInfo.glaucoma">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
		             </div>
		             <div class="row">
		              <div class="col-4 item-title">飛蚊症：</div>
		                <template v-for="(item, index) in surgeryTargetItems" :key="index">
							 <div class="col-3 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="surgeryInfo.floaters">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
		             </div>
		             <div class="row">
		              <div class="col-4 item-title">網膜剥離：</div>
		                <template v-for="(item, index) in surgeryTargetItems" :key="index">
							 <div class="col-3 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="surgeryInfo.retinalDetachment">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
		             </div>
		              <div class="row">
		              <div class="col-4 item-title">斜視：</div>
		                <template v-for="(item, index) in surgeryTargetItems" :key="index">
							 <div class="col-3 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="surgeryInfo.strabismus">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
		             </div>
		             <div class="row">
		              <div class="col-4 item-title">硝子体：</div>
		                <template v-for="(item, index) in surgeryTargetItems" :key="index">
							 <div class="col-3 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="surgeryInfo.vitreousBody">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
		             </div>
		              <div class="row">
		              <div class="col-4 item-title">レーシック：</div>
		                <template v-for="(item, index) in surgeryTargetItems" :key="index">
							 <div class="col-3 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="surgeryInfo.lasik">
									<span class="spaceLeft">{{ item.name }}</span>
								</label>
							</div>
						</template>
		             </div>
		             <div class="row">
		              <div class="col-4 item-title">ICL/IOL：</div>
		                <template v-for="(item, index) in surgeryTargetItems" :key="index">
							 <div class="col-3 modal-item-value">
								<label class="input-label">
									<input type="checkbox" :value="item.code" v-model="surgeryInfo.iclIol">
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
			// 目の手術情報
			surgeryInfo: {
				// お客様ID
            	id: null,
            	// 来店日
            	visitDate: null,
				//
				surgeryDate: null,
				//
				surgeryPlannedDate: null,
				//
				cataract: [],
				//
				glaucoma: [],
				//
				floaters: [],
				//
				retinalDetachment: [],
				//
				strabismus: [],
				//
				vitreousBody: [],
				//
				lasik: [],
				//
				iclIol: [],
			},
			// 左右リスト
			surgeryTargetItems:[],
    	}
    },
    computed:{
	},
	watch:{
	},
	methods: {
		open: function (item) {
			this.displayFlg = true;
			this.surgeryInfo.id = item.id;
			this.surgeryInfo.visitDate = item.visitDate;
			this.surgeryTargetItems = item.surgeryTargetItems;
    	},
    	update:function() {
    		var self = this;
    		self.showModalProcessing();
			var postItem = {
					surgeryInfo: self.surgeryInfo,
			};
			axios.post(editUrl('/s007MedicalRecord/upsertOperation'), postItem)
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