let UploadApp = {
    data() {
        return {
            fileList: [],
            currentPercent: 0,
            currentUploadStatus: '',
            enableCopy: ''
        };
    },
    methods: {
        beforeUpload(file) {
            console.log("${rc.contextPath}");
            this.currentPercent = 0;
        },

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
        handleProgress(event, file, fileList) {
            console.log("正在上传, event:" + JSON.stringify(event));
            let percent = event.percent;
            this.currentPercent = percent;
            if (percent === 100) {
                console.log("上传完毕, event:" + JSON.stringify(event));
                this.currentUploadStatus = 'success';
            }
        },
        handleSuccess(response, file, fileList) {
            console.log(`这个文件上传成功：${JSON.stringify(file)}`);
            file.status = '成功';
                if (response.success === true) {
                let outLink = response.data.outLink;
                file.outLink = outLink;
                file.markdownLink = `![](${outLink})`;
                this.$msgbox({
                    title: '上传成功',
                    message: `你的markdown链接是: ${file.markdownLink} ，并自动拷贝到剪贴板。`
                });
                this.copy(outLink, "外链已经成功复制到剪贴板。");
            }
            this.fileList.push(file);
        },
        handleError(err, file, fileList) {
            console.log(`这个文件上传失败：${JSON.stringify(file)}`);
            this.currentUploadStatus = 'exception';
            file.status = '失败';
            file.response = err;
            this.$msgbox({
                title: '上传失败',
                message: err
            });
            this.fileList.push(file);
        },
        copyOutLink(outLink) {
            this.copy(outLink, "外链已经成功复制到剪贴板。");
        },
        copyMkDown(markdownLink) {
            this.copy(markdownLink, "markdown链接已经成功复制到剪贴板。");
        },
        copy(text, successMsg) {
            if (navigator.clipboard !== undefined) {
                navigator.clipboard.writeText(text)
                    .then(() => {
                        this.$message({
                            message: successMsg,
                            type: "success"
                        })
                    }).catch(err => {
                    this.$message.error('无法复制此文本：'+ err);
                })
            } else {
                // this.enableCopy = false;
                this.$message.error('当前环境（非https）无法自动复制文本，请手动复制');
            }
        }
    }
};
let Ctor = Vue.extend(UploadApp);
new Ctor().$mount('#app');