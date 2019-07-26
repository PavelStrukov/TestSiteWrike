/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.forWrike;

import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author Dell
 */
public class GenerateText {
    
    public static String generateEmail() {
  
        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        
        return (generatedString.toLowerCase() + "+wpt@wriketask.qaa");
    }
    
}
