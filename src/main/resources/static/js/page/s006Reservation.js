window.addEventListener('DOMContentLoaded', function () {
    new Vue({
        el: '#content',
        data: function () {
            return {
                // 進捗フラグ
                processingFlg: false,
                // メッセージ
                message: [],
                // ローカルストレージ保管鍵
                localStrageKey: 'standardListConditionKey',
                // 処理中モーダル表示/非表示
                processingFlg: false,
                // 検索条件初期化フラグ
                initSearchFlg: false,
                // ログインフラグ
                loginFig:true,
                // メニューフラグ
                menuFig:true,
                // ハンバーガーメニュー
                isMenuOpen: false,
                // お客様情報検索
                customerSearchList:{
                	// 店舗
                	shopCd: "",
                	// 顧客番号
                	customerCd: "",
                	// 名前
                	name: "",
                	// 名前（カナ）
                	nameKana: "",
//                	mainContactType "",
                	// 電話番号
                	telephone: "",
//                	mobilePhone "",
//                	workPhone "",
                	// 性別
                	sexitem: "",
                	// 来店日（開始）
                	visitDateStart: "",
                	// 来店日（終了）
                	visitDateEnd: "",
                	// 摘要
                	outline: "",
                	// 担当
                	personInCharge: "",
                	// 次回来店日
                	nextVisitDate: "",
                	// 前回来店日
                	previousVisitDate: "",
                	// 時間枠
                	timeSlot: "",
                	// 開催日（開始）＝次回開催日
                	eventDateStart: "",
                	// 開催日（終了）＝次回開催日
                	eventDateEnd: "",
                },
                customerList: [
                    {
                    	kana: "",
                    	name: "",
                    	tel: "",
                    	id: "",
                    	birthDate: "",
                    	age: "",
                    	gender: "",
                    	lastVisit: "",
                    	nextVisit: "",
                    	address: "",
                    	nextDate: "",
                    	previousDate: "",
                    	timeSlot: "",
                    }
                  ],
                  conditions: "",
                  // 1時間のスタイル
                  oneHourStyle: {
                    fontSize: '20px',
                    backgroundColor: '#4d9ef4',
                    color: '#fff',
                    width: '80px',
                    fontWeight: 'bold',
                    textAlign: 'center'
                  },
                  // 30分のスタイル
                  halfHourStyle: {
                    fontSize: '20px',
                    fontWeight: 'bold',
                    backgroundColor: '#e0737e',
                    color: '#fff',
                    width: '80px',
                    textAlign: 'center'
                  },
            }
        },
        created() {
        	// 何もしない
        },
        mounted: function () {
            // 何もしない
        },
        computed: {},
        methods: {
        	getData:function(){
        		var self = this;
        		var postItem = {

        			};
        	axios.post(editUrl('/s006Reservation/initData'), postItem)
        	.then(response => {
        		// バリデーション・システムエラーチェック
        		var alertMessage = checkValid(response.data.resultCd, response.data.messageList);
        		if(alertMessage.length != 0) {
        			alert(alertMessage);
        			self.closeModalProcessing();
        			return;
                        }
        		// エラーの場合
        		if(response.data.message != null){
        			alert(response.data.message);
        			self.closeModalProcessing();
        			return;
        		}
        		// プルダウン選択肢
        		self.shopNameList = [{ code: "" , name: "" }];
        		response.data.shopNameList.forEach( function(item){
            		self.shopNameList.push(item);
                });
				self.sexList = [{ code: "" , name: "" }];
				response.data.sexList.forEach( function(item){
            		self.sexList.push(item);
                });
				self.personInChargeList = [{ code: "" , name: "" }];
				response.data.personInChargeList.forEach( function(item){
            		self.personInChargeList.push(item);
                });
        	 });
        	},
        	// 検索処理
            searchData: function() {
            	var self = this;
                this.messages = [];

                var postItem = {
                	customerSearchList : this.customerSearchList,
				}

                self.processingFlg = true;
                var url = editUrl('/s006Reservation/selectList');
                axios.post(url, postItem)
                    .then(function (response) {
                        console.log(response.data);
                        // TODO エラーチェック

                        // 検索結果を格納
                        self.customerList = response.data.tcustomer;

                        // 連絡先の表示条件指定
                        self.customerList.forEach(customer => {
                            if (customer.mainContactType === '00002') {
                                customer.telephone = customer.mobilePhone; // 携帯電話番号
                            }else if (customer.mainContactType === '00003') {
                                customer.telephone = customer.workPhone; // 勤務先電話番号
                            }
                        });

                    }).catch(function (err) {
                        // error(err);
                    	location.href = editUrl('/error');
                    }).then(function () {
                        self.processingFlg = false;
                    });
            },
            // 検索結果ソート
            customerInformationSort:function(conditions){
            	var self = this;
                this.messages = [];

                var postItem = {
                	// 検索結果
                	customerSearchList : this.customerSearchList,
                	// 検索条件
                	conditions
				}
                console.log(conditions);
                self.processingFlg = true;
                var url = editUrl('/s006Reservation/sort');
                axios.post(url, postItem)
                    .then(function (response) {
                        console.log(response.data);
                        // TODO エラーチェック

                        // ソート結果を格納
                        self.customerList = response.data.tcustomer;

                        // 連絡先の表示条件指定
                        self.customerList.forEach(customer => {
                            if (customer.mainContactType === '00002') {
                                customer.telephone = customer.mobilePhone; // 携帯電話番号
                            }else if (customer.mainContactType === '00003') {
                                customer.telephone = customer.workPhone; // 勤務先電話番号
                            }
                        });

                    }).catch(function (err) {
                        // error(err);
                    	location.href = editUrl('/error');
                    }).then(function () {
                        self.processingFlg = false;
                    });
			},
        	// メニュー画面へ遷移
        	back: function() {
        		history.back();
            },
            // ログイン画面へ遷移
            logout: function() {
                location.href = editUrl('/');
            },
            // 更新画面へ遷移
            movePasswordChange: function() {
                location.href = editUrl('/s002PasswordChange');
            },
            // 詳細画面へ遷移
        	moveMedicalRecord: function() {
                location.href = editUrl('/s007MedicalRecord');
            },
            toggleMenu() {
                this.isMenuOpen = !this.isMenuOpen;
            },
            showModalProcessing: function () {
                this.processingFlg = true;
            },
            closeModalProcessing: function () {
                this.processingFlg = false;
            },
        },
    });
});
