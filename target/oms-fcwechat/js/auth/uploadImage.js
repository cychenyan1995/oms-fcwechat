var fileName;

// 获取Id
$('input[type="file"]').click(function() {
    var imageId = $(this).attr("id");
    fileName = imageId;
});

function displayImage(fileName, img) {
    if (fileName == "uploaderInput1") {
        $('.id-card_front').find('img').remove();
        $('.id-card_front').append(img);
        $('.id-card_front').find('img').attr("id", "img1").attr('style', 'width: 100%;   height: 100%;');
    } else if (fileName == "uploaderInput2") {
        $('.id-card_obverse').find('img').remove();
        $('.id-card_obverse').append(img);
        $('.id-card_obverse').find('img').attr("id", "img2").attr('style', 'width: 100%;   height: 100%;');
    } else if (fileName == "uploaderInput3") {
        $('.id-card_handheld').find('img').remove();
        $('.id-card_handheld').append(img);
        $('.id-card_handheld').find('img').attr("id", "img3").attr('style', 'width: 100%;   height: 100%;');
    }

    // 按钮能不能可用
    if (($("#phoneNo").val() != "") && ($("#code").val() != "") && ($("#name").val() != "") && ($("#idNo").val() != "") && ($(".id-card_front").find($("img")).attr("src") != undefined) && ($(".id-card_obverse").find($("img")).attr("src") != undefined) && ($(".id-card_handheld").find($("img")).attr("src") != undefined)) {
        $submit.removeAttr("disabled");
    }
}

$(document).ready(function() {

    var maxsize = 1024 * 1024;

    // 选择文件
    $('input[type="file"]').on('change',
    function() {
        var file = this.files[0];

        if (!/\/(?:jpeg|png|gif)/i.test(file.type)) {
            return;
        }

        var reader = new FileReader();

        // 获取图片大小
        var size = file.size / 1024 > 1024 ? (~~ (10 * file.size / 1024 / 1024)) / 10 + "MB": ~~ (file.size / 1024) + "KB";

        // 插入进度条
        var div = '<div class="progress"><span>' + size + '</span><input type="hidden"/></div>';

        $('#' + fileName).after(div);

        // 读取成功后回调函数
        reader.onload = function() {
            var result = this.result;
            var img = new Image();
            img.src = result;
            displayImage(fileName, img);

            // 如果图片大小小于100kb，则直接上传
            if (result.length <= maxsize) {
                img = null;
                upload(result, file.type, $('#' + fileName).parent());
                return;
            }
            // 图片加载完毕之后进行压缩，然后上传
            if (img.complete) {
                callback();
            } else {
                img.onload = callback;
            }
            function callback() {
                var data = compress(img);
                upload(data, file.type, $('#' + fileName).parent());
                img = null;
            }
        };
        reader.readAsDataURL(file);

    });
});