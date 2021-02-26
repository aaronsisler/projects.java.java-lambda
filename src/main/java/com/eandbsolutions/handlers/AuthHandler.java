package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AuthHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {
    private Logger logger;

    public AuthHandler() {
        logger = LogManager.getLogger(getClass());
    }

    public Map<String, Object> handleRequest(Map<String, Object> event, Context context) {
        logger.info(event);
        Map<String, String> headers = (Map<String, String>) event.get("headers");
        String token = (String) headers.get("Authorization");

        logger.info(token);
        String resource = (String) event.get("methodArn");
        String principalId = "123";
        switch (token) {
            case "Bearer Allow":
                return generatePolicy(principalId, "Allow", resource);
            case "Bearer Deny":
                return generatePolicy(principalId, "Deny", resource);
            case "unauthorized":
                throw new RuntimeException("Unauthorized");
            default:
                throw new RuntimeException("fail");
        }
    }

    private Map<String, Object> generatePolicy(String principalId, String effect, String resource) {
        Map<String, Object> authResponse = new HashMap<>();
        authResponse.put("principalId", principalId);
        Map<String, Object> policyDocument = new HashMap<>();
        policyDocument.put("Version", "2012-10-17"); // default version
        Map<String, String> statementOne = new HashMap<>();
        statementOne.put("Action", "execute-api:Invoke"); // default action
        statementOne.put("Effect", effect);
        statementOne.put("Resource", resource);
        policyDocument.put("Statement", new Object[]{statementOne});
        authResponse.put("policyDocument", policyDocument);
        if ("Allow".equals(effect)) {
            Map<String, Object> context = new HashMap<>();
            context.put("key", "value");
            context.put("numKey", Long.valueOf(1L));
            context.put("boolKey", Boolean.TRUE);
            authResponse.put("context", context);
        }
        return authResponse;
    }
}