
package sevenThunils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *  Parses strings similar to java.util.StringTokenizers, but with some notable
 *  differences.
 *   1) tokens are considered to be a single occurance of the delimiter character.
 *      Multiple consecutive delimiters are considered to be separating empty
 *      strings.
 *   2) Delimiters are used to separate tokens.  If a delimiter exists at the
 *      begining (or end) of a string, then an empty string is considered to be
 *      at the begining (or end) of the string.
 * eg:
 *  "`foo``bar`how`are you?" would tokenize to:
 *    1) (empty string)
 *    2) foo
 *    3) (empty string)
 *    4) bar
 *    5) how
 *    6) are you?
 *
 *  This object also provides several static utility functions, such as:
 *  This object will parse a string of comma delimited items and strip the
 *  spaces from the front and back of each item
 *
 *  This object has grown to include more than just tokenizing functions.  It
 *  has a couple of other string manipulation utilities.  Perhaps this class
 *  would be a good candidate for the string manipulation functions that are
 *  currently available in the EfsnClass class.  (DJC 03/14/00)
 *
 * @version Change History:
 *
 */
public class EfsnStringTokenizer {
    private String[] fTokens;
    private final String fParseString;


    /**
     * Constructs an EfsnStringTokenizer with a minimum size.  If
     * minLength is smaller than the number of tokens in parseString,
     * then the parameter has no effect.  If minLength is larger than
     * the number of tokens in parseString, then the internal array of
     * tokens is expanded and padded with empty strings at the end of
     * the array.
     */
    public EfsnStringTokenizer(String parseString, String delim, int minLength) {
        this(parseString, delim);

        if (this.countTokens() < minLength) {
            String[] temp = fTokens;

            // copy old tokens
            String[] newTokens = new String[minLength];
            int i = 0;
            for ( ; i < fTokens.length; i++) {
                newTokens[i] = fTokens[i];
            }

            // fill end with empty strings
            for ( ; i < newTokens.length; i++) {
                newTokens[i] = "";
            }

            fTokens = newTokens;
        }
    }


    public EfsnStringTokenizer(String parseString, String delim) {
        Vector tokens = new Vector();

        fParseString = parseString;

        // check for a delim at the begining of the string
        while (parseString.startsWith(delim)) {
            tokens.addElement("");
            parseString = parseString.substring(delim.length());
        }

        // now tokenize
        StringTokenizer toke = new StringTokenizer(parseString, delim, true);
        boolean lastTokenWasDelim = false;
        while (toke.hasMoreElements()) {
            String current = toke.nextToken();
            if (current.equals(delim)) {
                if (lastTokenWasDelim) {
                    tokens.addElement("");
                }
                lastTokenWasDelim = true;
            }
            else {
                tokens.addElement(current);
                lastTokenWasDelim = false;
            }
        }

        // check for a delim at the end of the string
        if (parseString.endsWith(delim)) {
            tokens.addElement("");
        }

        fTokens = new String[tokens.size()];
        tokens.copyInto(fTokens);
    }


    /**
     * Returns the number of tokens.
     */
    public int countTokens() {
        return fTokens.length;
    }


    /**
     * returns the token at index "index".  Note that the first index is 0.
     * This function will never return a null string.  Although it may return
     * an empty string.
     */
    public String getToken(int index) {
        return this.getToken(index, false);
    }


    /**
     * returns the token at index "index".  Note that the first index is 0.
     * This function will never return a null string.  Although it may return
     * an empty string.
     * @param trim - true to trim whitespace from each end of string.
     * 
     */
    public String getToken(int index, boolean trim) {
        if (index >= this.countTokens()) {
            //out of bounds
            return new String("");
        }
        if (trim)
            return fTokens[index].trim();
        else
            return fTokens[index];
    }


    public double getTokenAsDouble(int index) {
        String asString = this.getToken(index).trim();
        if (asString == null || asString.length() == 0) {
            return 0.0;
        }
        else {
            return Double.parseDouble(asString);
        }
    }

    
    public long getTokenAsLong(int index) {
        String asString = this.getToken(index);
        if (asString == null || asString.length() == 0) {
            return 0;
        }
        else {
            return Long.parseLong(asString);
        }
    }

    public int getTokenAsInteger(int index) {
        String asString = this.getToken(index);
        if (asString == null || asString.length() == 0) {
            return 0;
        }
        else {
            return Integer.parseInt(asString);
        }
    }

    public String getOriginalString() {

        return this.fParseString;
    }

    public String[] getToken(){
        return fTokens;
    }

