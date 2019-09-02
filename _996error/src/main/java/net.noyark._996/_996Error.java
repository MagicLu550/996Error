package net.noyark._996;

/**
 * 当老板强制你996的时候,可以在项目中保留这个异常
 * 996Error
 * 这里的996是不能不处理的
 * @author magiclu550
 */
public class _996Error extends Error{

    public _996Error() {
    }

    public _996Error(String message) {
        super(message);
    }

    public _996Error(String message, Throwable cause) {
        super(message, cause);
    }

    public _996Error(Throwable cause) {
        super(cause);
    }

    public _996Error(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
