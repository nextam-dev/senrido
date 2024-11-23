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
                localStrageKey: 'standardListConditionKey',
                // 処理中モーダル表示/非表示
                processingFlg: false,
                // 検索条件初期化フラグ
                initSearchFlg: false,
                // ログインフラグ
                loginFig:false,
                // ハンバーガーメニュー
                isMenuOpen: false,
                // ユーザーコード
                userCd: "",
                // パスワード
                password: "",
                // メッセージフラグ
                isMessage: false,
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
        	// ログイン処理
        	login:function(){
        		var self = this;
                var formData = $('#mainForm').serializeArray();
                var data = {};
                this.isMessage = false;
                this.messages = [];
                $.each(formData, function (bean) {
                    data[this.name] = this.value;
                });
                data["userCd"] = this.userCd;
                data["password"] = this.password;

                console.log(data);

                // 入力チェック
                if (this.userCd == "") {
                	this.messages.push("ログインIDは必須です。");
                };
                if (this.password == "") {
                	this.messages.push("パスワードは必須です。");
                };
                if (this.messages.length >= 1) {
                	return;
                };

                $.ajax({
                    type: "POST",
                    url: "/senrido/login",
                    data: data,
                    dataType: "html",
                    async: false,
                    success: function (data, status, xhr) {
                        if (data == "AUTH_NG") {
                        	alert("ログインに失敗しました。ログインIDかパスワードが違います。");
                            return;
                        }
                        location.href= "s004Menu";
                    },
                    error: function (xhr, status, error) {
                            if (status == 403) {
                                alert("不正なアクセスです");
                                return;
                            }
                        },
                    complete: function () {
                        }
                    });
        	},
        	// 発行画面へ遷移
        	movePasswordReissue: function() {
                location.href = editUrl('/s003PasswordReissue');
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