    /**
     * Takes a comma delimited string, and returns an array of strings with
     * begining and trailing whitespace stripped out.
     */
    public static String[] tokenize(String inputString)
    {
        Vector returnVector = new Vector();
        StringTokenizer st = new StringTokenizer(inputString, ",", false);
        while (st.hasMoreTokens()) {
            String currentString = st.nextToken();
            //System.out.println(">" + currentString + "<");

            StringCharacterIterator iter = new StringCharacterIterator(currentString);
            String token = "";
            boolean wordStarted = false;
            for (char c = iter.first(); c != CharacterIterator.DONE; c = iter.next()) {
                if ( (c != '\n') && (c != ' ') || wordStarted ) {
                    token = token + c;
                    wordStarted = true;
                }
            }

            //
            iter = new StringCharacterIterator(token);
            String finalToken = "";
            wordStarted = false;
            for (char c = iter.last(); c != CharacterIterator.DONE; c = iter.previous()) {
                if ( (c != '\n') && (c != ' ') || wordStarted ) {
                    finalToken = c + finalToken;
                    wordStarted = true;
                }
            }

            returnVector.addElement(finalToken);
            
        } // end while

        String[] returnArray = new String[returnVector.size()];
        returnVector.copyInto(returnArray);

        return returnArray;
    } // tokenize()



    /**
     * Takes an array of strings, and returns them as a comma delimited string.
     * This function can be thought of as the inverse of this.tokenize()
     */
    public static String arrayToList(String[] array) {
        String returnString = "";
        if (array==null || array.length == 0) {
            returnString = "";
        }
        else if (array.length == 1) {
            returnString = array[0];
        }
        else {
            returnString = array[0];
            for (int i = 1; i < array.length; i++) {
                returnString = returnString + ", " + array[i];
            }
        }
        return returnString;
    }

    /**
     * Takes an array of strings, and returns them as a Delimiter delimited string.
     * This function can be thought of as the inverse of this.tokenize()
     * 
     */
    public static String arrayToDelimitedString (String[] array, String delimiter ) {
        if(delimiter.indexOf("'") != -1){
            return arrayToDelimitedString(array, delimiter, true);
        }
        return arrayToDelimitedString(array, delimiter, false);
    }

    public static String arrayToDelimitedString (String[] array, String delimiter , boolean isToReplaceSingQuoteToDoubleQuotes) {
        String returnString = "";
        if (array==null || array.length == 0) {
            returnString = "";
        }
        else if (array.length == 1)    {
            if (array[0] != null)   {
                returnString = array[0].trim();
                if (isToReplaceSingQuoteToDoubleQuotes) {
                    returnString = replace(returnString,"'","''");
                }
             }
        }
        else {
            for (int i = 0; i < array.length; i++) {
                String oneItem = array[i];
                if (isToReplaceSingQuoteToDoubleQuotes){
                    oneItem = replace(oneItem.trim(),"'","''");
                }
                if(i == 0){
                    returnString = returnString + oneItem.trim();
                }
                else{
                    returnString = returnString + delimiter + oneItem.trim();
                }
            }
        }
        return returnString;
    }

