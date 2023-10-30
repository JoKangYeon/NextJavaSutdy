package ch12_exception;

public class BizException extends  Exception{

    private int errCode;

    public BizException(int errCode, String msg){
        super(msg);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }



}
