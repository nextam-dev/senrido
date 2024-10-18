Vue.component('pager', {
    props: ["item"],
    computed: {
        isToFirst: function(){
            if(1 == parseInt(this.item.page))return false;
            return true;
        },
        isToBefore: function(){
            if(1 == parseInt(this.item.page))return false;
            return true;
        },
        isToNext: function(){
            if(parseInt(this.item.maxpage) == parseInt(this.item.page))return false;
            return true;
        },
        isToLast: function(){
            if(parseInt(this.item.maxpage) == parseInt(this.item.page))return false;
            return true;
        },
    },
    template: '\
        <div class="triangle">\
            <a v-if="isToFirst" href="#" @click="move_to_first"> ◀◀ </a>\
            <a v-else > ◀◀ </a>\
            <a v-if="isToBefore" href="#" @click="move_to_before"> ◀ </a>\
            <a v-else >  ◀ </a>\
			<label>{{item.page}}/{{item.maxpage}}</label>\
            <a v-if="isToNext" href="#" @click="move_to_next"> ▶ </a>\
            <a v-else > ▶  </a>\
            <a v-if="isToLast" href="#" @click="move_to_last"> ▶▶ </a>\
            <a v-else > ▶▶ </a>\
		</div>\
    ',
    methods:{
        move_to_first:function(){
            this.$emit('get_list', 1);
            return false;
        },
        move_to_before:function(){
            this.$emit('get_list', parseInt(this.item.page) - 1);
            return false;
        },
        move_to_next:function(){
            this.$emit('get_list', parseInt(this.item.page) + 1);
            return false;
        },
        move_to_last:function(){
            this.$emit('get_list', parseInt(this.item.maxpage) );
            return false;
        },
    },
});
