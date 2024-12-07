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
                loginFig:true,
                // パスワード
                password: "",
                // パスワード確認用
                passwordConfirm: "",
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
        	back: function () {
        		 history.back();
            },
            // パスワード変更
            changePassword: function() {
                var self = this;

                this.messages = [];

                if (!this.password) {
                	this.messages.push("パスワードは必須です。");
                	return;
                }

                if (this.password !== this.passwordConfirm) {
                	this.messages.push("パスワードはが一致しません。");
                	console.log(this.messages); 
                	return;
                }

                var postItem = {
                		password : this.password,
				}

                self.processingFlg = true;
                var url = editUrl('/s002PasswordChange/changePassword');
                axios.post(url, postItem)
                    .then(function (response) {
                        console.log(response.data);
                        // 取得したデータを設定
                        var message = response.data;
                        if (message && message != "") {
                        	self.messages.push(message);
                        	return;
                        }
                        
                        alert("パスワード更新完了");
                        
                        // ログイン画面へ遷移
                        location.href = editUrl('/');
                    }).catch(function (err) {
                        // error(err);
                    	location.href = editUrl('/error');
                    }).then(function () {
                        self.processingFlg = false;
                    });
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
