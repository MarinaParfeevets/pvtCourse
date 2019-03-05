package core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.runners.Suite;

@RunWith(Suite.class)
@SuiteClasses(value = { TestIncommingLetters.class, TestNewLetter.class })
public class TestSuite {

}
