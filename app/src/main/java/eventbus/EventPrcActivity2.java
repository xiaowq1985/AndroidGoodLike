package eventbus;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.godlike.arouter.ArouterConstance;
import com.james.godlike.R;
import com.james.godlike.databinding.EventActivityBinding;

@Route(path = ArouterConstance.EVENT_PATH)
public class EventPrcActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventActivityBinding eventActivityBinding = DataBindingUtil.setContentView(this, R.layout.event_activity);

    }
}
