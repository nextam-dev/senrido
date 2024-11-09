window.addEventListener('DOMContentLoaded', function () {
    new Vue({
        el: '#content',
        data: function () {
            return {
            	currentDate: new Date(), // 現在の月
                processingFlg: false,
                message: [],
                localStrageKey: 'standardListConditionKey',
                initSearchFlg: false,
                loginFig: true,
                monthYear: '',
                weekdays: ["月", "火", "水", "木", "金", "土", "日"],
                daysInMonth: [],
                dataForDate: {
                    '2024-11-08': 9,
                    '2024-11-09': 8,
                    '2024-11-10': 19,
                    '2024-11-11': 7,
                },
            };
        },
        created() {
            this.generateCalendar(this.currentDate);
        },
        mounted() {
            this.generateCalendar(this.currentDate);
        },
        methods: {
            // 月を切り替える
            changeMonth: function (offset) {
                const newDate = new Date(this.currentDate);
                newDate.setMonth(this.currentDate.getMonth() + offset);
                // currentDate を更新
                this.currentDate = newDate;

                // 強制的に再描画を行う
                this.generateCalendar(newDate);
                this.$forceUpdate(); // 強制的に再描画を行う
            },
            // カレンダーを生成
            generateCalendar: function (date) {
                console.log("generateCalendar called with date:", date); // 追加して確認
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
            // 今日の日付かチェック
            isToday: function(day) {
                const today = new Date();
                return today.getDate() === day.date && today.getMonth() === new Date().getMonth();
            },
            // データ件数を取得
            getDataCount: function(day) {
                const date = `${new Date().getFullYear()}-${new Date().getMonth() + 1}-${day.date < 10 ? '0' + day.date : day.date}`;
                return this.dataForDate[date] || 0;
            },
            // 日付をクリックした時にアラート表示
            showAlert: function(day) {
                const date = `${new Date().getFullYear()}-${new Date().getMonth() + 1}-${day.date < 10 ? '0' + day.date : day.date}`;
                alert(`選択した日付: ${date}\nデータ件数: ${this.getDataCount(day)} 件`);
            },
    	    // メニュー画面へ遷移
        	back: function() {
                location.href = editUrl('/s004Menu');
            },
            // ログイン画面へ遷移
            logout: function() {
                location.href = editUrl('/');
            },
            // 検索画面へ遷移
            movesReservationTimetable: function() {
                location.href = editUrl('/s006ReservationTimetable');
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
