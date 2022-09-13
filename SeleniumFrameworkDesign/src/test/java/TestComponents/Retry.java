package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count=0;
    int maxTry=1;
    @Override
    public boolean retry(ITestResult result) { //de ficare data cand un test da fail revine aici
        if(count<maxTry)
        {   count++;
            return true;

        }

        return false;
    }
}
