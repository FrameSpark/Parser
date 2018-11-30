package com.FrameSpark.Parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void solution() {
        Parser p = new Parser();
        double t = p.solution("(1+2)*3");

        assertEquals(t, 9,0);
        t = p.solution("(1-2)*5");
        assertEquals(t, -5,0);






        }
    }
