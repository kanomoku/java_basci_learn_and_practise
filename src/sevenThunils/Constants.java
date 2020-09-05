/*
 * @(#)Constants.java
 *
 * Copyright (c) 1999-2019 7thOnline, Inc.
 * 24 W 40th Street, 11th Floor, New York, NY 10018, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 7thOnline,
 * Inc. ("Confidential Information").  You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with 7thOnline.
 */
package sevenThunils;

/**
 * @version Change History:
 */
public final class Constants {
    
    public static final String PARAMETER_MAP  = "parameterMap";
    
    public static final String BUTTON_SAVE_BAR = "msave";
    public static final String BUTTON_SAVE_CLOSE_BAR = "msaveclose";
    public static final String BUTTON_POPULATE_BAR = "mpopulateoc";
    public static final String BUTTON_OPTION_BAR = "moptions";
    public static final String BUTTON_EXCEL_BAR = "mexcel";
    public static final String BUTTON_FREEZE_PANEL_BAR = "mfreezepane";
    public static final String BUTTON_INFO_BAR  = "minfo";
    public static final String BUTTON_NOTES_BAR = "mnotes";
    public static final String BUTTON_LOCAL_CUR_BAR = "mlocalcur";
    public static final String BUTTON_VIEW_BY_UNIT = "mcru_r";
    public static final String BUTTON_VIEW_BY_COST = "mcru_l";
    public static final String BUTTON_VIEW_BY_DOLLAR = "mcru_c";
    public static final String BUTTON_LOCK_BAR = "mmplock";
    public static final String BUTTON_OTB_BAR = "motb";
    public static final String BUTTON_EXCEL1_BAR = "mexcel1";
    public static final String BUTTON_EXCEL2_BAR = "mexcel2";
    public static final String BUTTON_CLOSE_BAR = "mclose";
    public static final String PANEL_NOTATION = "pnotation";
    public static final String PANEL_SPLIT = "psplit";
    public static final String BUTTON_FILTER = "mfilter";
    public static final String BUTTON_ADD_BUY_DATE = "maddbuydate";
    public static final String BUTTON_COLUMN_HIDE = "mcolumnhide";
    public static final String BUTTON_COLUMN_SHOW = "mcolumnshow";
    public static final String BUTTON_GLOBAL_PERCENTAGE = "mglobalpercentage";
    public static final String BUTTON_DELETE_SELECTEDI = "mdeleteselectedi";
    public static final String BUTTON_FLOW_PERCENTAGE = "mflowpercentage";
    public static final String BUTTON_COPY = "mcopy";
    public static final String BUTTON_COLOR_PRIORITY = "mcolorpriority";
    public static final String BUTTON_UP_GENERATE = "mupgenerate";
    public static final String BUTTON_ADD_GROUP = "maddgroup";
    public static final String BUTTON_COLOR_KEY = "mcolorkey";
    public static final String BUTTON_COLOR_FILL = "mcolorfill";
    public static final String BUTTON_ADD_REMOVE_STYLES_BAR = "mpmstyles";
    public static final String BUTTON_STOREGROUP_BAR = "mstoregroup";
    public static final String BUTTON_APPLY_GLOBAL = "mapplyglobal";
    public static final String BUTTON_APPLY_GLOBAL_DEFAULT = "mapplyglobalpanel";
    public static final String BUTTON_CLEAR_ALL = "mclearall";
    public static final String BUTTON_RELEASED = "mreleaseoc";
    public static final String BUTTON_SETTINGS = "msetup";
    
    public static final String TEMPLATE_REMOVE = "remove";
    public static final String TEMPLATE_HIDDEN = "false";
        
    public static final String QUEUE_SPREADSHEET = "queueSpreadsheet";   // assign queueName improve performance
    public static final String QUEUE_LONG_OPERATION = "queueLongOperation"; 
    public static final String QUEUE_GENERAL = "queueGeneral";
    
