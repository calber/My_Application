package main.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import com.example.myapplication.app.MainActivity;

public class ExampleTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public ExampleTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();


    }

    @SmallTest
    public void testSize() throws Exception {

        MainActivity a = getActivity();

        assertEquals(8, a.getItems().length);

    }
}