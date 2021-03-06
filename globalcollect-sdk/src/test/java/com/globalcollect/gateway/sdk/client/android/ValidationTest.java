package com.globalcollect.gateway.sdk.client.android;

import java.util.ArrayList;

import android.test.AndroidTestCase;

import com.globalcollect.gateway.sdk.client.android.sdk.model.validation.ValidationRuleEmailAddress;
import com.globalcollect.gateway.sdk.client.android.sdk.model.validation.ValidationRuleExpirationDate;
import com.globalcollect.gateway.sdk.client.android.sdk.model.validation.ValidationRuleFixedList;
import com.globalcollect.gateway.sdk.client.android.sdk.model.validation.ValidationRuleLength;
import com.globalcollect.gateway.sdk.client.android.sdk.model.validation.ValidationRuleLuhn;
import com.globalcollect.gateway.sdk.client.android.sdk.model.validation.ValidationRuleRange;
import com.globalcollect.gateway.sdk.client.android.sdk.model.validation.ValidationRuleRegex;
import com.globalcollect.gateway.sdk.client.android.sdk.model.validation.ValidationType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Junit Testclass which tests validation functionality 
 * 
 * Copyright 2014 Global Collect Services B.V
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidationTest extends AndroidTestCase {

	private final String emailAddressValid = "aa@bb.com";
	private final String emailAddressInvalid = "aa2bb.com";
	
	private final String expirationDateValid = "1125";
	private final String expirationDateInvalid = "0000";
	
	
	private final ArrayList<String> listEntries = new ArrayList<String>();
	private final String validListOption = "1";
	private final String invalidListOption = "a";

	private final Integer minLength = 0;
	private final Integer maxLength = 10;
	private final String validLength = "abc";
	private final String invalidLength = "abcabcabcabcabc";

	private final String validLuhnCheck = "4242424242424242";
	private final String invalidLuhnCheck = "1142424242424242";
	
	private final String validRange = "1";
	private final String invalidRange = "150";
	
	private final String regex = "\\d{2}[a-z]{2}[A-Z]{3}";
	private final String validRegex = "11atAAB";
	private final String invalidRegex = "abcabcabc";
	
	public ValidationTest() {
		
		// Fill the test listEntries
		listEntries.add("1");
		listEntries.add("2");
		listEntries.add("3");
	}
	
	
	// Test emailaddress validator
	@Test
	public void testValidEmailAddress() {
		ValidationRuleEmailAddress rule = new ValidationRuleEmailAddress("", ValidationType.EMAILADDRESS);
		assertEquals(true, rule.validate(emailAddressValid));
	}

	@Test
	public void testInvalidEmailAddress() {
		ValidationRuleEmailAddress rule = new ValidationRuleEmailAddress("", ValidationType.EMAILADDRESS);
		assertEquals(false, rule.validate(emailAddressInvalid));
	}
	

	// Test expirationdate validator
	@Test
	public void testValidExpirationDate() {
		ValidationRuleExpirationDate rule = new ValidationRuleExpirationDate("", ValidationType.EXPIRATIONDATE);
		assertEquals(true, rule.validate(expirationDateValid));
	}

	@Test
	public void testInvalidExpirationDate() {
		ValidationRuleExpirationDate rule = new ValidationRuleExpirationDate("", ValidationType.EXPIRATIONDATE);
		assertEquals(false, rule.validate(expirationDateInvalid));
	}
	

	// Test fixed list validator
	@Test
	public void testValidFixedList() {
		ValidationRuleFixedList rule = new ValidationRuleFixedList(listEntries, "", ValidationType.FIXEDLIST);
		assertEquals(true, rule.validate(validListOption));
	}

	@Test
	public void testInvalidFixedList() {
		ValidationRuleFixedList rule = new ValidationRuleFixedList(listEntries, "", ValidationType.FIXEDLIST);
		assertEquals(false, rule.validate(invalidListOption));
	}
	
	
	// Test length validator
	@Test
	public void testValidLength() {
		ValidationRuleLength rule = new ValidationRuleLength(minLength, maxLength, "", ValidationType.LENGTH);
		assertEquals(true, rule.validate(validLength));
	}

	@Test
	public void testInvalidLength() {
		ValidationRuleLength rule = new ValidationRuleLength(minLength, maxLength, "", ValidationType.LENGTH);
		assertEquals(false, rule.validate(invalidLength));
	}
	
	
	// Test luhn validator
	@Test
	public void testValidLuhn() {
		ValidationRuleLuhn rule = new ValidationRuleLuhn("", ValidationType.LUHN);
		assertEquals(true, rule.validate(validLuhnCheck));
	}

	@Test
	public void testInvalidLuhn() {
		ValidationRuleLuhn rule = new ValidationRuleLuhn("", ValidationType.LUHN);
		assertEquals(false, rule.validate(invalidLuhnCheck));
	}
	
	
	// Test range validator
	@Test
	public void testValidRange() {
		ValidationRuleRange rule = new ValidationRuleRange(minLength, maxLength, "", ValidationType.RANGE);
		assertEquals(true, rule.validate(validRange));
	}

	@Test
	public void testInvalidRange() {
		ValidationRuleRange rule = new ValidationRuleRange(minLength, maxLength,"", ValidationType.RANGE);
		assertEquals(false, rule.validate(invalidRange));
	}
	
	// Test regex validator
	@Test
	public void testValidRegex() {
		ValidationRuleRegex rule = new ValidationRuleRegex(regex, "", ValidationType.RANGE);
		assertEquals(true, rule.validate(validRegex));
	}

	@Test
	public void testInValidRegex() {
		ValidationRuleRegex rule = new ValidationRuleRegex(regex, "", ValidationType.RANGE);
		assertEquals(false, rule.validate(invalidRegex));
	}
	
	
}