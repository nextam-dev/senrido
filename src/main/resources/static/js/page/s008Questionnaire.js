window.addEventListener('DOMContentLoaded', function () {
    new Vue({
        el: '#content',
        data: function () {
            return {
                // 進捗フラグ
                processingFlg: false,
                // メッセージ
                messages: [],
                // ローカルストレージ保管鍵
                localStrageKey: 's008Questionnaire',
                // 処理中モーダル表示/非表示
                processingFlg: false,
                // 検索条件初期化フラグ
                initSearchFlg: false,
                // ログインフラグ
                loginFig:true,
                // 性別
                sexItems: [],
                // アンケート情報
                survey: {
                	// お客様ID
                	id: null,
                	// 来店日
                	visitDate: null,
                	// 客様名
                	name: null,
                	// お客様名カナ
                	nameKana: null,
                	// 生年月日
                	birthday: null,
                	// メールアドレス
                	mail: null,
                	// 性別
                	sex: null,
                	// 性別その他
                	sexOther: null,
                	// 郵便番号
                	zipcode: null,
                	// 住所
                	address: null,
                	// 電話番号
                	telephone: null,
                	// 紹介者
                	referrer: null,
                }
            }
        },
        created() {
        	// パラメータからお客様IDと来店日を取得する
        	var params = URI.parseQuery(window.location.search);

            this.survey.id = params.id || null;
            this.survey.visitDate = params.visitDate || null;
        	
        	this.init();
        },
        mounted: function () {
            // 何もしない
        },
        computed: {},
        methods: {
        	// 初期表示
        	init: function() {
    			var self = this;
                self.processingFlg = true;
                var postItem = {};
                var url = editUrl('/s008Questionnaire/initStatus');
                axios.post(url, postItem)
                    .then(function (response) {
                        console.log(response.data);
                        self.sexItems = response.data.sexItems;
                    }).catch(function (err) {
                        // error(err);
                    	location.href = editUrl('/error');
                    }).then(function () {
                        self.processingFlg = false;
                    });
        	},
        	// 検索画面へ遷移
        	back: function() {
                location.href = editUrl('/s005CustomerInformationSearch');
            },
            // 送信処理
            sendAuestionnaire: function() {
            	if (!confirm('アンケートを送信します。よろしいですか？')) {
            		return;
            	}
            	
            	var self = this;
                this.messages = [];
                
                var postItem = {
                		survey : this.survey,
				}
                
                self.processingFlg = true;
                var url = editUrl('/s008Questionnaire/insert');
                axios.post(url, postItem)
                    .then(function (response) {
                        console.log(response.data);
                        // TODO エラーチェック
                        
                        // 完了画面へ遷移
                        location.href = editUrl('/s008Questionnaire/complete');
                    }).catch(function (err) {
                        // error(err);
                    	location.href = editUrl('/error');
                    }).then(function () {
                        self.processingFlg = false;
                    });
            },
            // 閉じる
            close: function() {
            	window.close();
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
