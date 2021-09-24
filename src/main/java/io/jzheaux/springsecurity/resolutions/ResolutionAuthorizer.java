package io.jzheaux.springsecurity.resolutions;

import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component("post")
public class ResolutionAuthorizer {

    public  boolean filter(MethodSecurityExpressionOperations operations){
        if(operations.hasRole("ADMIN")){
            return true;

        }
        String name= operations.getAuthentication().getName();
        Resolution resolution= (Resolution) operations.getFilterObject();
        return  resolution.getOwner().equals(name);
    }



}
