package eventbus;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.godlike.arouter.ArouterConstance;
import com.james.godlike.R;
import com.james.godlike.databinding.EventActivityBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Route(path = ArouterConstance.EVENT_PATH)
public class EventPrcActivity extends AppCompatActivity {
    EventActivityBinding eventActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventActivityBinding = DataBindingUtil.setContentView(this, R.layout.event_activity);
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true)
    public void onStiky(JamesEvent jamesEvent) {
        eventActivityBinding.btnEvent.setText(jamesEvent.getMessage());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
