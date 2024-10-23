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
                // アコーディオンのデータ
                accordionItems: [
                    { title: '眼科への通院', open: false, inputValue: '' },
                    { title: '眼の手術', open: false, inputValue: '' },
                    { title: '視力の低下を感じたのは', open: false, inputValue: '' },
                    { title: 'メガネ・CLの装用状況', open: false, inputValue: '' },
                    { title: 'メガネのトラブル', open: false, inputValue: '' },
                    { title: '眼・身体の症状', open: false, inputValue: '' },
                    { title: '眩しさを感じる物事', open: false, inputValue: '' },
                    { title: '見えないと困るもの', open: false, inputValue: '' },
                    { title: 'メガネの装用', open: false, inputValue: '' },
                    { title: '過去の病歴', open: false, inputValue: '' },
                    { title: '治療中の疫病（服用薬）', open: false, inputValue: '' },
                    { title: 'ご職業', open: false, inputValue: '' },
                    { title: '趣味・部活', open: false, inputValue: '' },
                    { title: '眼の使用状況', open: false, inputValue: '' },
                ],
                isFarSelected: true,   // 初期状態で「遠」が選択されている状態
                isNearSelected: false, // 初期状態で「近」は選択されていない状態
            };
        },
        methods: {
        	// 検索画面へ遷移
        	back: function() {
                location.href = editUrl('/s005CustomerInformationSearch');
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
            toggleAccordion: function(index) {
                // アコーディオンの開閉
                this.accordionItems[index].open = !this.accordionItems[index].open;
                // 他のアコーディオン項目を閉じる
                this.accordionItems.forEach((item, i) => {
                    if (i !== index) {
                        item.open = false;
                    }
                });
            },
            selectFar: function(index) {
                this.isFarSelected = true;
                this.isNearSelected = false;
              },
            selectNear: function(index) {
                this.isFarSelected = false;
                this.isNearSelected = true;
            },
            openEdit: function() {
            	this.$refs.customerEditModal.open();
            },
            openModal: function() {
            	this.$refs.visitingHospitalModal.open();
            },
            openEyePositionModal: function() {
            	this.$refs.eyePositionModal.open();
            },
        },
    });
});
