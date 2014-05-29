package main.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;
import com.example.myapplication.app.DetailActivity;
import com.example.myapplication.app.MainActivity;
import com.example.myapplication.app.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


public class ExampleTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity a;

    public ExampleTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(false);
        a = getActivity();

    }

    @SmallTest
    public void testSize() throws Exception {
        assertEquals(8, a.getItems().length);
    }

    @SmallTest
    public void testEspresso() throws Exception {
        onView(withId(R.id.id)).check(matches(withText("Hello world!")));

    }

    public void testist() throws Exception {
        Instrumentation.ActivityMonitor monitor = getInstrumentation().
                addMonitor(DetailActivity.class.getName(), null, false);

        onView(allOf(withText("tre"))).perform(click());
        DetailActivity startedActivity = (DetailActivity) monitor.waitForActivityWithTimeout(2000);
        assertNotNull(startedActivity);

    }

    public void testist2() throws Exception {
        Instrumentation.ActivityMonitor monitor = getInstrumentation().
                addMonitor(DetailActivity.class.getName(), null, false);

        onView(allOf(withText("tre"))).perform(click());
        DetailActivity startedActivity = (DetailActivity) monitor.waitForActivityWithTimeout(2000);

        TextView textView = (TextView) startedActivity.findViewById(R.id.text);
        assertEquals("Error","tre",textView.getText().toString());

    }

}