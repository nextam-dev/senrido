window.addEventListener('DOMContentLoaded', function () {
	new Vue({
		el: '#content',
		mounted:function(){
		},
		data:function(){
			return {
				// 進捗フラグ
				processingFlg:false,
			}
		},
		created(){
		},
		computed:{
		},
        methods:{
        	getData:function(){
				var self = this;
				self.showModalProcessing();
			},
//			function toggleContent(sectionId, buttonId) {
//	            var content = document.getElementById(sectionId);
//	            var button = document.getElementById(buttonId);
//	
//	            if (content.style.display === "none") {
//	                content.style.display = "block";
//	                button.textContent = "－";
//	            } else {
//	                content.style.display = "none";
//	                button.textContent = "＋";
//	            }
//	        }
//	
//	        // 初期化：最初は非表示にしておく
//	        window.onload = function() {
//	            document.getElementById("toggle-section").style.display = "none";
//	            document.getElementById("toggle-section-anti").style.display = "none";
//	        };
			moveRequest:function() {
				// 移動申請モーダル表示
				this.$refs.rollCallRecordModal.open();
			},
	    	showModalProcessing:function() {
				this.processingFlg = true;
			},
			closeModalProcessing:function() {
				this.processingFlg = false;
			},
		},
	});
});