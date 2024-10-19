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
        	// 検索画面へ遷移
        	moveCustomerInformationSearch: function() {
                location.href = editUrl('/s005CustomerInformationSearch');
            },
            // 予約画面へ遷移
            moveReservation: function() {
                location.href = editUrl('/s006Reservation');
            },
            // ログイン画面へ遷移
            logout: function() {
                location.href = editUrl('/');
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
