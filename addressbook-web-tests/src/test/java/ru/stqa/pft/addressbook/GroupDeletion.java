package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletion extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}
