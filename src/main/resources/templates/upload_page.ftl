<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <div id="app">
        <el-upload
                drag
                action="/api/upload/qiniu"
                name="upload-file"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                <#--                            multiple-->
                :limit="3"
                :before-upload="beforeUpload"
                :on-progress="handleProgress"
                :on-exceed="handleExceed"
                :on-success="handleSuccess"
                :on-error="handleError"
                :show-file-list="false"
                :file-list="fileList">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或者<em>点击</em>上传</div>
        </el-upload>
        <el-progress :text-inside="true" :stroke-width="26" :percentage="currentPercent"
                     display="false"></el-progress>
        <el-table :data="fileList" border stripe style="width: 100%">
            <el-table-column prop="name" label="文件名"></el-table-column>
            <el-table-column prop="status" label="上传状态"></el-table-column>
            <el-table-column prop="outLink" label="生成外链">
                <template slot-scope="scope">
                    <div>{{scope.row.outLink}}</div>
                    <el-button type="primary" @click="copyOutLink(scope.row.outLink)">复制</el-button>
                </template>
            </el-table-column>
            <el-table-column prop="markdownLink" label="生成markdown链接">
                <template slot-scope="scope">
                    <div>{{scope.row.markdownLink}}</div>
                    <el-button type="primary" @click="copyMkDown(scope.row.markdownLink)">复制</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</body>
<script src="js/upload.js"></script>
</html>

<style>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 500px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
</style>