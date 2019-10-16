package com.phonebookhw;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookTest{


  @Test
  public void addTest() {
      // given
      PhoneBook phoneBook = new PhoneBook();
      String name = "Joe";
      String[] phoneNumbers = {
        "302-555-4444",
        "302-555-3333",
        "302-555-2222",
        "302-555-1111",
      };

      // when
      phoneBook.add(name, String.valueOf(phoneNumbers));
      List<String> actualPhoneNumbers = phoneBook.lookup(name);
      Assert.assertEquals(Arrays.asList(phoneNumbers), actualPhoneNumbers);
    }

  @Test
  public void addAllTest() {
      // given
      PhoneBook phoneBook = new PhoneBook();
      String name = "Joe";
      String[] phoneNumbers = {
        "302-555-4444",
        "302-555-3333",
        "302-555-2222",
        "302-555-1111",
      };

      // when
      phoneBook.addAll(name, phoneNumbers);
      List<String> actualPhoneNumbers = phoneBook.lookup(name);
      Assert.assertEquals(Arrays.asList(phoneNumbers), actualPhoneNumbers);
    }


  public void removeTest() {
    PhoneBook phoneBook = new PhoneBook();
    String name = "John";
    String phoneNumber = "302-555-4545";
    phoneBook.remove(name);
    Assert.assertTrue(phoneBook.hasEntry(phoneNumber));

    phoneBook.remove(name);

    Assert.assertFalse(phoneBook.hasEntry(name));
  }

  @Test
  public void reverseLookUpTest() {
    PhoneBook phoneBook = new PhoneBook();
    String expectedName = "John";
    String phoneNumber = "302-555-4545";
    phoneBook.add(expectedName, phoneNumber);
    Assert.assertTrue(phoneBook.hasEntry(phoneNumber));

    String actualName = phoneBook.reverseLookup(phoneNumber);

    Assert.assertEquals(expectedName, actualName);
  }


  @Test
  public void testNullaryConstructor() {
    // given
    // when
    PhoneBook phoneBook = new PhoneBook();

    // then
    Assert.assertTrue(phoneBook.getMap() instanceof HashMap);
    }

  @Test
  public void testNonNullaryConstructor() {
    // given
    Map<String, List<String>> dependency = new HashMap<>();

    // when
    PhoneBook phoneBook = new PhoneBook(dependency);

    // then
    Assert.assertEquals(dependency, phoneBook.getMap());
    }
  }
