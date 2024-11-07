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
                // 検索条件初期化フラグ
                initSearchFlg: false,
                // ログインフラグ
                loginFig: true,
                monthYear: '',
                weekdays: ["日", "月", "火", "水", "木", "金", "土"],
                daysInMonth: [],
                dataForDate: { // 仮のデータ件数（例として）
                    '2024-11-01': 5,
                    '2024-11-02': 3,
                    '2024-11-03': 8,
                    '2024-11-04': 2,
                    '2024-11-05': 10,
                    '2024-11-06': 7,
                    '2024-11-07': 4,
                    '2024-11-08': 6,
                    '2024-11-09': 1,
                    // 他の日付も仮データを追加可能
                },
            };
        },
        created() {
        	this.generateCalendar(new Date());
        },
        mounted: function () {
            // 何もしない
        },
        methods: {
        	// 検索画面へ遷移
        	back: function() {
                location.href = editUrl('/s004Menu');
            },
            // ログイン画面へ遷移
            logout: function() {
                location.href = editUrl('/');
            },
            generateCalendar: function(date) {
                const currentMonth = date.getMonth();
                const currentYear = date.getFullYear();
                this.monthYear = `${currentYear}年 ${currentMonth + 1}月`;

                const firstDayOfMonth = new Date(currentYear, currentMonth, 1);
                const lastDayOfMonth = new Date(currentYear, currentMonth + 1, 0);
                const numberOfDaysInMonth = lastDayOfMonth.getDate();
                const firstDayOfWeek = firstDayOfMonth.getDay();

                this.daysInMonth = [];

                // 最初の空白を埋める
                for (let i = 0; i < firstDayOfWeek; i++) {
                    this.daysInMonth.push({ date: '', count: undefined });
                }

                // 日付を追加
                for (let day = 1; day <= numberOfDaysInMonth; day++) {
                    this.daysInMonth.push({ date: day, count: this.getDataCount({ date: day }) });
                }
            },
            isToday: function(day) {
                const today = new Date();
                return today.getDate() === day.date && today.getMonth() === new Date().getMonth();
            },
            getDataCount: function(day) {
                const date = `${new Date().getFullYear()}-${new Date().getMonth() + 1}-${day.date < 10 ? '0' + day.date : day.date}`;
                return this.dataForDate[date] || 0; // 仮データ件数を表示
            },
            showAlert: function(day) {
                const date = `${new Date().getFullYear()}-${new Date().getMonth() + 1}-${day.date < 10 ? '0' + day.date : day.date}`;
                alert(`選択した日付: ${date}\nデータ件数: ${this.getDataCount(day)} 件`);
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
