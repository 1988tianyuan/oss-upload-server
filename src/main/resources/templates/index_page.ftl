<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OSS Upload Index Page</title>
    <link rel="stylesheet" href="https://unpkg.com/element-ui@2.13.2/lib/theme-chalk/index.css">
</head>
<body>
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/element-ui@2.13.2/lib/index.js"></script>
    <#include 'upload_page.ftl'/>
</body>
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
        /*line-height: 50px;*/
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