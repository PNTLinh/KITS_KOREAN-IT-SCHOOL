package com.topcit.aims.aims.dto.reponse;

import java.time.LocalDateTime;

public class ErrorReponse {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private Boolean status;
    public ErrorReponse(){
        this.timestamp = timestamp;
        this.message= message;
        this.path = path;
        this.status = status;
    }
}