    public static String arrayToDelimitedString(Object[] array, String delimeter) {
        if (array==null || array.length == 0) return "";
 
        String[] strArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strArray[i] = array[i].toString();
        }
        return EfsnStringTokenizer.arrayToDelimitedString(strArray,delimeter);
    }

    /**
     * Return delimited SQL string from given String array stringList.
     *
     * @throws java.sql.SQLException if errors occur during database transaction
     *
     */
    public static String arrayToDelimitedUpperString(String[] stringList) 
    {
        StringBuilder returnString = new StringBuilder();
        if (stringList != null) {
            for (int i=0;  i<stringList.length; i++) 
            {
                String token = stringList[i];
                if (returnString.length() != 0) {
                    returnString.append(", ");
                }
                returnString.append("'"+token.toUpperCase().replace("'", "''") +"'");
            }
        }
        return returnString.toString();
    }
        
    /**
     * Return delimited bind variables from given String array stringList.  Output is "?, ?, ? ...."
     *
     * @throws java.sql.SQLException if errors occur during database transaction
     *
     */    
    public static String arrayToDelimitedBindVariables(Object[] stringList) {
       StringBuilder returnString = new StringBuilder();
       if (stringList != null) {
           for (int i=0; i<stringList.length; i++) {
               if (returnString.length() !=0 ) {
                   returnString.append(", ");
               }
               returnString.append("?");
           }
       }
       return returnString.toString();
    }
    
    /**
     * Return delimited bind variables from given list. Output is "?, ?, ? ...."
     *
     * @throws java.sql.SQLException if errors occur during database transaction
     *
     */      
    public static String listToDelimitedBindVariables(List<?> stringList) {
        StringBuilder returnString = new StringBuilder();
        if (stringList != null) {
           for (int i=0; i<stringList.size(); i++) {
               if (returnString.length() !=0 ) {
                   returnString.append(", ");
               }
               returnString.append("?");
           }
        }
        return returnString.toString();
     }
         
    
    public static String listToDelimitedString (Collection stringList, String delimiter){
        return listToDelimitedString(stringList, delimiter, false);
    }
    
    /**
     * Takes a list of strings, and returns them as a Delimiter delimited string.
     * This function can be thought of as the inverse of this.tokenize()
     * 
     */
    public static String listToDelimitedString (Collection stringList, String delimiter, boolean isUpper) {
        boolean isToReplaceSingQuoteToDoubleQuotes = delimiter.contains("'");
        StringBuffer returnString = null;
        Iterator i = stringList.iterator();
        if( i.hasNext() ) {
            returnString = new StringBuffer();
            String oneItem = i.next().toString().trim();
            if(isUpper){
                oneItem = oneItem.toUpperCase();
            }
            if(isToReplaceSingQuoteToDoubleQuotes){
                oneItem = oneItem.replace("'", "''");
            }
            returnString.append(oneItem);
        }
        else
            return "";

        while( i.hasNext() ) {
            returnString.append(delimiter);
            
            String oneItem = i.next().toString().trim();
            if(isUpper){
                oneItem = oneItem.toUpperCase();
            }
            if(isToReplaceSingQuoteToDoubleQuotes){
                oneItem = oneItem.replace("'", "''");
            }
            returnString.append(oneItem);
        }

        return returnString.toString();
    }
   
    public static String listToDelimitedString(Collection[] stringListArray){
        return EfsnStringTokenizer.listToDelimitedString(stringListArray, ",");
    }
    
    public static String listToDelimitedString(Collection[] stringListArray, String delimiter ){
        if(stringListArray == null || stringListArray.length == 0){
            return "";
        }
        Set stringSet = new HashSet();
        int noOfCollections = stringListArray.length;
        if(noOfCollections == 1){
            return EfsnStringTokenizer.listToDelimitedString(stringListArray[0], delimiter);
        }
        
        Iterator[] itrs = new Iterator[noOfCollections];
        int sizeOfCurrCollection = 0;
        for(int i = 0; i < noOfCollections; i++){
            int sizeOfPreCollection = sizeOfCurrCollection;
            sizeOfCurrCollection = stringListArray[i].size();
            if(sizeOfPreCollection != 0 && (sizeOfCurrCollection != sizeOfPreCollection)){
                return "";
            }
            itrs[i] = stringListArray[i].iterator();
        }
        
        while(itrs[0].hasNext()){
            StringBuffer oneCombStringBuffer = new StringBuffer("(");
            for(int j = 0; j < noOfCollections; j++){
                oneCombStringBuffer.append(itrs[j].next().toString());
                if(j != noOfCollections - 1){
                    oneCombStringBuffer.append(",");
                }
            }
            oneCombStringBuffer.append(")");
            stringSet.add(oneCombStringBuffer);
        }
        
        return EfsnStringTokenizer.listToDelimitedString(stringSet, delimiter);
    }
    
    /**
     * Takes an array of strings, and returns them as a comma delimited string,
     * and put "wrapper" string around each element.
     * This function can be thought of as the inverse of this.tokenize()
     */
    public static String arrayToList(String[] array, String wrapper ) {
        String returnString = "";
        if (array==null || array.length == 0) {
            returnString = "";
        }
        else if (array.length == 1) {
            if ( array[0].equals("") ) array[0] = " ";
            returnString = wrapper + array[0] + wrapper;
        }
        else {
            if ( array[0].equals("") ) array[0] = " ";
            returnString = wrapper + array[0] + wrapper;
            for (int i = 1; i < array.length; i++) {
                if ( array[i].equals("") ) array[i] = " ";
                returnString = returnString + ", " + wrapper + array[i] + wrapper;
            }
        }
        return returnString;
    }
    /**
     * Takes an array of longs, and returns them as a comma delimited string.
     * This function can be thought of as the inverse of this.tokenize()
     */
    public static String arrayToList(long[] array) {
        String returnString = "";
        if (array.length > 0) {
            returnString = String.valueOf(array[0]); // first element
            for (int i = 1; i < array.length; i++) { // all the rest
                returnString = returnString + ", " + array[i];
            }
        }
        return returnString;
    }

    /**
     * Takes an array of ints, and returns them as a comma delimited string.
     * This function can be thought of as the inverse of this.tokenize()
     */
    public static String arrayToList(int[] array) {
        String returnString = "";
        if (array.length > 0) {
            returnString = String.valueOf(array[0]); // first element
            for (int i = 1; i < array.length; i++) { // all the rest
                returnString = returnString + ", " + array[i];
            }
        }
        return returnString;
    }

    /**
     * returns an array of strings that represents the set subtraction of 
     * "a minus b"
     */
    public static String[] subtract(String[] a, String[] b) {
        if (b==null || b.length==0)
            return a;
        if (a==null || a.length==0)
            return new String[0];
            
        Vector returnVector = new Vector();
        for (int i = 0; i < a.length; i++) {
            boolean returnA = true;
            
            for (int j = 0; j < b.length; j++) {
                if ((a[i].trim().toUpperCase()).equals(b[j].trim().toUpperCase())) {
                    returnA = false;
                }                                   
            }
            
            if (returnA) {
                returnVector.addElement(a[i]);
            }
            
        }

        String[] returnArray = new String[returnVector.size()];
        returnVector.copyInto(returnArray);
        
        return returnArray;
    } // subtract()


    
    /**
     * returns an array of longs that represents the set subtraction of
     * "a minus b"
     */
    public static long[] subtract(long[] a, long[] b) {
        if (b==null || b.length==0){
            return a;
        }
        if (a==null || a.length==0)
            return new long[0];

        Vector returnVector = new Vector();
        for (int i = 0; i < a.length; i++) {
            boolean returnA = true;

            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    returnA = false;
                }
            }

            if (returnA) {
                returnVector.addElement(new Long(a[i]));
            }
        }

        long[] returnArray = new long[returnVector.size()];
        for (int i = 0; i < returnVector.size(); i++) {
            returnArray[i] = ((Long)returnVector.elementAt(i)).longValue();
        }

        return returnArray;
    } // subtract(long[], long[])


    /**
     * returns an array of longs that represents the set subtraction of
     * "a excludes b"
     */
    public static long[] subtractAll(long[] a, long b) {
        if (a==null || a.length==0)
            return new long[0];

        Vector returnVector = new Vector();
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=b) {
                returnVector.addElement(new Long(a[i]));
            }
        }

        long[] returnArray = new long[returnVector.size()];
        for (int i = 0; i < returnVector.size(); i++) {
            returnArray[i] = ((Long)returnVector.elementAt(i)).longValue();
        }

        return returnArray;
    } // subtract(long[], long[])


    public static Vector subtract(int a[], int b[]) {
        if (b==null || b.length==0)
            b = new int[0];
        if (a==null || a.length==0)
            return new Vector();

        Vector returnVector = new Vector();
        for (int i = 0; i < a.length; i++) {
            boolean returnA = true;

            for (int j = 0; j < b.length; j++) {
                if ((a[i]== b[j])) {
                    returnA = false;
                }
            }

            if (returnA) {
                returnVector.addElement(String.valueOf(a[i]));
            }

        }

        return returnVector;
    }


    /**
     * Similar to the String.replace() function.  This function allows for more
     * than just 1 character replacement.
     *
     * Change History:
     *  <4> 01/04/01 DJC  First written.
     */
    public static String replace(String orig, String oldString, String newString) {
        StringTokenizer toke = new StringTokenizer(orig, oldString, true); // true to return tokens
        StringBuffer buff = new StringBuffer();
        while (toke.hasMoreElements()) {
            String curr = toke.nextToken();
            if (oldString.equals(curr)) {
                buff.append(newString);
            }
            else {
                buff.append(curr);
            }
        }
        return buff.toString();
    }


    public static void main(String[] args) {
        String normal = "helo`world`how`are`you?";
        String abnormal = "``hello``this is the`end```";

        EfsnStringTokenizer s1 = new EfsnStringTokenizer(normal, "`");
        EfsnStringTokenizer s2 = new EfsnStringTokenizer(abnormal, "`");
        
        System.out.println("normal: " + normal);
        for (int i = 0; i < s1.countTokens(); i++) {
            System.out.println(i + ") >" + s1.getToken(i) + "<");
        }

        System.out.println("abnormal: " + abnormal);
        for (int i = 0; i <= s2.countTokens(); i++) { // index out of bounds
            System.out.println(i + ") >" + s2.getToken(i) + "<");
        }

    }


    /**
     * Returns the index at which the ids end, but the names
     * continue.  If the "names" array is not longer than the
     * "ids" array, then this function will return ids.length
     *
     * The example below would return 2:
     *  index   ids    names
     *  -----   ---    -----
     *      0   123    foo
     *      1   234    bar
     *      2     0    foobar
     *      3     0    barfoo
     *
     * this method is called by EfsnShowroom and EfsnStyleColorNew
     */
    public static int getStartIndex(String[] ids, String[] names) {
        int index = names.length;
        for (int i = 0; i < ids.length; i++) {
            if (ids[i].equals("0")
                && names[i] != null
                && names[i].length() != 0)
            {
                index = i;
                break;
            }

        } // end for

        return index;
    }

    /**
     * Takes an array of strings, and returns an array of longs.  If the string
     * array is null, this function will return a long array of length 0 (it
     * will not return null
     */
    public static long[] stringToLong(String[] stringArray) {
        if (stringArray == null)
            return new long[0];

        long[] returnArray = new long[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            returnArray[i] = Long.parseLong(stringArray[i]);
        }
        return returnArray;
    }


   /**
    *
    * @version Change History:
    * @version  <41> 06/20/13 GL  Top-Down Planning: Merge RB code into 7th. (Elvis Fu & Gavine Li)
    * @version  <33> 01/06/10 AL  First Written for EN6703: International Pricing (Local WHSL & Local MSRP).(Ada Liu)
    */
    public static String getDecimalForUnicodeChar(String unicodeString){
        String returnString = "";
        char[] charArr = unicodeString.toCharArray();
        for(int i=0;i<charArr.length;i++){
            if(i >= 1){
                returnString = returnString+"_"+Integer.toString(charArr[i]);
            }else{
                returnString = Integer.toString(charArr[i]);
            }
            
        }
        
        return returnString;
    }

   /**
    *
    * @version Change History:
    * @version  <33> 01/06/10 AL  First Written for EN6703: International Pricing (Local WHSL & Local MSRP).(Ada Liu)
    */
    public static String getCharacterUseUnicode(String unicode){        
        String[] characterArr = unicode.split("_");
        String returnString = "";
        for(int i=0;i<characterArr.length;i++){
            char charStr = (char)((Integer.valueOf(characterArr[i])).intValue());
            String str = Character.toString(charStr);
            returnString = returnString + str;
        }
        return returnString;
    }
    
   /**
    * @version Change History:
    * @version  <35> 02/21/10 AL  BUGS-8806: Change Request: Add "CAN" for Canadian dollar into the local currency dropdown list in the Retailer Profile page.(Ada Liu)
    * @version  <33> 01/06/10 AL  First Written for EN6703: International Pricing (Local WHSL & Local MSRP).(Ada Liu)
    */
    public static String getHtmlCodeOfUnicodeString(String srcString){
        String[] characterArr = srcString.split("_");
        String returnString = "";
        for(int i=0;i<characterArr.length;i++){
            String str = "&#"+characterArr[i]+";";
            returnString = returnString + str;
        }
        return returnString;
    }
    
    /**
     * split a search string to a array using the first found delimiter(comma,tab,space,return).
     * @version Change History:
     * @version <41> 03/29/11 JC  CMM-1540: Revisit. (Jack Chen)
     * @version <40> 03/30/11 EG  First Written for CMM-1540: Allow different delimiter(comma,tab,space) in style search box in RB Criteria page and Style Bank advanced search page.(Eric Gao)
     */
    public static String[] getDelimiterArray(String srcString){
        String[] returnArray = new String[0];
        if (srcString == null || srcString.trim().length() == 0 ) {
            return returnArray;   
        }
        String delimiter = getFirstDelimiter(srcString); 
        if(delimiter != null){
            returnArray = srcString.split(delimiter+"+");
        }else{
            returnArray = new String[]{srcString};
        }
        return returnArray;
    }
    
    /**
     * return the first found delimiter (comma,tab,space,return) in a search string
     * @version Change History:
     * @version <40> 03/30/11 EG  First Written for CMM-1540: Allow different delimiter(comma,tab,space) in style search box in RB Criteria page and Style Bank advanced search page.(Eric Gao)
     */
    private static String getFirstDelimiter(String srcString){
        String delimiter = null;
        String[] delimiterOptions=new String[]{","," ","\t","\n"};
        int indexMark = Integer.MAX_VALUE;
        for ( int i=0;i<delimiterOptions.length;i++ ){
            int delimiterFirstIndex = srcString.indexOf(delimiterOptions[i]);
            if (delimiterFirstIndex>=0){
                if ( delimiterFirstIndex < indexMark ) {
                    indexMark = delimiterFirstIndex;
                    delimiter = delimiterOptions[i];                
                }
            }
        }
        return delimiter;
    }

    
}