package main.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import com.example.myapplication.app.DetailActivity;


public class ExampleDetail extends ActivityUnitTestCase<DetailActivity> {

    private DetailActivity a;

    public ExampleDetail() {
        super(DetailActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        Intent intent = new Intent(getInstrumentation().getTargetContext(), DetailActivity.class);
        intent.putExtra("item","blabla");
        startActivity(intent, null, null);
        getActivity();

    }

    @SmallTest
    public void testIntent() throws Exception {

        assert getStartedActivityIntent().getStringExtra("item").equals("blabla");
    }


}