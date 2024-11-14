document.addEventListener('DOMContentLoaded', function () {
    new Vue({
        el: '#content',
        data: function () {
            return {
                processingFlg: false,
                message: [],
                localStrageKey: 'standardListConditionKey',
                initSearchFlg: false,
                loginFig: true,
                selectedDate: null, 
                // 30分刻みの時間枠
                timeSlots: [
                    '9:00', '9:30', '10:00', '10:30', '11:00', '11:30', 
                    '12:00', '12:30', '13:00', '13:30', '14:00', '14:30', 
                    '15:00', '15:30', '16:00', '16:30', '17:00', '17:30', '18:00'
                ],
                // 各時間枠に対応する予約データ
                schedule: [
                    [{ time: '9:00', title: '山田太郎', duration: 2 }, { time: '9:00', title: '佐藤花子', duration: 1 }],
                    [{ time: '9:30', title: '山田太郎', duration: 2 }, { time: '9:30', title: '鈴木一郎', duration: 1 }],
                    [{ time: '10:00', title: '田中太郎', duration: 1 }],
                    [{ time: '10:30', title: '松本幸子', duration: 1 }],
                    [{ time: '11:00', title: '', duration: 0 }],
                    [{ time: '11:30', title: '高橋美咲', duration: 2 }],
                    [{ time: '12:00', title: '高橋美咲', duration: 2 }],
                    [{ time: '12:30', title: '伊藤俊平', duration: 2 }, { time: '12:30', title: '', duration: 0 }],
                    [{ time: '13:00', title: '伊藤俊平', duration: 2 }, { time: '13:00', title: '後藤優作', duration: 1 }],
                ],
            };
        },
        methods: {
            getCellClass: function (event, index) {
                if (!event || !event.title) return 'empty-cell';

                // 1時間枠の場合、隣接する枠が同じタイトルならそのセルをつなげる
                if (event.duration === 2) {
                    if (index > 0 && this.schedule[index - 1][0].title === event.title && this.schedule[index - 1][0].duration === 2) {
                        return 'merged-cell'; // 前の時間枠と同じタイトルがあれば、セルをつなげる
                    } else {
                        return 'one-hour-cell'; // 通常の1時間枠
                    }
                }

                // 30分刻みのセル処理
                return 'half-hour-cell';
            },
            selectDate: function(date) {
                this.selectedDate = date; // 日付を更新
            },
            back: function() {
                history.back();
            },
            logout: function() {
                location.href = '/';
            },
            movesReservation: function() {
                location.href = editUrl('/s006Reservation');
            },
            openModal: function() {
            	this.$refs.individualReservationModal.open();
            },
        }
    });
});
