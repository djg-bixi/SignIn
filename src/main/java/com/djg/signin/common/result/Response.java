package com.djg.signin.common.result;
import lombok.Data;

import java.io.Serializable;

/**
 * @NAME: SignService
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    private T result;

    private String code;
    private String message;
    private Boolean success=true;

    public static Response getResponse(){
        return new Response();
    }

    public Response() {
    }

    public Response(T result) {

        this.result = result;
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(String code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }
    public void setResp(String code, String message){
        this.code = code;
        this.message = message;
    }
    public void setResp(String code, String message,Boolean success){
        this.code = code;
        this.message = message;
        this.success = success;
    }

}
