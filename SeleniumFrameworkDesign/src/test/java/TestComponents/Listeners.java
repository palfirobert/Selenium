package TestComponents;


import Resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentReports extent= ExtentReporterNG.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest>extentTest=new ThreadLocal(); //in cazul rularii paralele sa nu fie concurenta //sa fie fiecare test ope un thread
    @Override
    public void onFinish(ITestContext arg0) {
        extent.flush();

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {

        //test.fail(result.getThrowable());
        extentTest.get().fail(result.getThrowable());
        String filePath = null;
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            filePath=getScreenshot(result.getMethod().getMethodName(),driver);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filePath);
        extentTest.get().addScreenCaptureFromPath(result.getMethod().getMethodName()+".png",result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);//unique thread id

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        extentTest.get().log(Status.PASS,"Test Passed");

    }

}
