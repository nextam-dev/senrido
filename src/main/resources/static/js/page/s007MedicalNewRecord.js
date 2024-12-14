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
                localStrageKey: 's007MedicalNewRecord',
                // 検索条件初期化フラグ
                initSearchFlg: false,
                // ログインフラグ
                loginFig:true,
                // 性別
                sexList: [],
                id: "",
                // お客様情報
                customerInfo: {
                    customerCd: null,
                    name: null,
                    nameKana: null,
                    sex: null,
                    sexOther: null,
                    birthday: null,
                    visitData: null,
                    zipcode: null,
                    address: null,
                    mail: null,
                    mainContactType: null,
                    telephone: null,
                    mobilePhone: null,
                    workPhone: null,
                    referrer: null,
                },
            }
        },
        created() {        	
        	this.init();
        },
        mounted: function () {
            // 何もしない
        },
        computed: {},
        methods: {
        	init:function(){
        		this.showModalProcessing();
        		var postItem = {};
        		var self = this;
        		axios.post(editUrl('/s007MedicalNewRecord/initStatus'))
        		.then(response => {
        			// バリデーション・システムエラーチェック
        			var alertMessage = checkValid(response.data.resultCd, response.data.messageList);
        	        if(alertMessage.length != 0) {
        	        	alert(alertMessage);
        	        	self.closeModalProcessing();
        	        	return;
        	        }
        			// エラーの場合
        			if(response.data.message != null){
        				alert(response.data.message);
        				self.closeModalProcessing();
        				return;
        			}

        			// 初期表示情報
        			self.sexList = response.data.sexList;
        			
        			self.closeModalProcessing();
        		})
        		.catch(err => {
        			console.log('err:', err);
        			err_function(err);
        			self.closeModalProcessing();
        		});
        	},
        	update:function() {
        		var self = this;
        		self.showModalProcessing();
    			var postItem = {
    				visitingHospitalInfo: self.visitingHospitalInfo,
    			};
    			axios.post(editUrl('/s007MedicalNewRecord/insert'), postItem)
    			.then(response => {
    				console.log("リクエスト成功:", response.data);
    				// バリデーション・システムエラーチェック
    				var alertMessage = checkValid(response.data.resultCd, response.data.messageList);
                    if(alertMessage.length != 0) {
                    	alert(alertMessage);
                    	self.closeModalProcessing();
                    	return;
                    }
    				// 処理後メッセージ
    				alert(response.data.message);
    				self.closeModalProcessing();
    				location.href = editUrl('/s007MedicalRecord');
    			})
    			.catch(err => {
    				console.log('err:', err);
    				err_function(err);
    				self.closeModalProcessing();
    			});
    		},
    		// 検索画面へ遷移
        	back: function() {
                location.href = editUrl('/s005CustomerInformationSearch');
            },
        	// 検索画面へ遷移
        	cansel: function() {
                location.href = editUrl('/s005CustomerInformationSearch');
            },
            // ログイン画面へ遷移
            logout: function() {
                location.href = editUrl('/');
            },
            // 更新画面へ遷移
            movePasswordChange: function() {
                location.href = editUrl('/s002PasswordChange');
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
