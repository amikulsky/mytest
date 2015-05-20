/**
 * 
 */
package mytest.parser;

import java.text.ParseException;

import mytest.api.Record;

/**
 * Input String parser
 * @author mikulsky
 */
public interface Parser {
    /**
     * parses input string
     * @param s input string
     * @throws ParseException if input structure is ill-formed
     */
    Record parse(String s) throws ParseException;
}
