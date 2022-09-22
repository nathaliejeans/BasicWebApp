package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("JKN"));
    }

    @Test
    public void isMe() throws Exception {
        assertThat(queryProcessor.process("nathalie"), containsString("Jeans"));
    }

    @Test
    public void addition() throws Exception {
        assertThat(queryProcessor.process("What is 2012 plus 2014"), 
        containsString("4026"));
    }

    @Test
    public void mult1() throws Exception {
        assertThat(queryProcessor.process("What is 2018 multiplied by 209"), 
        containsString("421762"));
    }

    @Test
    public void mult2() throws Exception {
        assertThat(queryProcessor.process("What is 201 multiplied by 204"), 
        containsString("41004"));
    }

}
