<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OSS Upload Index Page</title>
</head>
<body>
    <#include 'upload_page.ftl'/>
    <form method="post" action="/api/upload/qiniu" enctype="multipart/form-data">
        <input type="file" name="upload-file"><br><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>