package cn.srn.web2.response;

import cn.srn.web2.errorinfo.ErrorInfo;

/**
 * Created by Winter on 2016/5/4.
 */
public class UploadFileResponse extends ResponseInfo {

    private String filePath;

    public UploadFileResponse() {

    }

    public UploadFileResponse(ErrorInfo errorInfo) {
        super(errorInfo);
        this.filePath = "";
    }

    public UploadFileResponse(ErrorInfo errorInfo, String filePath) {
        super(errorInfo);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "UploadFileResponse{" + super.toString() +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
