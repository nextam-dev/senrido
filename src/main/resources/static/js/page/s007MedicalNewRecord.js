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
                localStrageKey: 's007MedicalNewRecord',
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
                var url = editUrl('/s007MedicalNewRecord/initStatus');
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
        	cansel: function() {
                location.href = editUrl('/s005CustomerInformationSearch');
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
            showModalProcessing: function () {
                this.processingFlg = true;
            },
            closeModalProcessing: function () {
                this.processingFlg = false;
            },
        },
    });
});
