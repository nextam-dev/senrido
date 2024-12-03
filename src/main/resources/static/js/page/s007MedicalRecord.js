﻿window.addEventListener('DOMContentLoaded', function () {
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
                // ハンバーガーメニュー
                isMenuOpen: false,
                // パラメータ
                id: "",
                // お客様情報
                customerInfo: {},
                // 眼科への通院情報
                visitingHospitalInfoList: [],
                // 眼の手術情報
                surgeryInfoList: [
                    { cataractName: '白内障右' } // 眼の手術情報をここに追加
                ],
                //　視力の低下情報
                visionLossInfoList: [],
                // メガネ・CL装用状況情報
                usageStatusInfoList: [],
                //　メガネのトラブル情報
                troubleInfoList: [],
                // 眼・身体の症状情報  
                symptomsInfoList: [],
                // 眩しさを感じる物事情報
                glareInfoList: [],
                //　見えないと困るもの情報
                criticalVisibilityNeedsInfoList: [],
                // 見づらさや疲れを感じるとき
                discomfortFatigueInfoList: [],
                // メガネの装用情報 
                glassesUsageInfoList: [],
                //　過去の病歴情報
                pastMedicalHistoryInfoList: [],
                // 治療中の疫病（服用薬）情報
                ongoingDiseasesMedicationInfoList: [],
                //　ご職業情報
                occupationInfoList: [],
                // 趣味・部活情報 
                hobbiesClubActivitiesInfoList: [],
                // 眼の使用状況情報
                eyeUsageStatusInfoList: [],
                
                // 売上詳細情報
                salesInfoList: [
                    { seq: '1' } 
                    ],
                
                // 眼科への通院リスト
                visitingHospitalItems:[],
                // 眼の症状リスト
                eyeSymptomsItems:[],
                // 身体の症状リスト
                bodySymptomsItems:[],
                // メガネトラブルリスト
                glassesIssuesItems:[],
                // フレームトラブルリスト
                frameIssuesItems:[],
                // 眩しさを感じる物事リスト
                glareSourcesItems:[],
                // メガネの装用－現状
                useGlassesCurrentItems:[],
                // メガネの装用－CL装用
                useGlassesWithClItems:[],
                // メガネの装用－用途
                useGlassesPurposeItems:[],
                // ピッチリスト（輻輳　開散　水平斜位量　上下寄せ　上下斜位量　P）
                pitchRangeRyePItems:[],
                // ピッチリスト（NPC アイポイント） 
                pitchRangeNpcEyepointItems:[],
                // ピッチリスト（V CV） 
                pitchRangeVCvItems:[],
                // ピッチリスト（S C ADD） 
                pitchRangeSCAddItems:[],
                // ピッチリスト（AX） 
                pitchRangeAxItems:[],
                // ピッチリスト（BASE） 
                pitchRangeBaseItems:[],
                // ピッチリスト（PD） 
                pitchRangePdItems:[],
                // オプションリスト 
                optionItems:[],
                // 決済方法リスト 
                depositKindCdItems:[],
                // 完成連絡方法リスト 
                completionContactItems:[],
                
                // モーダル用
				modalItem: {},
                // アコーディオンのデータ
				accordionItems: [
                    { title: '眼科への通院', open: false, visitingHospitalInfoList: [], modalRef: 'visitingHospitalModal' },
                    { title: '眼の手術', open: false, surgeryInfoList: [], modalRef: 'operationModal' },
                    { title: '視力の低下を感じたのは', open: false, visionLossInfoList: [], modalRef: 'impairedVisionModal' },
                    { title: 'メガネの装用', open: false, glassesUsageInfoList: [], modalRef: 'wearingGlassesModal' },
                    { title: 'メガネ・CLの装用状況', open: false, usageStatusInfoList: [], modalRef: 'wearingSituationModal' },
                    { title: 'メガネのトラブル', open: false, troubleInfoList: [], modalRef: 'glassesTroubleModal' },
                    { title: '眼・身体の症状', open: false, symptomsInfoList: [], modalRef: 'symptomsModal' },
                    { title: '眩しさを感じる物事', open: false, glareInfoList: [], modalRef: 'dazzlingThingsModal' },
                    { title: '見づらさや疲れを感じるとき', open: false, discomfortFatigueInfoList: [], modalRef: 'seeDiscomfortFatigueModal' },
                    { title: '見えないと困るもの', open: false, criticalVisibilityNeedsInfoList: [], modalRef: 'seeProblemModal' },
                    { title: 'ご職業', open: false, occupationInfoList: [], modalRef: 'occupationModal' },
                    { title: '趣味・部活', open: false, hobbiesClubActivitiesInfoList: [], modalRef: 'hobbyAndClubModal' },
                    { title: '眼の使用状況', open: false, eyeUsageStatusInfoList: [], modalRef: 'usageStatusModal' },
                    { title: '過去の病歴', open: false, pastMedicalHistoryInfoList: [], modalRef: 'caseHistoryModal' },
                    { title: '治療中の疫病（服用薬）', open: false, ongoingDiseasesMedicationInfoList: [], modalRef: 'treatmentDiseaseModal' },
                ],
                accordionItemGani: {
                	title: '眼位', open: false, inputValue: ''
                },
                accordionItemDosu: {
                	title: '作成度数', open: false, inputValue: ''
                },
                accordionItemKyosei: {
                	title: '完全矯正', open: false, inputValue: ''
                },
                accordionItemRef: {
                	title: 'レフ', open: false, inputValue: ''
                },
                accordionItemHistory: {
                	title: '過去データ', open: false, inputValue: ''
                },
                accordionItemSales: {
                	title: '売上データ', open: false, inputValue: ''
                },
                isFarSelected: true,   // 初期状態で「遠」が選択されている状態
                isNearSelected: false, // 初期状態で「近」は選択されていない状態
            };
        },
        created(){
			// URLからパラメータ取得
			// this.id = getParam('id');
        	this.id = '2';
        	this.visitDate = '2024-11-30 17:00:00';
        	var params = URI.parseQuery(window.location.search);
			// データ取得
			this.getData();
		},
		computed:{
		},
        methods: {
        	getData:function(){
        		this.showModalProcessing();
        		var postItem = {
        				id: this.id,
        				visitDate: this.visitDate,
        		};
        		var self = this;
        		axios.post(editUrl('/s007MedicalRecord/initData'), postItem)
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
        			self.customerInfo = response.data.customerInfo;
        			self.visitingHospitalInfoList = response.data.visitingHospitalInfoList;
        			//self.surgeryInfoList = response.data.surgeryInfoList;
        			//self.visionLossInfoList = response.data.visionLossInfoList;
        			//self.usageStatusInfoList = response.data.usageStatusInfoList;
        			//self.troubleInfoList = response.data.troubleInfoList;
        			//self.symptomsInfoList = response.data.symptomsInfoList;
        			//self.glareInfoList = response.data.glareInfoList;
        			//self.criticalVisibilityNeedsInfoList = response.data.criticalVisibilityNeedsInfoList;
        			//self.discomfortFatigueInfoList = response.data.discomfortFatigueInfoList;
        			//self.glassesUsageInfoList = response.data.glassesUsageInfoList;
        			//self.pastMedicalHistoryInfoList = response.data.pastMedicalHistoryInfoList;
        			//self.ongoingDiseasesMedicationInfoList = response.data.ongoingDiseasesMedicationInfoList;
        			//self.occupationInfoList = response.data.occupationInfoList;
        			//self.hobbiesClubActivitiesInfoList = response.data.hobbiesClubActivitiesInfoList;
        			//self.eyeUsageStatusInfoList = response.data.eyeUsageStatusInfoList;
        			
        			self.salesInfoList = response.data.salesInfoList;
        			
        			self.visitingHospitalItems = response.data.visitingHospitalItems;
        			self.eyeSymptomsItems = response.data.eyeSymptomsItems;
        			self.bodySymptomsItems = response.data.bodySymptomsItems;
        			self.glassesIssuesItems = response.data.glassesIssuesItems;
        			self.frameIssuesItems = response.data.frameIssuesItems;
        			self.glareSourcesItems = response.data.glareSourcesItems;
        			self.useGlassesCurrentItems = response.data.useGlassesCurrentItems;
        			self.useGlassesWithClItems = response.data.useGlassesWithClItems;
        			self.useGlassesPurposeItems = response.data.useGlassesPurposeItems;
        			self.pitchRangeRyePItems = response.data.pitchRangeRyePItems;
        			self.pitchRangeNpcEyepointItems = response.data.pitchRangeNpcEyepointItems;
        			self.pitchRangeVCvItems = response.data.pitchRangeVCvItems;
        			self.pitchRangeSCAddItems = response.data.pitchRangeSCAddItems;
        			self.pitchRangeAxItems = response.data.pitchRangeAxItems;
        			self.pitchRangeBaseItems = response.data.pitchRangeBaseItems;
        			self.pitchRangePdItems = response.data.pitchRangePdItems;
        			self.optionItems = response.data.optionItems;
        			self.depositKindCdItems = response.data.depositKindCdItems;
        			self.completionContactItems = response.data.completionContactItems;
        			
        			
        			self.closeModalProcessing();
        		})
        		.catch(err => {
        			console.log('err:', err);
        			err_function(err);
        			self.closeModalProcessing();
        		});
        	},
        	// 検索画面へ遷移
        	back: function() {
        		history.back();
            },
            // ログイン画面へ遷移
            logout: function() {
                location.href = editUrl('/');
            },
            // 更新画面へ遷移
            movePasswordChange: function() {
                location.href = editUrl('/s002PasswordChange');
            },
            // アンケート画面を開く
            openQuestionnaire: function() {
            	window.open(editUrl('/s008Questionnaire'), '_blank');
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
            scrollToAccordionHead: function() {
                const target = document.getElementById('accordionHead');
                if (target) {
                    target.scrollIntoView({ behavior: 'smooth' });
                }
            },
            scrollToAccordionGani: function() {
            	this.accordionItemGani.open = true;
                const target = document.getElementById('accordionGani');
                if (target) {
                    target.scrollIntoView({ behavior: 'smooth' });
                }
            },
            scrollToAccordionDosu: function() {
                const target = document.getElementById('accordionDosu');
                if (target) {
                    target.scrollIntoView({ behavior: 'smooth' });
                }
            },
            scrollToAccordionKako: function() {
                const target = document.getElementById('accordionKako');
                if (target) {
                    target.scrollIntoView({ behavior: 'smooth' });
                }
            },
            scrollToAccordionUriage: function() {
                const target = document.getElementById('accordionUriage');
                if (target) {
                    target.scrollIntoView({ behavior: 'smooth' });
                }
            },
            toggleAccordion: function(index) {
                // 他のアコーディオン項目を閉じる
                this.accordionItems.forEach((item, i) => {
                    if (i !== index) {
                        item.open = false; // 他の項目を閉じる
                    }
                });

                // 現在のアコーディオン項目を開閉
                this.accordionItems[index].open = !this.accordionItems[index].open;
            },
            toggleAccordionGani: function () {
            	// アコーディオンの開閉
                this.accordionItemGani.open = !this.accordionItemGani.open;
                // 他のアコーディオン項目を閉じる
                this.accordionItems.forEach((item, i) => {
                    item.open = false;
                });
            },
            toggleAccordionDosu: function () {
            	// アコーディオンの開閉
                this.accordionItemDosu.open = !this.accordionItemDosu.open;
                // 他のアコーディオン項目を閉じる
                this.accordionItems.forEach((item, i) => {
                    item.open = false;
                });
            },
            toggleAccordionKyosei: function () {
            	// アコーディオンの開閉
                this.accordionItemKyosei.open = !this.accordionItemKyosei.open;
                // 他のアコーディオン項目を閉じる
                this.accordionItems.forEach((item, i) => {
                    item.open = false;
                });
            },
            toggleAccordionRef: function () {
            	// アコーディオンの開閉
                this.accordionItemRef.open = !this.accordionItemRef.open;
                // 他のアコーディオン項目を閉じる
                this.accordionItems.forEach((item, i) => {
                    item.open = false;
                });
            },
            toggleAccordionHistory: function () {
            	// アコーディオンの開閉
                this.accordionItemHistory.open = !this.accordionItemHistory.open;
                // 他のアコーディオン項目を閉じる
                this.accordionItems.forEach((item, i) => {
                    item.open = false;
                });
            },
            toggleAccordionSales: function () {
            	// アコーディオンの開閉
                this.accordionItemSales.open = !this.accordionItemSales.open;
                // 他のアコーディオン項目を閉じる
                this.accordionItems.forEach((item, i) => {
                    item.open = false;
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
            openModal(index) {
                const modalRef = this.accordionItems[index].modalRef;
                if (this.$refs[modalRef]) {
                	this.modalItem.visitingHospitalItems = this.visitingHospitalItems;
                    this.$refs[modalRef].open(this.modalItem);
                }
            },
            openEyePositionModal: function() {
            	this.$refs.eyePositionModal.open();
            },
            openCreateDosuModal: function() {
            	this.$refs.createDosuModal.open();
            },
            openCreateKyoseiModal: function() {
            	this.$refs.kanzenKyoseiModal.open();
            },
            openContactModal: function() {
            	// スケジュール並び替えモーダル表示
            	this.$refs.contactModal.open(this.customerInfo);
            },
            addBt: function(){
            	return;
            }
        },
    });
});