    public static final String CMD_UPDATE_OPTION = "updateOption";
    public static final String CMD_UPDATE_NOTES = "updateNotes";
    public static final String CMD_UPDATE_MACRO = "updateMacro";
    public static final String CMD_REVERT_OPTION_CHANGE = "revertoptionchange";
    public static final String CMD_REVERT_CHANGE = "revertchange";
    public static final String CMD_AUTO_FILL = "autoFill";
    public static final String CMD_UPDATE_SEARCH = "updateSearch";
    public static final String CMD_CANCEL_SEARCH = "cancelSearch";
    public static final String CMD_DOWNLOAD_REPORT = "downloadreport";
    public static final String CMD_SPREAD_COLOR_PRIORITY = "spreadColorPriority";
    public static final String CMD_REBUILD = "onRebuild";
    public static final String CMD_POPULATE_FLOW = "populateFlow";
    public static final String CMD_APPLY_GLOBAL_PERCENTAGE = "applyGlobalPercentage";
    public static final String CMD_POPULATE = "populate";
    public static final String CMD_UPDATE_PLAN_LOCK = "updatePlanLock";
    public static final String CMD_UPDATE_MESSAGE = "updateMessage";
    public static final String CMD_UPDATE_UI = "updateUI";
    public static final String CMD_SHOW_PROGRESS = "showProgress";
    public static final String CMD_CLEAR_PROGRESS = "clearProgress";
    public static final String CMD_SHOW_CONT_PROGRESS = "showContProgress";
    public static final String CMD_CLEAR_CONT_PROGRESS = "clearContProgress";
    public static final String CMD_SHOW_FULL_PROGRESS = "showFullProgress";
    public static final String CMD_CLEAR_FULL_PROGRESS = "clearFullProgress";
    public static final String CMD_RELEASE = "release";
    
    public final static int MAX_NUM_PER_PAGE = 50;
    public final static int PIXELS_PER_CHARACTER = 8;
    public final static int MAX_LEN_ATTR_2 = 2;
    public final static int MAX_LEN_ATTR_20 = 20;
    public final static int MAX_LEN_ATTR_30 = 30;
    public final static int MAX_LEN_ATTR_40 = 40;
    public final static int MAX_LEN_ATTR_13 = 13;
    public final static int MAX_LEN_ATTR_80 = 80;
    
    public final static String SYMBOL_UNCHECK = "\u2610";
    public final static String SYMBOL_CHECK = "\u2611";
    
    public final static String SYMBOL_RADIOCHECK_UNCHECK = "\uF10C"; //font-awesome 
    public final static String SYMBOL_RADIOCHECK_TICK = "\uF05D"; //font-awesome 
    
    public final static String SYMBOL_COLLAPSED = "\u25C4\u25BA ";
    public final static String SYMBOL_EXPANDED = "\u25BA\u25C4 ";
    public final static String SYMBOL_PLUS = "\u002B ";
    public final static String SYMBOL_MINUS = "\u002D ";
    public final static String SYMBOL_LOCKED_STRING = "\uf023";
    
    public static final String ORDERED_TEMP_SHEET_NAME_PREFIX = "adv_";
    public static final String SHEET_PROTECTION = ""; 
    
    public static final String URI = "uri";
    public static final String CONTAINER = "container";
    public static final String TIME_OUT_MSG = "timeout_msg";
    public static final String TIME_OUT = "TIME_OUT";
    public static final String PARAM_MSG = "param_msg";
    public static final String LOGGED_OUT_MESSAGE = "Logged out message";
    
    public static final String LISTENER= "listener";
    public static final String EVENT = "event";
    public static final String POPUP_PANEL_VAL= "popup_panel_val";
    public static final String POPUP_PANEL = "popup_panel";
	public static final String POPUP_PANEL_PARAM = "popup_panel_param";
	public static final String NEWEST_POPUP_PANEL = "newest_popup_panel";

    public static final  int DEFAULT_TIME_OUT = 20;
    
    public static final String fDefaultServletFileName = "InternationalizationServlet";
    public static final String fDefalutAppletFileName = "InternationalizationApplet";
    
    public static final String TOGGLED = "toggled";
    public static final String CUR = "cur";
    public static final String NOT_USD = "notUSD";
    public static final String LOCKED_NODE = "locked-node";
    public static final String MENUITEM_OPEN = "opened";
    
    private static final String CELL_HYPERLINK_HACK = "#\"class=\"";
    public static final String CELL_HYPERLINK_BUTTON = CELL_HYPERLINK_HACK + "btn";
    public static final String CELL_HYPERLINK_THLINK = CELL_HYPERLINK_HACK + "thlink";
    public static final String CELL_HYPERLINK_THLINK_BGBLUE = CELL_HYPERLINK_HACK + "thlinkbgblue";
    
    public static final String SECURITY_ZUL = "security.zul";
    
    public static final String CURRENT_USER = "currentuser";
    
    public static final String RENAME_HANDLER = "renamehandler";
    
    public static final String CRITERIA_PERMISSION_CACHE = "criteriapermissioncache";
    
    public static final String CRITERIA_ITEM_PLANNING_CRITERIA   = "criteriaitemplanningcriteria";
    
    public static final String USE_DEPT_LEVEL_PERMISSION = "usedeptlevelpermission";
    
