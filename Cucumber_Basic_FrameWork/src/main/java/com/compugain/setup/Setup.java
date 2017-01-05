package com.compugain.setup;

public interface Setup {
	//Feature File Paths
	public final String sOBJECT_PROPERTIESPATH="/src/main/java/com/compugain/config/object.properties";
	public final String sCHROMEPATH="/src/test/resources/Browser_Binaries/Chrome/chromedriver.exe";
	public final String sIEPATH="/src/test/resources/Browser_Binaries/IE/IEDriverServer_X64.exe";
	public final String sCGTTLOGINFEATUREE="src/main/resources/cgttlogin.feature";
	public final String sCGTTMANAGETIMESHEET="src/main/resources/cgttManageTimeSheet.feature";
	public final String sSALESFORCEREGISTARTIONFEATURE="src/main/resources/Salesforce_Reg.feature";
	public final String sCARWALEFEATURE="src/main/resources/carwale.feature";
	public final String sAMAZONIN="src/main/resources/AmazonIn.feature";
	public final String sAMAZONCOM="src/main/resources/AmazonCom.feature";
	public final String sAMAZONCOMDATA="src/main/resources/AmazonComDataPassing.feature";
	public final String sAMAZONCOMBAGSEARCH="src/main/resources/AmazonComBagSearch.feature";
	public final String sYAHOO="src/main/resources/sanity/yahoo.feature";
	public final String sTATASKY="src/test/resources/Features/TataSky.feature";
	public final String sAPIUSERCREATION="src/test/resources/Features/CucumberAPI.feature";
	public final String sCUCUMBERAPI="src/main/resources/CucumberAPI.feature";
	public final String sBROWSER="chrome";
	public final String sURL="http://www.carwale.com/users/register.aspx";
	public final int INTEGER=1,STRING=2,DOUBLE=3,FLOAT=4;
	public final String sTESTDATAJSON="src/test/TestDataJSON/TestData.json";
	public String sREADDATAFROMJSON="No";
	public final String sDOWNLOADSPATH="/src/test/Downloads";
	public final String sSOURCE_REPORTSFOLDER="/test-output/html";
	public final String sOUTPUT_ZIP_FILE_REPORTS = "/BackupReports";
	public final String sOUTPUT_ZIP_FILE = sOUTPUT_ZIP_FILE_REPORTS +"/Cucumber_Reports.zip";
	public final String  sEMAILCONFIG="/src/test/resources/EmailConfig/EmailConfiguration.properties";
	public static String stestcasefile = "/src/test/resources/CucumberTestNG.xls";
	public final String sPIECHARTLOCATION="/src/test/resources/ExecutionReport.jpeg";
	public final String FAILEDCASES="/src/test/resources/FailedCases.csv";
	public final String PASSEDCASES="/src/test/resources/PassedCases.csv";
	public final String SKIPPEDCASES="/src/test/resources/SkippedCases.csv";
	public final String sEXECUTIONSTATUS="/src/test/resources/ExecutionStatus.csv";
	public final String sBARCHARTLOCATION="/src/test/resources/GroupsReport.jpeg";
	//public final String sURL="http://172.24.2.38:9090/Login.aspx";
}
