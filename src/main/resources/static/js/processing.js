/**
 * 処理中モーダル
 */
Vue.component('processing',{
//	props:["err_message"],
	template: '\
	   	<transition name="modal-p">\
	   	<div class="modal-mask-p">\
	   	   	<div class="modal-wrapper-p">\
		       	<div class="modal-container-p">\
		        	<div class="modal-header-p">\
	   			   	</div>\
	   			   	<div class="modal-body-p">\
						<p style="text-align:center; font-size: 2em;">処理中です。</p>\
	   			   	</div>\
					<div class="modal-footer-p">\
					</div>\
	           	</div>\
	       	</div>\
	    </div>\
	    </transition>\
	',
	created(){
		//
	},
	methods:{
	},
});
