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
                localStrageKey: 's008Questionnaire',
                // 処理中モーダル表示/非表示
                processingFlg: false,
                // 検索条件初期化フラグ
                initSearchFlg: false,
                // ログインフラグ
                loginFig:true,
                // プルダウン情報
                sexList: [],
                usageStatusList: [],
                computerTypeList: [],
                computerUsageTimeList: [],
                smartphoneUsageTimeList: [],
                smartphoneContentList: [],
                readingList: [],
                gamingNameList: [],
                gamingTimeList: [],
                drivingList: [],
                licenseTypeList: [],
                ophthalmologyVisitList: [],
                eyeFatigueList: [],
                eyeSymptomsList: [],
                bodySymptomsList: [],
                surgeryList: [],
                covidDisclosureList: [],
                createdGlassesUsageList: [],
                changesList: [],
                glassesConcernsList: [],
                eyeFatigueSecondList: [],
                prescriptionStrengthList: [],
                // アンケート情報
                survey: {
                	// お客様ID
                	id: null,
                	// 来店日
                	visitDate: null,
                	// 初回フラグ
                	firstTimeFlag: false,
                	// 客様名
                	name: null,
                	// お客様名カナ
                	nameKana: null,
                	// 生年月日
                	birthday: null,
                	// メールアドレス
                	mail: null,
                	// 性別
                	sex: null,
                	// 性別その他
                	sexOther: null,
                	// 郵便番号
                	zipcode: null,
                	// 住所
                	address: null,
                	// 電話番号
                	telephone: null,
                	// 紹介者
                	referrer: null,
                	// 職業
                	occupationType: null,
                	// お仕事の内容 
                	jobDescription: null,
                	// 使用状況
                	usageStatus: [],
                	// 使用状況その他
                	usageStatusOther: null,
                	// 使用開始年齢
                	usageStartAge: null,
                	// パソコン種類
                	computerType: [],
                	// パソコン種類その他
                	computerTypeOther: null,
                	// パソコン使用時間
                	computerUsageTime: null,
                	// パソコン使用時間その他
                	computerUsageTimeOther: null,
                	// パソコン距離
                	distance: null,
                	// スマートフォン使用時間
                	smartphoneUsageTime: null,
                	// スマートフォン使用時間その他
                	smartphoneUsageTimeOther: null,
                	// スマートフォン見るもの
                	smartphoneContent: [],
                	// スマートフォン見るものその他
                	smartphoneContentOther: null,
                	// 読書
                	reading: null,
                	// 読書その他
                	readingOther: null,
                	// ゲーム
                	gaming: [],
                	// ゲームその他
                	gamingOther: null,
                	// ゲーム時間
                	gamingTime: null,
                	// ゲーム時間その他
                	gamingTimeOther: null,
                	// 運転
                	driving: null,
                	// 運転その他
                	drivingOther: null,
                	// 免許種類
                	licenseType: [],
                	// 免許種類その他
                	licenseTypeOther: null,
                	// 眼科受診
                	ophthalmologyVisit: [],
                	// 眼科受診その他
                	ophthalmologyVisitOther: null,
                	// 眼の疲れ
                	eyeFatigue: null,
                	// 眼の疲れ名称
                	eyeFatigueName: null,
                	// 疲れを感じるとき
                	fatigueTiming: null,
                	// 目の症状
                	eyeSymptoms: [],
                	// 目の症状その他
                	eyeSymptomsOther: null,
                	// 身体の症状
                	bodySymptoms: [],
                	// 身体の症状その他
                	bodySymptomsOther: null,
                	// 手術
                	surgery: [],
                	// 手術その他
                	surgeryOther: null,
                	// 趣味
                	hobbies: null,
                	// コロナ開示
                	covidDisclosure: null,
                	// コロナ開示その他
                	covidDisclosureOther: null,
                	// 備考
                	remarks: null,
                	// 作成メガネ使用状況
                	createdGlassesUsage: null,
                	// 作成メガネ使用状況その他
                	createdGlassesUsageOther: null,
                	// 変化
                	changes: [],
                	// メガネ気になること
                	glassesConcerns: [],
                	// メガネ気になることその他
                	glassesConcernsOther: null,
                	// 環境変化
                	environmentalChanges: null,
                	// 目の疲れ2回目
                	eyeFatigueSecond: null,
                	// 度数
                	prescriptionStrength: [],
                	// 度数その他
                	prescriptionStrengthOther: null,
                	
                }
            }
        },
        created() {
        	// パラメータからお客様IDと来店日を取得する
        	var params = URI.parseQuery(window.location.search);

            this.survey.id = params.id || null;
            this.survey.visitDate = params.visitDate || null;
        	
        	this.init();
        },
        mounted: function () {
            // 何もしない
        },
        computed: {},
        methods: {
        	// 初期表示
        	init: function() {
    			var self = this;
                self.processingFlg = true;
                var postItem = {};
                var url = editUrl('/s008Questionnaire/initStatus');
                axios.post(url, postItem)
                    .then(function (response) {
                        console.log(response.data);
                        self.sexList = response.data.sexList;
                        self.usageStatusList = response.data.usageStatusList;
                        self.computerTypeList = response.data.computerTypeList;
                        self.computerUsageTimeList = response.data.computerUsageTimeList;
                        self.smartphoneUsageTimeList = response.data.smartphoneUsageTimeList;
                        self.smartphoneContentList = response.data.smartphoneContentList;
                        self.readingList = response.data.readingList;
                        self.gamingNameList = response.data.gamingNameList;
                        self.gamingTimeList = response.data.gamingTimeList;
                        self.drivingList = response.data.drivingList;
                        self.licenseTypeList = response.data.licenseTypeList;
                        self.ophthalmologyVisitList = response.data.ophthalmologyVisitList;
                        self.eyeFatigueList = response.data.eyeFatigueList;
                        self.eyeSymptomsList = response.data.eyeSymptomsList;
                        self.bodySymptomsList = response.data.bodySymptomsList;
                        self.surgeryList = response.data.surgeryList;
                        self.covidDisclosureList = response.data.covidDisclosureList;
                        self.createdGlassesUsageList = response.data.createdGlassesUsageList;
                        self.changesList = response.data.changesList;
                        self.glassesConcernsList = response.data.glassesConcernsList;
                        self.eyeFatigueSecondList = response.data.eyeFatigueSecondList;
                        self.prescriptionStrengthList = response.data.prescriptionStrengthList;
                    }).catch(function (err) {
                        // error(err);
                    	location.href = editUrl('/error');
                    }).then(function () {
                        self.processingFlg = false;
                    });
        	},
        	// 検索画面へ遷移
        	back: function() {
                location.href = editUrl('/s005CustomerInformationSearch');
            },
            // 送信処理
            sendAuestionnaire: function(var firstTimeFlag) {
            	if (!confirm('アンケートを送信します。よろしいですか？')) {
            		return;
            	}
            	
            	var self = this;
                this.messages = [];
                
                this.survey.firstTimeFlag = firstTimeFlag;
                var postItem = {
                		survey : this.survey,
				}
                
                self.processingFlg = true;
                var url = editUrl('/s008Questionnaire/insert');
                axios.post(url, postItem)
                    .then(function (response) {
                        console.log(response.data);
                        // TODO エラーチェック
                        
                        // 完了画面へ遷移
                        location.href = editUrl('/s008Questionnaire/complete');
                    }).catch(function (err) {
                        // error(err);
                    	location.href = editUrl('/error');
                    }).then(function () {
                        self.processingFlg = false;
                    });
            },
            // 閉じる
            close: function() {
            	window.close();
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
