package com.edu.api_srv.exception.exception;

public class DownloadDataException extends RuntimeException{

    public DownloadDataException(String source){
        super("Failed to download data from - " + source);
    }
}
