package com.sicredi;

import com.sicredi.hooks.BaseSetup;
import com.sicredi.hooks.CustomerData;
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

        addCustomer.waitForSuccessMessage(expectedMessage);

        assertThat(expectedMessage).isEqualTo(addCustomer.successMessage());

    }

    @Test(dependsOnMethods = { "createNewCustomer" })
    public void deleteCustomer(){
        mainPage.searchByCustomer(CustomerData.NAME);

        mainPage.removeFirstCustomer();

        String modalMessage = mainPage.waitForModalDialogAndReturnMessage();

        mainPage.confirmDeleteCustomer();

        String expectedMessageModal = "Are you sure that you want to delete this 1 item?";
        String expectedMessage = "Your data has been successfully deleted from the database.";


        assertThat(expectedMessageModal).isEqualTo(modalMessage);
        assertThat(expectedMessage).isEqualTo(mainPage.returnSuccesMessage());


    }
}
