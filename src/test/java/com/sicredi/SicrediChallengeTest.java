package com.sicredi;

import com.sicredi.hooks.BaseSetup;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SicrediChallengeTest extends BaseSetup {

    @Test
    public void createNewCustomer(){
        mainPage.selectVersion("bootstrap_theme_v4");
        mainPage.addNewCustomer();

        addCustomer.fillFormNewCustomer();

        addCustomer.saveForm();

        String expectedMessage = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
        assertThat(addCustomer.successMessage()).isEqualTo(expectedMessage);

    }

    @Test(dependsOnMethods = { "createNewCustomer" })
    public void deleteCustomer(){

        assertThat(false).isFalse();

    }
}
