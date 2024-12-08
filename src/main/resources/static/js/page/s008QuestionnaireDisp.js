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
                // アンケート情報
                survey: {
                	// お客様ID
                	id: null,
                	// 来店日
                	visitDate: null,
                	// 年齢
                	age: null,
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
                var postItem = {
                		survey : this.survey,
                };
                var url = editUrl('/s008Questionnaire/search');
                axios.post(url, postItem)
                    .then(function (response) {
                    	self.survey = response.data.surveyInfo;
                    	self.calculateAge();
                    }).catch(function (err) {
                        // error(err);
                    	location.href = editUrl('/error');
                    }).then(function () {
                        self.processingFlg = false;
                    });
        	},
            calculateAge: function() {
                if (!this.survey.birthday) {
                    this.age = null;
                    return;
                }

                const today = new Date();
                const birthday = new Date(this.survey.birthday);
              
                let age = today.getFullYear() - birthday.getFullYear();
                const monthDiff = today.getMonth() - birthday.getMonth();
                const dayDiff = today.getDate() - birthday.getDate();

                // 誕生日前の場合は年齢を1歳引く
                if (monthDiff < 0 || (monthDiff === 0 && dayDiff < 0)) {
                    age--;
                }

                this.survey.age = age;
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
        filters: {
            dateToYM: function (date) {
                return moment(date).format('YYYY年MM月');
            }
        }
    });
});
