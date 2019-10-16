package com.phonebookhw;

import java.util.*;

public class PhoneBook {
  private Map<String, List<String>> map;

  public PhoneBook(Map<String, List<String>> map) {
    this.map = map;
  }

  public PhoneBook() {
    this(new LinkedHashMap<>());
  }

  public void add(String name, String phoneNumber) {
    ArrayList<String> phonebook = new ArrayList<>();
    phonebook.add(phoneNumber);
    map.put(name, phonebook);
  }

  public void addAll(String name, String... phoneNumbers) {
    ArrayList<String> phonebook = new ArrayList<>();
    phonebook.addAll(Arrays.asList(phoneNumbers));
    map.put(name, phonebook);
  }

  public void remove(String name) {
    ArrayList<String> phonebook = new ArrayList<>();
    phonebook.remove(name);
    map.put(name, phonebook);
  }

  public Boolean hasEntry(String name) {
    return map.containsKey(name);
  }

  public List<String> lookup(String name) {
    return map.get(name);
  }

  public String reverseLookup(String phoneNumber) {
    List<String> phonebook = new ArrayList<>();
    for (String name : map.keySet()) {
      phonebook = lookup(name);
      if(phonebook.contains(phoneNumber))
        return name;
    }
    return null;
  }

  public String getAllContactNames() {
      return String.valueOf(map);
  }

  public Map<String, List<String>> getMap(){
    return this.map;
  }
}

