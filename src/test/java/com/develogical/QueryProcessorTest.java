package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
    public void knowsAboutHorse() throws Exception {
        assertThat(queryProcessor.process("Horse"), containsString("battery"));
    }


    @Test
    public void returnsLargestNumber() throws Exception {
        assertThat(queryProcessor.process("d69e9640: which of the following numbers is the largest: 17, 412, 18"), containsString("412"));
    }

    @Test
    public void returnsPlusValue() throws Exception {
        assertThat(queryProcessor.process("bd531480: what is 5 plus 14"), containsString("19"));
    }

    @Test
    public void returnsMultipliedValue() throws Exception {
        assertThat(queryProcessor.process("bcd22a50: what is 2 multiplied by 16"), containsString("32"));
    }
}
