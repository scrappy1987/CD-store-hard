package com.qa.cdstore.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cdstore.rest.CDEndPoint;
import com.qa.cdstore.service.CDServices;

@RunWith(MockitoJUnitRunner.class)
public class CDEndPointTest
{
	@InjectMocks
	private CDEndPoint subject;

	private static final String MOCKSTRING = "[{\"id\": 1,\"author\": \"JK Rowling\",\"title\": \"Harry Potter\",\"genre\": \"Fantasy\",\"yearPublished\": \"1996\"}]";
	private static final String MOCK_DELETE_MESSAGE = "{\"message\": \"book sucessfully removed\"}";

	@Mock
	private CDServices mockService;

	@Test
	public void testGetAllBooksAreReturnedCorrectly()
	{
		Mockito.when(mockService.getCDs()).thenReturn(MOCKSTRING);
		String bookString = subject.read();
		Mockito.verify(mockService).getCDs();
		Assert.assertEquals(MOCKSTRING, bookString);
	}

	@Test
	public void testAddBookCallsServiceWithGivenBook()
	{
		Mockito.when(mockService.addCD(MOCKSTRING)).thenReturn(MOCKSTRING);
		String bookString = subject.read();
		Mockito.verify(mockService).addCD(MOCKSTRING);
		Assert.assertEquals(MOCKSTRING, bookString);
	}

	@Test
	public void testDeleteBookCallsDeleteServiceWithGivenId()
	{

		Mockito.when(mockService.deleteCD(Mockito.anyInt())).thenReturn(MOCK_DELETE_MESSAGE);
		String deleteMessage = subject.delete(1);
		Mockito.verify(mockService).deleteCD(1);
		Assert.assertEquals(MOCK_DELETE_MESSAGE, deleteMessage);
	}

	@Test
	public void testReplaceBookCallsEditServiceWithGivenBookAndId()
	{
		Mockito.when(mockService.updateCD(1, MOCKSTRING)).thenReturn(MOCKSTRING);
		String bookString = subject.update(1, MOCKSTRING);
		Mockito.verify(mockService).updateCD(1, MOCKSTRING);
		Assert.assertEquals(MOCKSTRING, bookString);
	}
}