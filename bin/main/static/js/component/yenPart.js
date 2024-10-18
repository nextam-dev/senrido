Vue.component('yen_part',{
    props:["item"],
    computed:{
        c_yen:{
            get:function(){
                return String( Math.round(this.item)).replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,');;
            },
        },
    },
    template:'<label style="margin-bottom: 0;">￥{{c_yen}}</label>',
});