package com.paulotrc.svcautomovel.exceptions.feign;

import com.paulotrc.svcautomovel.exceptions.ResourceException;

public class GatewayException extends ResourceException {

    private static final long serialVersionUID = 1L;
    
    public GatewayException(String code, String message, String developerMessage, String origin) {
		
		super(code, message, developerMessage, origin);
	}

    
}

