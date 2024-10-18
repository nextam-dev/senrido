window.addEventListener('DOMContentLoaded', function () {
	new Vue({
		el: '#app',
		mounted:function(){
		},
		data: function() {
            return {
                // ダミーデータのリスト
                standardInfoList: [
                    {
                        orderDateStr: '112409047',
                        orderDivName: '2024/09/08',
                        undertakerNo: '火葬',
                        undertakerName: '山田太郎',
                        decedentName: '安置先',
                        mournerName: '連携',
                        contractorName: '済',
                        operationStaffName: '木村次郎'
                    },
                    {
                        orderDateStr: '112409046',
                        orderDivName: '2024/09/08',
                        undertakerNo: '火葬',
                        undertakerName: '井上太郎',
                        decedentName: '安置先',
                        mournerName: '連携',
                        contractorName: '未',
                        operationStaffName: '鈴木次郎'
                    }
                ],
                processingFlg: false
            };
        },
		created(){
		},
		computed:{
		},
		methods: {
            edit: function(item) {
                alert('編集機能はまだ実装されていません');
            },
            moveRollCallRecord: function() {
            	location.href = editUrl('/input');
            },
            searchRecord: function() {
            	this.$refs.searchRecordModal.open();
            },
            moveRequestList: function() {
            	location.href = editUrl('/g004');
            },
            back: function() {
                window.history.back();
            },
            selectRow: function(item) {
            	location.href = editUrl('/input');
            },
            showModalProcessing: function() {
                this.processingFlg = true;
            },
            closeModalProcessing: function() {
                this.processingFlg = false;
            },
            getData: function() {
                var self = this;
                self.showModalProcessing();
            }
        }
    });
});