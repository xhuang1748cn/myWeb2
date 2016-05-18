/**
 * Created by developer on 2016/3/31.
 */
/**
 * @Description:动态事件函数
 * @param url:请求链接 (必须)
 * @param dataType:请求数据类型 (必须)
 * @param params:请求参数 (必须)
 * @param callback:回调函数(必须)
 * @param timeout:超时时间 (可选)
 * @param showId:节点Id(可选)
 * @param isAsync:是否同步【true:异步;false:同步】 (可选)
 */
function postForm(url,dataType,formId,timeout,showId,callBack,isAsync) {
    if(!url){
        return;
    }
    if(isAsync){
        isAsync = true;
    }else if(isAsync !=false){
        isAsync = true;
    }
    $.ajax({
        type: 'post',
        url: url,
        dataType: dataType || "text",
        data: $(formId).serialize(),
        timeout: timeout || 30000,
        success: function(data) {
            if(data==='noLogin'){
                //未登录
                window.location.href="admin/login";
                return;
            }
            if(dataType == "JSON" || dataType == "json"){
                if(callBack){
                    callBack(data);
                }
            }else{
                if(showId){
                    $(showId).html("");
                    $(showId).html(data);
                }
                if(callBack){
                    callBack(data);
                }
            }
        },
        error:function(response, textStatus, errorThrown){
            if(response.responseText==='noLogin'){
                //未登录
                window.location.href="admin/login";
                return;
            }else if(response.status==408 || response.status== 504){
                jqAlert("业务处理超时");
            }else if(response.status==500){
                jqAlert("业务处理异常");
            }
        }
    });
}

/**
 * @Description:动态事件函数
 * @param method:请求方法 (必须)
 * @param url:请求链接 (必须)
 * @param dataType:请求数据类型 (必须)
 * @param params:请求参数 (必须)
 * @param callback:回调函数(必须)
 * @param timeout:超时时间 (可选)
 * @param showId:节点Id(可选)
 * @param isAsync:是否同步【true:异步;false:同步】 (可选)
 */
function postEvent(method,url,dataType,params,timeout,showId,callBack,isAsync,contentType) {
    if(!url){
        return;
    }
    if(isAsync){
        isAsync = true;
    }else if(isAsync !=false){
        isAsync = true;
    }
    $.ajax({
        type: method || "POST",
        url: url,
        data: params || {},
        cache: false,
        async:isAsync,
        dataType: dataType || "text",
        contentType : contentType || "application/x-www-form-urlencoded; charset=UTF-8",
        timeout: timeout || 30000,
        success:function(data){
            if(data==='noLogin'){
                //未登录
                window.location.href="admin/login";
                return;
            }
            if(dataType == "JSON" || dataType == "json"){
                if(callBack){
                    callBack(data);
                }
            }else{
                if(showId){
                    $(showId).html("");
                    $(showId).html(data);
                }
                if(callBack){
                    callBack(data);
                }
            }
        },
        error:function(response, textStatus, errorThrown){
            if(response.responseText==='noLogin'){
                //未登录
                window.location.href="admin/login";
                return;
            }else if(response.status==408 || response.status== 504){
                jqAlert("业务处理超时");
            }else if(response.status==500){
                jqAlert("业务处理异常");
            }
        }
    });
}

function postJson(method,url,dataType,params,timeout,showId,callBack,isAsync) {
    postEvent(method,url,dataType,params,timeout,showId,callBack,isAsync,"application/json; charset=utf-8");
}

function postUpload(url,formId,dataType,showId,callBack) {
    $(formId).ajaxSubmit({
        type: 'post',
        url: url,
        //data: {projectName: projectName}, //应该把这个去掉，要不然，值会有重复，因为form提交时已经做了一次提交了。
        //如果projectName的值为"tt",如果这个地方不去掉，那么提交接收的值变成"tt,tt"了。
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: dataType || "text",
        success: function(data) {
            if(data==='noLogin'){
                //未登录
                window.location.href="admin/login";
                return;
            }
            if(dataType == "JSON" || dataType == "json"){
                if(callBack){
                    callBack(data);
                }
            }else{
                if(showId){
                    $(showId).html("");
                    $(showId).html(data);
                }
                if(callBack){
                    callBack(data);
                }
            }
        },
        error:function(response, textStatus, errorThrown){
            if(response.responseText==='noLogin'){
                //未登录
                window.location.href="admin/login";
                return;
            }else if(response.status==408 || response.status== 504){
                jqAlert("业务处理超时");
            }else if(response.status==500){
                jqAlert("业务处理异常");
            }
        }
    });
}

/**
 * 弹出警告框
 * @param content 警告框内容
 * @param title  警告框标题
 * @param confirm 警告框关闭回调
 */
function jqAlert(content, title, confirm) {
    //$.alert({
    //    title: title || '',
    //    animation: 'RotateX',
    //    content: content,
    //    confirmButtonClass: 'btn-primary',
    //    confirm: function(){
    //        if (confirm != null) {
    //            confirm();
    //        }
    //    }
    //});
    alert(content);
}

function showJsonData(data, succFunc, failFunc, excepFunc,
                      succTitle, failTitle, excepTitle, succComfirm, failComfirm, excepComfirm) {
    if (data) {
        if (data.code===0) {
            if (succFunc) {
                succFunc(data);
            } else {
                jqAlert(data.msg, succTitle, succComfirm);
            }
        } else {
            if (failFunc) {
                failFunc(data);
            } else {
                jqAlert(data.msg, failTitle, failComfirm);
            }
        }
    } else {
        if (excepFunc) {
            excepFunc(data);
        } else {
            jqAlert("出现异常", excepTitle, excepComfirm);
        }
    }
}

function locationPage(totalNum, locationCB, errorCB) {
    var locationNum = parseInt($("#locationPageNum").val());
    if (locationNum > totalNum) {
        if (errorCB) {
            errorCB(totalNum, locationNum);
        } else {
            alert("跳转页大于总页数");
        }
    } else {
        locationCB(locationNum);
    }
}