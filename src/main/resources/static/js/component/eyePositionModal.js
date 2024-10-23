Vue.component('eye-position-modal', {
    template: (function () {/*
        <div class="modal-mask" id="eyePositionModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">眼位</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
					<div class="row">
						<div class="col-12">
							<div class="row">
								<div class="col-6">
							     	<button class="eyePositionBt" :style="{ backgroundColor: isFarSelected ? 'red' : 'gray' }" @click="selectFar">
							       		 遠
							      	</button>
							    </div>
							    <div class="col-6">
							      	<button class="eyePositionBt" :style="{ backgroundColor: isNearSelected ? 'blue' : 'gray' }" @click="selectNear">
							        	近
							      	</button>
							    </div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<div class="margin">
								<div class="row">
									<div class="col-4" v-if="isFarSelected"><label class="perspectiveIcon" style="background-color: red;">遠</label></div>
									<div class="col-4"  v-if="!isFarSelected"><label class="perspectiveIcon" style="background-color: blue;">近</label></div>
									<div class="col-4"><label>他覚：</label></div>
									<div class="col-4"><label>自覚：</label></div>
								</div>
								<div><img src="/senrido/img/eye-image1.png"></div>
							</div>
							<div style="text-align: left;" class="margin">
								<label class="diamondTitle" style="font-size: 20px;">◆水平斜位量◆</label>
								<label class="horizontalSubTitle">in=exo　out=eso<br>exo=マイナス表記</label>
							</div>
							<div>
								<label>期待値:1exo±1</label>
								<br>
								<select class="horizontalSelect">
									<option></option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
								<label>△</label>
							</div>
							<div class="row margin">
								<div class="col-12 totalValueEyes">
									<label>開散力(IN)<br><span>両眼合計値で記録</span></label>
								</div>
							</div>
							<div class="row">
								<div class="col-4">
									<label>ボヤケ:9±2</label>
									<br>
									<select class="totalValueEyesSelect">
										<option></option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
								<div class="col-4">
									<label>分離:19±4</label>
									<br>
									<select class="totalValueEyesSelect">
										<option></option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
								<div class="col-4">
									<label>回復:10±2</label>
									<br>
									<select class="totalValueEyesSelect">
										<option></option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
							</div>
							<div class="row margin">
								<div class="col-12 totalValueEyes">
									<label>輻輳力 (OUT)<br><span>両眼合計値で記録</span></label>
								</div>
							</div>
							<div class="row">
								<div class="col-4">
									<label>ボヤケ</label>
									<br>
									<select class="totalValueEyesSelect">
										<option></option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
								<div class="col-4">
									<label>分離:7±2</label>
									<br>
									<select class="totalValueEyesSelect">
										<option></option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
								<div class="col-4">
									<label>回復:4±1</label>
									<br>
									<select class="totalValueEyesSelect">
										<option></option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
							</div>
							<div class="row margin">
								<div class="col-12">
									<div style="text-align: left;" >
										<label class="diamondTitle">◆上下寄せ◆</label>
									</div>
									<div class="row">
										<div class="col-4"></div>
										<div class="col-4">
											<label>分離</label>
										</div>
										<div class="col-4">
											<label>回復</label>
										</div>
									</div>
									<div class="row topBottomBorder">
										<div class="col-4">
											<label class="topBottomTitle">UP</label>
										</div>
										<div class="col-4">
											<select class="topBottomSelect">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
										<div class="col-4">
											<select class="topBottomSelect">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-4">
											<label class="topBottomTitle">DOWN</label>
										</div>
										<div class="col-4">
											<select class="topBottomSelect">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
										<div class="col-4">
											<select class="topBottomSelect">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row margin">
								<div class="col-12">
									<div style="text-align: left;" >
										<label class="diamondTitle">◆上下斜位量◆</label>
									</div>
								</div>
								<div class="col-12">
									<div style="margin-top: 10px;">
										<select class="topBottomObliqueSelect">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										<label>△</label>
									</div>
								</div>
								<div class="col-3"></div>
								<div class="col-1">
									<label>R:</label>
								</div>
								<div class="col-2">
									<label class="input-label"><input type="radio"><span class="spaceLeft">UP</span></label>
								</div>
								<div class="col-2">
									<label class="input-label"><input type="radio"><span class="spaceLeft">DOWN</span></label>
								</div>
								<div class="col-4"></div>
							</div>
							<div class="row margin">
								<div class="col-12">
									<div style="text-align: left;" >
										<label class="diamondTitle">◆利目◆</label>
									</div>
									<div class="row"  v-if="isFarSelected">
										<div class="col-4">
											<label class="perspectiveIcon" style="background-color: red;">遠</label>
										</div>
										<div class="col-2">
											<label class="input-label"><input type="radio"><span class="spaceLeft">R</span></label>
										</div>
										<div class="col-2">
											<label class="input-label"><input type="radio"><span class="spaceLeft">L</span></label>
										</div>
										<div class="col-4"></div>
									</div>
									<div class="row"  v-if="!isFarSelected">
										<div class="col-4">
											<label class="perspectiveIcon" style="background-color: blue;">近</label>
										</div>
										<div class="col-2">
											<label class="input-label"><input type="radio"><span class="spaceLeft">R</span></label>
										</div>
										<div class="col-2">
											<label class="input-label"><input type="radio"><span class="spaceLeft">L</span></label>
										</div>
										<div class="col-4"></div>
									</div>
								</div>
							</div>
							<div class="row margin">
								<div class="col-12">
									<div style="text-align: left;">
										<label class="diamondTitle">◆NPC◆</label>
									</div>
									<div class="row">
										<div class="col-4">
											<label>ボヤケ</label>
											<br>
											<select class="npcSelect">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
										<div class="col-4">
											<label>分離2~8</label>
											<br>
											<select class="npcSelect">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
										<div class="col-4">
											<label>回復</label>
											<br>
											<select class="npcSelect">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
									</div>
									<div class="row margin">
										<div class="col-2 npcItems">
											<label>ボヤケ</label>
											<label>分離</label>
											<label>回復</label>
										</div>
										<div class="col-10">
											<img src="/senrido/img/eye-image3.png" style="width: 400px;">
										</div>
									</div>
									<div style="text-align: left;">
										<div><label>メモ</label></div>
										<div><textarea class="memoArea"></textarea></div>
									</div>
								</div>
							</div>
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
			isFarSelected: true,   // 初期状態で「遠」が選択されている状態
            isNearSelected: false, // 初期状態で「近」は選択されていない状態
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
        selectFar: function(index) {
            this.isFarSelected = true;
            this.isNearSelected = false;
          },
        selectNear: function(index) {
            this.isFarSelected = false;
            this.isNearSelected = true;
        },
    },
});