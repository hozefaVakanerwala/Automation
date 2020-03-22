package resources;

import java.util.ArrayList;
import java.util.List;

public class Globals {
    public static String TEST_URL = "";
    public static String TEST_NAME = ""; //Name of test currently in execution
    public static List<String> TASKS = new ArrayList<String>(); // Tasks numbers for a single Service Order
    public static int CURRENT_TASK_COUNT = 1;
    public static String CURRENT_SO_STATUS = "";
    public static String CURRENT_TASK_STATUS = "";
    public static String SO_NUMBER = "";
    public static String TASK_ADDRESS = "";
    public static String CURRENT_ACTION = "None"; //Default: None
    public static List<String> ETAM_CLAIMS = new ArrayList<String>(); //ETA Mobile Claims and the quantity
    public static List<String> SN_CLAIMS = new ArrayList<String>(); //Service Now Claims and the quantity
    public static List<String> BS_CLAIMS = new ArrayList<String>(); //Billing Services Claims and the quantity
    public static String CONVERSATION_ID = "";
    public static String MESSAGEID = "";
    public static List<String> ACTIVITY = new ArrayList<String>(); // FSD Tasks numbers for a single Service Order
    public static int CURRENT_ACTIVITY_COUNT = 1;
    public static String CURRENT_ACTIVITY = "";
    public static String CURRENT_ACTIVITY_STATUS = "";
    public static List<String> XML_MANDATORY_CHECK = new ArrayList<String>(); // FSD Tasks numbers for a single Service Order
    public static String PCR_CODE = "";
    public static String VERSION = "";
    public static String RESCH_REASON_CODE = "";

    public static String ENVIRONMENT = ""; ///t est/uat/dev
    public static String TECHNICIAN_NAME = ""; //name of tech the Task is assigned to
    public static String TOW_NO = "";
    public static String WOR_NO = ""; //Parent WOR number
    public static String WOR_NO_CHILD = ""; //Child WO number
    public static String CURRENT_TASK = ""; //Activity TASK-OM number
    public static String TC_TYPE = ""; //Define type of test case. e.g.: FTTP/FTTB/FTTN/General/HFC etc.
    public static String WOR_TYPE = ""; //Define type of Work Order. e.g.: STDActivation/ServiceAssurance/NetworkAssurance/Class1Aerial/PreScope etc.
    public static String MPS_ID = "";
    public static String APPOINTMENT_START_DATE = "";
    public static String AUDITOR_TYPE = "FS Field";
    public static String AUDIT_NO = "";
}
