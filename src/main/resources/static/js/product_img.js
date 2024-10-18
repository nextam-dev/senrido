/**
 * 処理中モーダル
 */
Vue.component('product_img',{
	  props: ['code'],
	template: '\
	   	<transition name="modal-p">\
	   	<div class="modal-mask-p">\
	   	   	<div class="modal-wrapper-p">\
		       	<div class="modal-container-p">\
		        	<div class="modal-header-p">\
	   			   	</div>\
	   			   	<div class="modal-body-p">\
					<img id="img" class="imgComp" border="0" v-bind:src="file.fileImage" rows="20" cols="20">\
	   			   	</div>\
					<div class="modal-footer-p">\
					</div>\
	           	</div>\
	       	</div>\
	    </div>\
	    </transition>\
	',
	data:function(){
		return {
			//商品マスタ一覧
			mProductList:{
				productCode: "" ,
				productName: "" ,
				productKana: "" ,
				productName2: "" ,
				capacity: "" ,
				specification: "" ,
				salesUnitCostExcludeTax: "" ,
				ancientUnitCostExcludeTax: "" ,
				stockUnitCostExcludeTax: "" ,
				unitGrossProfitExcludeTax: "" ,
				productSecCode: "" ,
				productCategoryCode: "" ,
				offeringApplicationFlg:false,
				webFlg:false,
				productImage:"",
				customerCode:"",
				productNote: "" ,
				createName: "" ,
				createDate: "" ,
				updateName: "" ,
				updateDate: "" ,
				delFlg: "" ,
			},
			// 商品マスタ
			mProduct:{
				productCode: "" ,
				productName: "" ,
				productKana: "" ,
				productName2: "" ,
				capacity: "" ,
				specification: "" ,
				salesUnitCostExcludeTax: "" ,
				ancientUnitCostExcludeTax: "" ,
				stockUnitCostExcludeTax: "" ,
				unitGrossProfitExcludeTax: "" ,
				productSecCode: "" ,
				productCategoryCode: "" ,
				offeringApplicationFlg:false,
				webFlg:false,
				productImage:null,
				customerCode:"",
				unitCode: "" ,
				productNote: "" ,
				createName: "" ,
				createDate: "" ,
				updateName: "" ,
				updateDate: "" ,
				delFlg: "" ,
			},
			// 選択された写真の実体と削除フラグを保持する要素
			file:{
				fileImage:"/img/noImage.png",
				productPicture: null
			},
		}
	},
	created(){
		//var code = this.code;
		axios.get('/Common/product').then(response => {this.mProductList = response.data;}).catch(err => {console.log('err:', err);err_function(err);});
		this.getProduct();
		this.initPicture(this.mProduct);
	},
	methods:{
        open: function () {
            this.getProduct();
        },
		getProduct:function(){
			if(this.productCode == ""){
				this.productName = "";
				return;
			}
			axios.get('/Common/product/' + this.code)
			// thenで成功した場合の処理をかける
			.then(response => {
				console.log('status:', response.status); // 200
				console.log('body:', response.data);	 // response body.
				var image = response.data;
				this.initPicture(image);
			// catchでエラー時の挙動を定義する
			}).catch(err => {
				console.log('err:', err);
				//エラー処理
				this.productName = "";
				err_function(err);
			});
		},
		initPicture:function(item){
			var img = "";
			// 画像データを持っている場合、そのデータを表示させる。
			if (item.productImage) {
				this.file.fileImage = "data:image/png;base64,"+item.productImage;
				document.getElementById("img").setAttribute("src","data:image/png;base64,"+item.productImage);
			} else {
				// 画像データを持っていない場合：
				this.file.fileImage = "/img/noImage.png";
				document.getElementById("img").setAttribute("src","/img/noImage.png");
			}
			// 画像データを初期化。
			this.file.productPicture = null;
			 $("#imgButton").val("");
		},
	},
});
