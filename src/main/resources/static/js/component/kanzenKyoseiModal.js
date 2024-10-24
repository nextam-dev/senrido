Vue.component('kanzen-kyosei-modal', {
    template: (function () {/*
        <div class="modal-mask" id="kanzenKyoseiModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">完全矯正</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
					<div class="row">
						<div class="col-12 item-title">完全矯正</div>
						<div class="col-12">
							<div class="allrow">
								<!-- R・L -->
								<div class="black-border" style="height: 147px; flex-direction: column;">
									<div class="border-bottom" style="height: 27px; width: 60px; border: 1px solid;">
										<label></label>
									</div>
									<div class="leftright border-bottom" style="height: 60px; width: 60px; border: 1px solid;">
										<label>R</label>
									</div>
									<div class="leftright" style="height: 60px; width: 60px; border: 1px solid;">
										<label>L</label>
									</div>
								</div>
								<!-- V列 -->
								<div>
									<div class="col-border" style="width: 150px; border: 1px solid;">
										<label class="lavel-left">V</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div style="width: 75px;">
											<input type="text" class="inputsize1" style="width: 75px; height: 120px; border: 1px solid;">
										</div>
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<!-- CV列 -->
								<div>
									<div class="col-border" style="width: 150px; border: 1px solid;">
										<label class="lavel-left">CV</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div style="width: 75px;">
											<input type="text" class="inputsize1" style="width: 75px; height: 120px; border: 1px solid;">
										</div>
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<!-- S列 -->
								<div>
									<div class="row-height">
										<div class="col-border" style="width: 100px; border: 1px solid;">
											<label class="lavel-left">S</label>
										</div>
										<div class="double-row" style="height: 120px; width: 100px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<div>
									<div class="row-height">
										<div class="col-border" style="width: 100px; border: 1px solid;">
											<label class="lavel-left">C</label>
										</div>
											<div class="double-row" style="height: 120px; width: 100px;">
												<input type="text" class="inputsize1">
												<input type="text" class="inputsize1">
											</div>
									</div>
								</div>
							</div>
							<div class="allrow" style="margin-top: 7px;">	
								<!-- R・L -->
								<div class="black-border" style="height: 147px; flex-direction: column;">
									<div class="border-bottom" style="height: 27px; width: 60px; border: 1px solid;">
										<label></label>
									</div>
									<div class="leftright border-bottom" style="height: 60px; width: 60px; border: 1px solid;">
										<label>R</label>
									</div>
									<div class="leftright" style="height: 60px; width: 60px; border: 1px solid;">
										<label>L</label>
									</div>
								</div>	
								<!-- AX列 -->
								<div>
									<div class="col-border" style="width: 100px; border: 1px solid;">
										<label class="lavel-left">AX</label>
									</div>
									<div class="double-row" style="height: 120px;">
										<input type="text" class="inputsize1">
										<input type="text" class="inputsize1">
									</div>
								</div>									
								<!-- P/BASE 1列-->
								<div>
									<div class="col-border" style="width: 150px; border: 1px solid;">
										<label class="lavel-left">P/BASE 1</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<!-- P/BASE 2列-->
								<div>
									<div class="col-border" style="width: 150px; border: 1px solid;">
										<label class="lavel-left">P/BASE 2</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<!-- ADD列 -->
								<div>
									<div class="col-border" style="width: 100px; border: 1px solid;">
										<label class="lavel-left">ADD</label>
									</div>
									<div style="height: 120px; width: 100px;">
										<input type="text" class="inputsize1" style="width: 100%; border: 1px solid; height: 120px;">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row" style="margin-top: 10px;">
						<div class="col-12 item-title">完全矯正（CL装用）</div>
						<div class="col-12">
							<div class="allrow">
								<!-- R・L -->
								<div class="black-border" style="height: 147px; flex-direction: column;">
									<div class="border-bottom" style="height: 27px; width: 60px; border: 1px solid;">
										<label></label>
									</div>
									<div class="leftright border-bottom" style="height: 60px; width: 60px; border: 1px solid;">
										<label>R</label>
									</div>
									<div class="leftright" style="height: 60px; width: 60px; border: 1px solid;">
										<label>L</label>
									</div>
								</div>
								<!-- V列 -->
								<div>
									<div class="col-border" style="width: 150px; border: 1px solid;">
										<label class="lavel-left">V</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div style="width: 75px;">
											<input type="text" class="inputsize1" style="width: 75px; height: 120px; border: 1px solid;">
										</div>
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<!-- CV列 -->
								<div>
									<div class="col-border" style="width: 150px; border: 1px solid;">
										<label class="lavel-left">CV</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div style="width: 75px;">
											<input type="text" style="width: 75px; height: 120px; border: 1px solid;">
										</div>
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<!-- S列 -->
								<div>
									<div class="row-height">
										<div class="col-border" style="width: 100px; border: 1px solid;">
											<label class="lavel-left">S</label>
										</div>
										<div class="double-row" style="height: 120px; width: 100px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<div>
									<div class="row-height">
										<div class="col-border" style="width: 100px; border: 1px solid;">
											<label class="lavel-left">C</label>
										</div>
											<div class="double-row" style="height: 120px; width: 100px;">
												<input type="text" class="inputsize1">
												<input type="text" class="inputsize1">
											</div>
									</div>
								</div>
							</div>
							<div class="allrow" style="margin-top: 7px;">	
								<!-- R・L -->
								<div class="black-border" style="height: 147px; flex-direction: column;">
									<div class="border-bottom" style="height: 27px; width: 60px; border: 1px solid;">
										<label></label>
									</div>
									<div class="leftright border-bottom" style="height: 60px; width: 60px; border: 1px solid;">
										<label>R</label>
									</div>
									<div class="leftright" style="height: 60px; width: 60px; border: 1px solid;">
										<label>L</label>
									</div>
								</div>	
								<!-- AX列 -->
								<div>
									<div class="col-border" style="width: 100px; border: 1px solid;">
										<label class="lavel-left">AX</label>
									</div>
									<div class="double-row" style="height: 120px;">
										<input type="text" class="inputsize1">
										<input type="text" class="inputsize1">
									</div>
								</div>									
								<!-- P/BASE 1列-->
								<div>
									<div class="col-border" style="width: 150px; border: 1px solid;">
										<label class="lavel-left">P/BASE 1</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<!-- P/BASE 2列-->
								<div>
									<div class="col-border" style="width: 150px; border: 1px solid;">
										<label class="lavel-left">P/BASE 2</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
										<div class="double-row" style="width: 75px;">
											<input type="text" class="inputsize1">
											<input type="text" class="inputsize1">
										</div>
									</div>
								</div>
								<!-- ADD列 -->
								<div>
									<div class="col-border" style="width: 100px; border: 1px solid;">
										<label class="lavel-left">ADD</label>
									</div>
									<div style="height: 120px; width: 100px;">
										<input type="text" class="inputsize1" style="width: 100%; border: 1px solid; height: 120px;">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row"　style="margin-top: 20px;">
                        <div class="col-2 item-title">CL度数</div>
                        <div class="col-1 item-title">R</div>
                        <div class="col-4 modal-item-value">
                            <label class="ef">
                                <input type="text"/>
                            </label>
                        </div>
                    </div>
					<div class="row">
                        <div class="col-2 item-title"></div>
                        <div class="col-1 item-title">L</div>
                        <div class="col-4 modal-item-value">
                            <label class="ef">
                                <input type="text"/>
                            </label>
                        </div>
                    </div>
	            </div><!-- /modal-content -->
                <div class="row" style="margin-top: 10px;">
	                <div class="col-12">
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