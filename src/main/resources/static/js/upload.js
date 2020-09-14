let Main = {
    data() {
        return {
            fileList: []
        };
    },
    methods: {
        handlePreview(file) {
            console.log(file);
        },
        handleExceed(files, fileList) {
            this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 
            ${files.length + fileList.length} 个文件`);
        },
        beforeRemove(file, fileList) {
            return this.$confirm(`确定移除 ${file.name}？`);
        },
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handleSuccess(response, file, fileList) {
            if (response.success === true) {
                let result = response.data;
                let outLink = result.outLink;
                this.$msgbox({
                    title: '上传成功',
                    message: `你的外链是: ${outLink} ，并自动拷贝到剪贴板。`
                });
                navigator.clipboard.writeText(outLink)
                    .then(() => {
                        this.$message({
                            message: "外链已经成功复制到剪贴板。",
                            type: "success"
                        })
                    }).catch(err => {
                        console.error('无法复制此文本：', err);
                    })
            }
        }
    }
};
let Ctor = Vue.extend(Main);
new Ctor().$mount('#app');