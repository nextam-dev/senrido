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
				scheduleA: [
					[{ time: '9:00', title: '山田太郎', introducer: '田中太郎', duration: 2 }],
					[{ time: '9:30', title: '山田太郎', introducer: '田中太郎', duration: 2 }],
					[{ time: '10:00', title: '田中太郎', introducer: '山本健太', duration: 1 }],
					[{ time: '10:30', title: '松本幸子', introducer: '高橋大輔', duration: 1 }],
					[{ time: '11:00', title: '', introducer: '', duration: 0 }],
					[{ time: '11:30', title: '高橋美咲', introducer: '伊藤裕太', duration: 2 }],
					[{ time: '12:00', title: '高橋美咲', introducer: '伊藤裕太', duration: 2 }],
					[{ time: '12:30', title: '伊藤俊平', introducer: '松井優香', duration: 2 }],
					[{ time: '13:00', title: '伊藤俊平', introducer: '松井優香', duration: 2 }],
				],
				scheduleB: [
					[{ time: '9:00', title: '佐藤花子', introducer: '鈴木一郎', duration: 1 }],
					[{ time: '9:30', title: '鈴木一郎', introducer: '佐藤次郎', duration: 1 }],
					[{ time: '13:00', title: '後藤優作', introducer: '前田美穂', duration: 1 }],
				],
			};
		},
		methods: {
			getCellClass: function (schedule, event, index) {
				if (!event || !event.title) return 'empty-cell';

				// 1時間枠の場合、隣接する枠が同じタイトルならそのセルをつなげる
				if (event.duration === 2) {
					if (
						index > 0 && // 前のインデックスが有効か確認
						schedule[index - 1] && // 前のスロットが存在するか確認
						schedule[index - 1][0] && // 前のスロットの最初のイベントが存在するか確認
						schedule[index - 1][0].title === event.title &&
						schedule[index - 1][0].duration === 2
					) {
						return 'merged-cell'; // 前のスロットと同じタイトルの場合セルをつなげる
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
			moveMedicalRecord: function() {
				location.href = editUrl('/s007MedicalRecord');
			},
			openModal: function() {
				this.$refs.individualReservationModal.open();
			},
		}
	});
});
