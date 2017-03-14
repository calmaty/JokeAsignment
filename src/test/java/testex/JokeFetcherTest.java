/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.arrayWithSize;
import org.junit.Assert;
import static org.mockito.BDDMockito.given;
import testex.jokefetching.ChuckNorris;
import testex.jokefetching.EduJoke;
import testex.jokefetching.FetcherFactory;
import testex.jokefetching.IFetcherFactory;
import testex.jokefetching.IJokeFetcher;
import testex.jokefetching.Moma;
import testex.jokefetching.Tambal;

/**
 *
 * @author Legendslayer
 */
@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {

    @Mock
    IDateFormatter iface;
    @Mock
    Moma moma;
    @Mock
    ChuckNorris chuck;
    @Mock
    EduJoke edu;
    @Mock
    Tambal tambal;
    @Mock
    JokeFetcher jfm;
    @Mock
    IFetcherFactory factory;

    public JokeFetcherTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() {
        List<IJokeFetcher> fetchers = Arrays.asList(edu, chuck, moma, tambal);
        when(factory.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal")).thenReturn(fetchers);
        List<String> types = Arrays.asList("EduJoke", "ChuckNorris", "Moma", "Tambal");
        when(factory.getAvailableTypes()).thenReturn(types);
        jfm = new JokeFetcher(iface, factory);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAvailableTypes method, of class JokeFetcher.
     */
    @Test
    public void getAvailableTypesTest() throws Exception {
        List<String> types = factory.getAvailableTypes();
        Assert.assertEquals(4, types.size());
    }

    @Test
    public void testGetAvailableTypes() {
        FetcherFactory ff = new FetcherFactory();
        List<String> expResult = Arrays.asList("eduprog", "chucknorris", "moma", "tambal");
        List<String> result = ff.getAvailableTypes();
        assertEquals(expResult, result);
    }

    @Test
    public void checkIfValidToken() {
        String jokeTokens = "chucknorris";
        boolean check = jfm.isStringValid(jokeTokens);
        assertTrue(check);
    }

    @Test
    public void getJokesMethod() throws JokeException {

        given(iface.getFormattedDate(eq("Europe/Copenhagen"),
                anyObject())).willReturn("13 Mar 2017 05:25 PM");
        Assert.assertThat(jfm.getJokes("eduprog,chucknorris,chucknorris,moma,tambal", "Europe/Copenhagen")
                .getTimeZoneString(), is("13 Mar 2017 05:25 PM"));

    }

    @Test
    public void ChuckNorrisTest() throws Exception {
        given(chuck.getJoke()).willReturn(new Joke("", ""));
        Assert.assertThat(chuck.getJoke().getJoke(), is(""));
        Assert.assertThat(chuck.getJoke().getReference(), is(""));
    }

    @Test
    public void MomaTest() throws Exception {
        given(moma.getJoke()).willReturn(new Joke("", ""));
        Assert.assertThat(moma.getJoke().getJoke(), is(""));
        Assert.assertThat(moma.getJoke().getReference(), is(""));
    }

    @Test
    public void TambalTest() throws Exception {
        given(tambal.getJoke()).willReturn(new Joke("", ""));
        Assert.assertThat(tambal.getJoke().getJoke(), is(""));
        Assert.assertThat(tambal.getJoke().getReference(), is(""));
    }

    @Test
    public void EduJokeTest() throws Exception {
        given(edu.getJoke()).willReturn(new Joke("", ""));
        Assert.assertThat(edu.getJoke().getJoke(), is(""));
        Assert.assertThat(edu.getJoke().getReference(), is(""));
    }

    @Test
    public void getJokesMethodx() throws JokeException {
          
        given(iface.getFormattedDate(eq("Europe/Copenhagen"),
              anyObject())).willReturn("13 Mar 2017 05:25 PM");
        Assert.assertThat(jfm.getJokes("eduprog,chucknorris,chucknorris,moma,tambal", "Europe/Copenhagen")
              .getTimeZoneString(), is("13 Mar 2017 05:25 PM"));

        verify(iface, times(1)).getFormattedDate(anyString(), any());
        verify(factory, times(1)).getJokeFetchers(anyString());
    }
}
