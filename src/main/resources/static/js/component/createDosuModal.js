Vue.component('create-dosu-modal', {
    template: (function () {/*
        <div class="modal-mask" id="createDosuModal" v-show="displayFlg">
            <div class="modal-wrapper-basis">
	            <!--　モーダルヘッダー　 -->
	            <div class="modal-hedder row">
	                <div class="col-10">
	                    <label class="modal-hedder-title">作成度数</label>
	                </div>
	                <div class="col-2">
	                    <button class="modal-hedder-close-button" @click="close">閉じる</button>
	                </div>
	            </div>
	            <!-- 入力エリア -->
	            <div class="modal-content">
                    <div class="row">
                        <div class="col-12 item-title">主な用途</div>
                        <div class="col-12 modal-item-value">
                            <div class="row item-margin">
                                <div class="col-3">
                                    <label class="input-label"><input type="radio" name="sex" value="0"><span class="spaceLeft">遠用</span></label>
                                </div>
                                <div class="col-3">
                                    <label class="input-label"><input type="radio" name="sex" value="1"><span class="spaceLeft">近用</span></label>
                                </div>
                                <div class="col-3">
                                    <label class="input-label"><input type="radio" name="sex" value="2"><span class="spaceLeft">室内</span></label>
                                </div>
                                <div class="col-3">
                                    <label class="input-label"><input type="radio" name="sex" value="3"><span class="spaceLeft">室外</span></label>
                                </div>
                            </div>
                            <div class="row item-margin">
                                <div class="col-3">
                                    <label class="input-label"><input type="radio" name="sex" value="4"><span class="spaceLeft">常用</span></label>
                                </div>
                                <div class="col-3">
                                    <label class="input-label"><input type="radio" name="sex" value="5"><span class="spaceLeft">CLの上用</span></label>
                                </div>
                                <div class="col-6">
                                    <label class="input-label"><input type="radio" name="sex" value="6"><span class="spaceLeft">必要に応じて</span></label>
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
						<div class="col-12 item-title">作製度数</div>
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
								<!-- CV列 -->
								<div>
									<div class="col-border" style="width: 200px; border: 1px solid;">
										<label class="lavel-left">CV</label>
									</div>
									<div style="display: flex; height: 120px;">
										<div style="width: 100px;">
											<input type="text" class="inputsize1" style="width: 100px; height: 120px; border: 1px solid;">
										</div>
										<div class="double-row" style="width: 100px;">
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
								<!-- AX列 -->
								<div>
									<div class="row-height">
										<div class="col-border" style="width: 100px; border: 1px solid;">
											<label class="lavel-left">AX</label>
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
									<div class="leftright border-bottom " style="height: 60px; width: 60px; border: 1px solid;">
										<label>R</label>
									</div>
									<div class="leftright" style="height: 60px; width: 60px; border: 1px solid;">
										<label>L</label>
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
								<!-- PD列 -->
								<div>
									<div class="col-border" style="width: 100px; border: 1px solid;">
										<label class="lavel-left">PD</label>
									</div>
									<div class="double-row" style="height: 120px;">
										<input type="text" class="inputsize1">
										<input type="text" class="inputsize1">
									</div>
								</div>
							</div>
						</div>
					</div>
                    <div class="row"　style="margin-top: 20px;">
                        <div class="col-3 item-title">近用作業距離</div>
                        <div class="col-3 modal-item-value">
                            <label class="ef">
                                <input type="text"/>
                            </label>
                        </div>
                        <div class="col-1" style="display: flex; align-items: center;">CM</div>
                    </div><!-- 作製度数 -->
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