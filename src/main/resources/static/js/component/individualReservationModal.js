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
	            		<div class="col-10" style="margin-top: 5px; font-size: 20px;">
	                    	<label class="modal-hedder-title">測定時間</label>
	                	</div>
	                	<div class="col-6" style="font-size: 30px;">
	                    	<label class="input-label"><input type="checkbox"><span class="spaceLeft">1時間</span></label>
	                	</div>
	                	<div class="col-6" style="font-size: 30px;">
	                    	<label class="input-label"><input type="checkbox"><span class="spaceLeft">30分</span></label>
	                	</div>
	            	</div>
	            	<div class="row" style="margin-top:10px;">
			            		<div class="col-4">
									<label　class="item-title">カナ</label>
			            		</div>
			            		<div class="col-8">
			            			<input type="text" class="individual-text">
			            		</div>
			            	</div>
	            	<div class="row"  style="margin-top:10px;">
						<div class="col-6" style="min-height:40px;">
							<button class="modal-regist" style="width: 90px;">検索</button>
						</div>
						<div class="col-6" style="min-height:40px;">
							<button class="modal-regist" style="width: 90px;">条件クリア</button>
						</div>
	            	</div>
	            	<div v-for="(item, index) in accordionItems" :key="index" class="accordion-item" style="margin-top:10px;">
					<div class="accordion-header" @click="toggleAccordion(index)">
						<label style="margin-top: 15px;">{{ item.title }}</label>
					</div>
					<div v-if="item.open" class="accordion-content">
							<div class="row">
			            		<div class="col-4">
									<label　class="item-title">カナ</label><label class="label-required">必須</label>
			            		</div>
			            		<div class="col-8">
			            			<input type="text" class="individual-text">
			            		</div>
			            	</div>
			            	<div class="row">
			            		<div class="col-4">
									<label　class="item-title">メールアドレス</label><label class="label-required">必須</label>
			            		</div>
			            		<div class="col-8">
			            			<input type="text" class="individual-text">
			            		</div>
			            	</div>
			            	<div class="row">
			            		<div class="col-4">
									<label　class="item-title">電話番号</label><label class="label-required">必須</label>
			            		</div>
			            		<div class="col-8">
			            			<input type="text" class="individual-text">
			            		</div>
			            	</div>
			            	<div class="row">
			            		<div class="col-12 botton-area" style="min-height:40px; margin:10px 0px; text-align:center;">
									<button class="modal-regist">新規登録</button>
								</div>
			            	</div>
						</div>
					</div>
	            	<div class="row" :class="{ 'selected-row': selectedRow === 1 }" @click="selectRow(1)" style="margin-top: 20px; font-size: 15px;border: 1px solid; padding: 10px;">
					    <div class="col-4">
					        <label>山田太郎</label>
					    </div>
					    <div class="col-8">
					        <label>千葉県銚子市若宮町102-9</label>
					    </div>
					</div>
					<div class="row" :class="{ 'selected-row': selectedRow === 2 }" @click="selectRow(2)" style="margin-top: 5px; font-size: 15px;border: 1px solid; padding: 10px;">
					    <div class="col-4">
					        <label>山田隆</label>
					    </div>
					    <div class="col-8">
					        <label>青森県平川市館田稲村959-8</label>
					    </div>
					</div>
					<div class="row" :class="{ 'selected-row': selectedRow === 3 }" @click="selectRow(3)" style="margin-top: 5px; font-size: 15px;border: 1px solid; padding: 10px;">
					    <div class="col-4">
					        <label>山田隆介</label>
					    </div>
					    <div class="col-8">
					        <label>北海道北斗市中央4-837-13</label>
					    </div>
					</div>
	            </div><!-- /modal-content -->
                <div class="row">
	                <div class="col-12">
	                    <div class="col-12 botton-area" style="min-height:40px;">
	                    	<button class="modal-regist">登録</button>
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
			selectedRow: null,
			accordionItems: [
                { title: '新規お客様登録', open: false, inputValue: '' },
            ],
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
		selectRow(rowNumber) {
	        this.selectedRow = rowNumber;
	    },
	    toggleAccordion: function(index) {
            // アコーディオンの開閉
            this.accordionItems[index].open = !this.accordionItems[index].open;
        },
    },
});