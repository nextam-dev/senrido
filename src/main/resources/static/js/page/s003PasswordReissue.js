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
                // メールアドレス
                email: "",
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
        	// パスワード発行メールを送信
            sendChangeMail: function() {
                var self = this;
                
                this.messages = [];
                
                if (!this.email) {
                	this.messages.push("メールアドレスは必須です。");
                	return;
                }
                
                var postItem = {
					email : this.email,
				}
                
                self.processingFlg = true;
                var url = editUrl('/s003PasswordReissue/reissuePassword');
                axios.post(url, postItem)
                    .then(function (response) {
                        console.log(response.data);
                        // 取得したデータを設定
                        var message = response.data;
                        if (message && message != "") {
                        	self.messages.push(message);
                        	return;
                        }
                        
                        alert("パスワード再発行のメールを送信しました。");
                        
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
