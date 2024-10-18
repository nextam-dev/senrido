window.addEventListener('DOMContentLoaded', function () {
	new Vue({
		el: '#content',
		data:function(){
			return {
				// 進捗フラグ
				processingFlg:false,
				// メッセージ
                message:[],
				// ローカルストーレージ保管鍵
				localStrageKey : 'standardListConditionKey',
				// ページロード
				isPageLoad: false,

				// 担当者検索モーダル用
				employeeModalItem: {},
				// 処理中モーダル表示/非表示
                processingFlg:false,
                // 検索条件初期化フラグ
                initSearchFlg: false,
			}
		},
		created(){
			// 検索条件取得
			//this.getSearchConditions();
		},
		mounted:function(){
			// データ取得
			//this.getData();
		},
		computed:{
		},
		methods:{
			getData:function(){
				var self = this;
				self.showModalProcessing();
				self.isPageLoad = false;
				self.$refs.infiniteLoading.stateChanger.complete();

				// 担当者が削除済みの場合
				if(!this.operationStaffName){
					this.searchConditions.operationStaffCode = [];
				}
				// 検索条件初期化値取得
            	axios.post(editUrl('/m00201BasicInformationList/initStatus'))
				.then(response => {
					
					// 契約社員フラグをセットする。
					self.contractEmployeeFlg = response.data.contractEmployeeFlg;
					
					if(self.initSearchFlg || self.contractEmployeeFlg){
						self.searchConditions.operationStaffCode.push(response.data.employeeCode);
						self.operationStaffName = response.data.employeeName;
					}

					var postItem = {
						orderDivCode: this.searchConditions.orderDivCode,
						operationStaffCode: this.searchConditions.operationStaffCode,
						decedentName: this.searchConditions.decedentName,
						page: this.page,
						perpage: this.perpage,
					};
					axios.post(editUrl('/m00201BasicInformationList/searchList'), postItem)
					.then(response => {
						// 受注区分リスト
						self.orderDivCodeList = [{ code: "" , name: "" }];
						response.data.orderDivList.forEach( function(item){
	                		self.orderDivCodeList.push(item);
	                    });
						
						// ローカルに保存
						self.standardInfoList = [];
						response.data.standardInfoList.forEach( function(item){
	                		self.standardInfoList.push(item);
	                    });

						// 検索条件をローカルストレージに保存
						self.searchConditions.operationStaffName = self.operationStaffName;
	                    localStorage.setItem(self.localStrageKey, JSON.stringify(self.searchConditions));

						// 取得件数0件の場合
						if (self.standardInfoList.length == 0) {
							alert("該当するデータが存在しません。");
							self.initSearchFlg = false;
							self.closeModalProcessing();
							return;
						}

						// ページ情報更新
						self.page++;

	                    // スクロール読み込みをリセット
	                    self.isPageLoad = true;
	                    self.$refs.infiniteLoading.stateChanger.reset();

	                    self.initSearchFlg = false;
						self.closeModalProcessing();
					})
					.catch(err => {
						console.log('err:', err);
						err_function(err);
						self.initSearchFlg = false;
						self.closeModalProcessing();
					})
				})
				.catch(err => {
					console.log('err:', err);
					err_function(err);
					self.initSearchFlg = false;
					self.closeModalProcessing();
				})
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
