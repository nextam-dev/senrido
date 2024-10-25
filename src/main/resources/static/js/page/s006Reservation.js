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
                // ハンバーガーメニュー
                isMenuOpen: false,
                customers: [
                    { kana: 'ヤマダタロウ', name: '山田太郎', id: '0001', birthDate: '平成11年04月18日', age: '25歳', gender: '男性', kaisu: '2', lastVisit: '2024/10/24 10:00', address: '千葉県銚子市若宮町102-9'},
                    { kana: 'スズキイチロウ', name: '鈴木一郎', id: '0002', birthDate: '平成10年12月05日', age: '26歳', gender: '男性', kaisu: '1', lastVisit: '2024/10/24 11:00', address: '青森県平川市館田稲村959-8'},
                    { kana: 'サトウハナコ', name: '佐藤花子', id: '0003', birthDate: '平成9年06月14日', age: '27歳', gender: '女性', kaisu: '3', lastVisit: '2024/10/24 13:00', address: '京都府京都市中京区六角油小路町816-13'},
                    { kana: '田中タロウ', name: '田中太郎', id: '0004', birthDate: '平成8年09月19日', age: '28歳', gender: '男性', kaisu: '初', lastVisit: '2024/10/24 14:00', address: '北海道北斗市中央4-837-13'},
                    { kana: 'タカハシミサキ', name: '高橋美咲', id: '0005', birthDate: '平成12年01月01日', age: '24歳', gender: '女性', kaisu: '1', lastVisit: '2024/10/24 15:00', address: '新潟県上越市大島区大島332-1'},
                    { kana: 'イトウシュンペイ', name: '伊藤俊平', id: '0006', birthDate: '平成7年03月03日', age: '29歳', gender: '男性', kaisu: '2', lastVisit: '2024/10/24 16:00', address: '埼玉県本庄市西五十子810-8'}
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
        	// メニュー画面へ遷移
        	back: function() {
                location.href = editUrl('/s004Menu');
            },
            // ログイン画面へ遷移
            logout: function() {
                location.href = editUrl('/');
            },
            // 更新画面へ遷移
            movePasswordChange: function() {
                location.href = editUrl('/s002PasswordChange');
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