    public static final String FREEZE_COLUMN_PREFIX = "01000-";
    
    public static final String DOOR_INFO_SHEET_NAME = "Account Group";
    
    //Constants for DoorInfoOptionModel
    public static final int UPOFFSET = -1;
    public static final int DOWNOFFSET = 1;
    public static final int TOPOFFSET = -999;
    public static final int BOTTOMOFFSET = 999;
    
    public static final int CLASS_SUMMARY=-1;
    public static final int GROUP_SUMMARY=-2;
    public static final double HALF_OF_ONE_UNIT = 0.5;
    public static final int AUD_VALUE_SCALE = 6;
    
    public static final String OPTION = "option";
    public static final String BUILDER = "builder";

    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String TOP = "top";
    public static final String BOTTOM = "bottom";
    
    //Constants for fiscal year option
    // 0 : Calendar Year -1 ; 1:Calendar Year; 2: Calendar Year +1
    public static final int FISCAL_YEAR_OPTION_CALENDAR_MINUS_ONE = 0; 
    public static final int FISCAL_YEAR_OPTION_CALENDAR = 1;
    public static final int FISCAL_YEAR_OPTION_CALENDAR_PLUS_ONE = 2;
    
    public static final String VIEW_BY_GROUP = "[-$-Group-$-]";
    public static final String VIEW_BY_CATEGORY = "[-$-Category-$-]";
    public static final String VIEW_BY_CLASSIFICATION = "[-$-Class-$-]";
    public static final String VIEW_BY_FABRICATION = "[-$-Production Type-$-]/[-$-Fabrication-$-]";
    
    public static final int VIEW_BY_GROUP_KEY = 1;
    public static final int VIEW_BY_CATEGORY_KEY = 2;
    public static final int VIEW_BY_CLASSIFICATION_KEY = 3;
    public static final int VIEW_BY_FABRICATION_KEY = 4;
    
    public static final String[] WORKSHEET_VIEW_BY_LIST = {VIEW_BY_GROUP, VIEW_BY_CATEGORY, VIEW_BY_CLASSIFICATION, VIEW_BY_FABRICATION};
    public static final int[] WORKSHEET_VIEW_BY_KEY_LIST = {VIEW_BY_GROUP_KEY, VIEW_BY_CATEGORY_KEY, VIEW_BY_CLASSIFICATION_KEY, VIEW_BY_FABRICATION_KEY};
    
    public static final int NOTES_MAXLENGTH_DEFAULT = 512;

    public static final String HTMLSPACE_UNICODE = "\\u00A0";
    public static final String SPACE = " ";
    public static final String HTMLSPACE = "&nbsp;";
    public static final String COMMA_SYMBOL = ",";
    public static final String EXCEL_SELECTION_START_FLAG = "$";
    
    public static final String DASH_SYMBOL="-";
    public static final String VALIDATE_EDIT_VALUE   ="0";
    public static final String PERCENT_SYMBOL="%";
    public static final String DOT_SYMBOL=".";
    public static final String NEGATIVE_REGEX = "^(\\-)\\d+(\\.\\d+)?$";

    public static final String DATE_FORMAT_MMDDYYYY ="MM/dd/yyyy";
    public static final String SELECTED_REPORT = "selectedReport";
    public static final int DEFAULT_WIDTH_PIX = 15;
    public static final int MAX_NUM_OF_TITILE_LINES = 3;
    public static final String EXPAND_TITLE = "+";
    public static final String COLLAPSE_TITLE = "-";
    
    public static final int ACTION_ON_STOP_EDIT = 1;
    public static final int ACTION_ON_COPY = 2;
    public static final int ACTION_ON_CUT = 3;
    public static final int ACTION_ON_PASTE = 4;
    public static final int ZK_BACKSPACE_EVENT_CODE = 8;
    public static final String IS_CUT = "is_cut";
    public static final String FAKESTOPEDITINGEVENT= "fakeStopEditingEvent";
    public static final String DEFAULT_FONT = "Arial";
    public static final int DEFAULT_FONT_SIZE = 9;
    public static final int PIXELS_FOR_ADJUSTMENT = 8;
    public static final int MAX_LEN_PER_COLUMN = 45;
    public static final int MAX_PIXELS_PER_COLUMN = MAX_LEN_PER_COLUMN * PIXELS_PER_CHARACTER;
    public static final int  ACTION_ON_CHANGE_CHECKBOX = 6;
    
    public static final String SPACE_STRING = " ";
    public static final String UNDERLINE = "_";
    public static final String PREFIX_RENAME = "rn_";
}
