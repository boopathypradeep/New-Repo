package com.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features="src\\test\\resource\\sample.feature",glue="com.stepdef")
public class Runner {
	private TestNGCucumberRunner runner;
	
@BeforeClass(alwaysRun=true)
public void setup() {
	runner= new TestNGCucumberRunner(this.getClass());

}
@Test(groups="cucumber", description="runs cucucmber feature file",dataProvider="features")
public void feature(CucumberFeatureWrapper cucumberFeature) {
runner.runCucumber(cucumberFeature.getCucumberFeature());	

}
@DataProvider(name="features")
private Object[][] features() {
	return runner.provideFeatures();

}
@AfterClass(alwaysRun=true)
public void tearDownClass() {
	runner.finish();

}
}

