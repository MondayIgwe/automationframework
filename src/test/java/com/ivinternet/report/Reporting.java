package com.ivinternet.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.IOException;
import static com.ivinternet.baseTest.Base.driver;
import static com.ivinternet.support.CommonUtils.*;

// This is a Listener class
public class Reporting extends TestListenerAdapter {
    public ExtentSparkReporter extentSparkReporter_camera_device; // the camera device recording and saving the events reports
    public ExtentReports extentReports_human_reporter; // lady or man with the microphone who gives the report and all events happening at the scene of crime
    public ExtentTest logger_camera_guy; // is the camera guy

    @Override
    public void onStart(ITestContext testContext) {
        String timestamp = getDate();
        String testName = "Test-Report" + timestamp + ".html";

        // The file that will hold the data for reporting
        try {
            extentSparkReporter_camera_device = new ExtentSparkReporter(getSystemProperty("test-output") + testName);
            extentSparkReporter_camera_device.loadXMLConfig("extent-config.xml");
            extentSparkReporter_camera_device.config().setDocumentTitle("e banking automation");
            extentSparkReporter_camera_device.config().setReportName("Functional Test Report");
            extentSparkReporter_camera_device.config().setTheme(Theme.DARK);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Extentreport
        extentReports_human_reporter = new ExtentReports();
        extentReports_human_reporter.attachReporter(extentSparkReporter_camera_device);
        extentReports_human_reporter.setSystemInfo("Host name", "localhost");
        extentReports_human_reporter.setSystemInfo("Environment", "QA");
        extentReports_human_reporter.setSystemInfo("Monday", "King");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        logger_camera_guy = extentReports_human_reporter.createTest(tr.getName());
        logger_camera_guy.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logger_camera_guy = extentReports_human_reporter.createTest(tr.getName());
        logger_camera_guy.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        // If failed, then take screenshot
       // String screenshot = getSystemProperty("screenshots") + tr.getName() + ".png";
        try {
            captureScreenshot(driver, tr.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try {
//            //File screenshotImage = new File(screenshot);
//
//            if (screenshotImage.exists()) {
//                logger_camera_guy.fail("Failed " + tr.getName() + logger_camera_guy.addScreenCaptureFromPath(screenshot));
//            } else {
//                if ((screenshotImage.createNewFile()))
//                    logger_camera_guy.fail("Failed " + tr.getName() + logger_camera_guy.addScreenCaptureFromPath(screenshot));
//
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger_camera_guy = extentReports_human_reporter.createTest(tr.getName());
        logger_camera_guy.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extentReports_human_reporter.flush();
    }
}
