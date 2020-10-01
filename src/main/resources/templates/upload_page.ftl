<div id="app">
    <el-container>
        <el-header>Header</el-header>
        <el-main>

            <el-upload
                    drag
                    action="${rc.contextPath}/api/upload/qiniu"
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
        </el-main>
    </el-container>

    <el-progress :text-inside="true" :stroke-width="26" :percentage="currentPercent"
                 display="false"></el-progress>
    <el-table :data="fileList" border stripe style="width: 100%">
        <el-table-column prop="name" label="文件名"></el-table-column>
        <el-table-column prop="status" label="上传状态"></el-table-column>
        <el-table-column prop="outLink" label="生成外链">
            <template slot-scope="scope">
                <div>{{scope.row.outLink}}</div>
                <el-button type="primary"
                           :disabled="enableCopy"
                           @click="copyOutLink(scope.row.outLink)">复制</el-button>
            </template>
        </el-table-column>
        <el-table-column prop="markdownLink" label="生成markdown链接">
            <template slot-scope="scope">
                <div>{{scope.row.markdownLink}}</div>
                <el-button type="primary"
                           :disabled="enableCopy"
                           @click="copyMkDown(scope.row.markdownLink)">复制</el-button>
            </template>
        </el-table-column>
    </el-table>
</div>
<script src="${rc.contextPath}/js/upload.js"></script>