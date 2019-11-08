new Vue({
    el:"#app",
    data:{
        title:"",
        author:"",
        poem:"",
        pageNum:"1",
        total:"",
        preDisabled:false,
        nextDisabled:false,
        inputPageNum:1,
        keyWord:"",
    },
    created(){
        this.getPoem();
    },
    methods:{
        getPoem(){
            var that = this;
            console.log(this.keyWord);
            axios.post(rootUrl+"/api/poem/getPoemByPageAndKey","page="+that.pageNum+"&size=1"+"&keyWord="+ encodeURI(that.keyWord)).then(function (response) {
                    // handle success
                    console.log(response.data);
                    console.log(response.data.list[0]);
                    var p = response.data.list[0];
                    that.poem = p.poem.replace(/。/g,"。<br>");//句号换行
                    that.poem = that.poem.replace(/？/g,"？<br>");//句号换行
                    that.poem = that.poem.replace(/！/g,"！<br>");//句号换行
                    that.title = p.title;
                    that.author = p.poet.name;
                    if(p.poet.description!=null&&p.poet.description!=""){
                        that.author += " ("+p.poet.description+")"
                    }
                    that.total = response.data.total;
                    that.pageNum = response.data.pageNum;
                    console.log(that.poem);
                    if(that.pageNum==1){
                        that.preDisabled = true;
                    }else{
                        that.preDisabled = false;
                    }
                    if(that.pageNum==that.total){
                        that.nextDisabled = true;
                    }else{
                        that.nextDisabled = false;
                    }
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                })
                .finally(function () {
                    // always executed
                });
        },
        preTang(){
            console.log("上一首");
            this.pageNum = this.pageNum - 1;
            this.getPoem();
        },
        nextTang(){
            console.log("下一首");
            this.pageNum = this.pageNum + 1;
            this.getPoem();
        },
        inputTang(){
            if(this.pageNum>this.total){
                this.pageNum = this.total;
            }else if(this.pageNum<1){
                this.pageNum = 1;
            }
            this.getPoem();
        },
        searchPoem(){
            //点击搜索，页码置为1
            this.pageNum = 1;
            this.getPoem();
        },
        searchClear(){
            this.keyWord="";
            this.pageNum = 1;
            this.getPoem();
        }
    }
})