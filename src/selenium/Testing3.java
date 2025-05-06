package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	SoftAssert softAssert = new SoftAssert();
	
  @Test (priority = 1 , groups = {"smoke","sanity"})//create new user test@test.com
  public void createUser() {
	  
		System.out.println("I am in hometest");
		System.out.println("Before 1st assert");
		Assert.assertTrue(4>3, "Verifing Element");
		System.out.println("after 1st assert");
		System.out.println("Before 2nd assert");
		Assert.assertEquals("abc","abc1");
		System.out.println("After 2nd assert");
  }
  
  //in jaunit we use try catch wit herror collecter to run code evan after assertion fial
  //but in Test NG we have in build class (	SoftAssert softAssert = new SoftAssert();)
  
  @Test(priority = 2, dependsOnMethods ="createUser") //edit user test@test.com
  public void editUser() {
	  
		System.out.println("Before 1st assert");
		softAssert.assertTrue(4>3, "Verifing Element");
		System.out.println("after 1st assert");
		System.out.println("Before 2nd assert");
		softAssert.assertAll(); // similar to errorcollector in Junit
  }
  
  @Test (priority = 3, dependsOnMethods ="editUser") //delete user test@test.com
  public void deleteUser() {
	  System.out.println("I am in end test");
		System.out.println("Before 1st assert");
		softAssert.assertTrue(4>3, "Verifing Element");
		System.out.println("after 1st assert");
		System.out.println("Before 2nd assert");
		softAssert.assertEquals("abc","abc1");
		System.out.println("After 2nd assert");
		softAssert.assertAll();
  }
  
}
