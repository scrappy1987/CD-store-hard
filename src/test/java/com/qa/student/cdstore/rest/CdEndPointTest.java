package com.qa.student.cdstore.rest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.student.cdstore.rest.CDEndPoint;
import com.qa.student.cdstore.service.CdService;

@RunWith(MockitoJUnitRunner.class)
public class CdEndPointTest {

	@InjectMocks
	private CDEndPoint subject;

	private static final String MOCKSTRING = "[{\"id\": 1,\"artist\": \"JK Rowling\",\"song\": \"Harry Potter\",\"genre\": \"Fantasy\"}]";

	private static final String MOCK_DELETE_MESSAGE = "{\"message\": \"cd sucessfully removed\"}";

	@Mock
	private CdService mockService;

	@Test
	public void testGetAllCDsAreReturnedCorrectly() {
		Mockito.when(mockService.getAllCDs()).thenReturn(MOCKSTRING);
		String cdString = subject.getCDsAsJson();
		Mockito.verify(mockService).getAllCDs();
		Assert.assertEquals(MOCKSTRING, cdString);
	}

	@Test
	public void testAddCDCallsServiceWithGivenBook() {
		Mockito.when(mockService.addNewCDs(MOCKSTRING)).thenReturn(MOCKSTRING);
		String cdString = subject.addNewCDToMap(MOCKSTRING);
		Mockito.verify(mockService).addNewCDs(MOCKSTRING);
		Assert.assertEquals(MOCKSTRING, cdString);
	}

	@Test
	public void testDeleteCDCallsDeleteServiceWithGivenId() {

		Mockito.when(mockService.deleteCD(Mockito.anyInt())).thenReturn(MOCK_DELETE_MESSAGE);
		String deleteMessage = subject.deleteCDFromCDStore(1);
		Mockito.verify(mockService).deleteCD(1);
		Assert.assertEquals(MOCK_DELETE_MESSAGE, deleteMessage);
	}

	@Test
	public void testReplaceCDCallsEditServiceWithGivenCDAndId() {
		Mockito.when(mockService.replaceCD(1, MOCKSTRING)).thenReturn(MOCKSTRING);
		String cdString = subject.replaceCDFromCDStore(1, MOCKSTRING);
		Mockito.verify(mockService).replaceCD(1, MOCKSTRING);
		Assert.assertEquals(MOCKSTRING, cdString);
	}

}
