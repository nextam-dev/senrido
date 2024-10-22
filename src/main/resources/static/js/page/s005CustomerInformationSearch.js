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
                customers: [
                    { kana: 'ヤマダタロウ', name: '山田太郎', id: '0001', birthDate: '平成11年04月18日', age: '25歳', gender: '男性', lastVisit: '2024/10/24' },
                    { kana: 'スズキイチロウ', name: '鈴木一郎', id: '0002', birthDate: '平成10年12月05日', age: '26歳', gender: '男性', lastVisit: '2024/10/23' },
                    { kana: 'サトウハナコ', name: '佐藤花子', id: '0003', birthDate: '平成9年06月14日', age: '27歳', gender: '女性', lastVisit: '2024/10/22' },
                    { kana: '田中タロウ', name: '田中太郎', id: '0004', birthDate: '平成8年09月19日', age: '28歳', gender: '男性', lastVisit: '2024/10/21' },
                    { kana: 'タカハシミサキ', name: '高橋美咲', id: '0005', birthDate: '平成12年01月01日', age: '24歳', gender: '女性', lastVisit: '2024/10/20' },
                    { kana: 'イトウシュンペイ', name: '伊藤俊平', id: '0006', birthDate: '平成7年03月03日', age: '29歳', gender: '男性', lastVisit: '2024/10/19' }
                  ],
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
        	back: function() {
                location.href = editUrl('/s004Menu');
            },
        	// 詳細画面へ遷移
        	moveMedicalRecord: function() {
                location.href = editUrl('/s007MedicalRecord');
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
