package sevenThunils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class unils {

    public static boolean validNumberInput(String inputString) {
        char[] inputCharArray = inputString.toCharArray();
        boolean isValid = true;

        int stackTop = inputCharArray.length - 1;
        int matchedCommaIndex = stackTop;
        int matchedDotIndex = stackTop;

        boolean hasComma = false; // if using comma as seperator
        boolean hasMatchedDot = false; // only one dot allowed

        for (stackTop = inputCharArray.length - 1; stackTop >= 0; stackTop--) {
            char ch = inputCharArray[stackTop];
            if (ch == '.') {
                if (!hasMatchedDot) {
                    int numberCountFollowingDot = matchedDotIndex - stackTop;
                    if (numberCountFollowingDot > Constants.AUD_VALUE_SCALE || numberCountFollowingDot <= 0) {
                        isValid = false;
                        break;
                    }
                    hasMatchedDot = true;
                    matchedCommaIndex = stackTop - 1;
                } else {
                    isValid = false;
                    break;
                }
            } else if (ch == ',') {
                int numberCountFollowingComma = matchedCommaIndex - stackTop;
                if (numberCountFollowingComma != 3) {
                    isValid = false;
                    break;
                }
                hasComma = true;
                matchedCommaIndex = stackTop - 1;
            } else if (!(ch <= '9' && ch >= '0')) {
                isValid = false;
                break;
            }
        }
        if (isValid && hasComma) {
            int numberCountFollowingComma = matchedCommaIndex - stackTop;
            if (numberCountFollowingComma > 3) {
                isValid = false;
            }
        }
        return isValid;
    }

    public static String listToDelimitedString(Collection stringList, String delimiter) {
        return listToDelimitedString(stringList, delimiter, false);
    }

    public static String listToDelimitedString(Collection stringList, String delimiter, boolean isUpper) {
        boolean isToReplaceSingQuoteToDoubleQuotes = delimiter.contains("'");
        StringBuffer returnString = null;
        Iterator i = stringList.iterator();
        if (i.hasNext()) {
            returnString = new StringBuffer();
            String oneItem = i.next().toString().trim();
            if (isUpper) {
                oneItem = oneItem.toUpperCase();
            }
            if (isToReplaceSingQuoteToDoubleQuotes) {
                oneItem = oneItem.replace("'", "''");
            }
            returnString.append(oneItem);
        } else
            return "";

        while (i.hasNext()) {
            returnString.append(delimiter);

            String oneItem = i.next().toString().trim();
            if (isUpper) {
                oneItem = oneItem.toUpperCase();
            }
            if (isToReplaceSingQuoteToDoubleQuotes) {
                oneItem = oneItem.replace("'", "''");
            }
            returnString.append(oneItem);
        }

        return returnString.toString();
    }
    
    public static String listToDelimitedStringTEMP(Collection stringList, String delimiter, boolean isNeedRename) {
        StringBuffer sb = new StringBuffer(1024);
        Iterator i = stringList.iterator();
        Object item = null;
        while (i.hasNext()) {
            item = i.next();
            if (item == null) {
                continue;
            }
            if (isNeedRename) {
//                sb.append(DefinedAttributesHandlerForJxcell.addRenameTagIfNeed(item.toString()));
            } else {
                sb.append(item.toString());
            }
            if (i.hasNext()) {
                sb.append(delimiter);
            }
        }

        String returnString = sb.toString();
        // trim extra delimiter in the end if the last element is null
        if (item == null && returnString.length() > 0) {
            int lastIndex = returnString.lastIndexOf(delimiter);
            returnString = returnString.substring(0, lastIndex);
        }

        return returnString;
    }


    public static String getMaxOracleInClauseByIdList(Collection idList, String columnName, String tableAlias) {
        if ((idList == null) || (idList.size() == 0)) {
            return "";
        }

        String tableAliasPrefix = "";
        if ((tableAlias != null) && !tableAlias.trim().equals("")) {
            tableAliasPrefix = tableAlias + ".";
        }

        String returnString = "";
        if (idList.size() <= 1000) {
            returnString = tableAliasPrefix + columnName + " in ( "
                    + listToDelimitedString(idList, ", ") + " ) ";
        } else {
            List subIdList = divideListIntoSublist(idList, 1000);
            for (int i = 0; i < subIdList.size(); i++) {
                List oneSubIdList = (List) subIdList.get(i);
                if (i == 0) {
                    returnString = "(" + tableAliasPrefix + columnName + " in ( "
                            + listToDelimitedString(oneSubIdList, ",") + " ) ";
                } else {
                    returnString += "  or " + tableAliasPrefix + columnName + " in ( "
                            + listToDelimitedString(oneSubIdList, ",") + " ) ";
                }
            }
            returnString += ")";
        }
        return returnString;
    }

    /**
     * Divide a list of objects into a list of sublist
     */
    public static List divideListIntoSublist(Collection objectList, int sublistMaxSize) 
    {
        // If the objectList is empty, the result is "[[]]" - A list contains an empty list.
        List returnObjectList = new ArrayList();
        if(objectList.size() <= sublistMaxSize) {
            returnObjectList.add(objectList);
        }
        else {
            List subObjectList = new ArrayList();
            Iterator iterator = objectList.iterator();
            int index = 1;
            while(iterator.hasNext()) { 
                Object o = iterator.next();
                if(!iterator.hasNext() || index >= sublistMaxSize) {
                    subObjectList.add(o);
                    returnObjectList.add(subObjectList);
                    subObjectList = new ArrayList();
                    index = 1;
                    continue;
                }
                subObjectList.add(o);
                index++;
            }
        }
        return returnObjectList;
    }




}
