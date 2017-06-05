package and.utils.activity_fragment_ui;

import android.support.v4.view.ViewPager;
import android.util.Log;

/**
 * [2017] by Zone
 */

public class ViewPagerHelper {

    private int state = -1;

    public static  ViewPagerHelper addSelectPos(final ViewPager vp, final SelectPosCallback callback) {
        final ViewPagerHelper vpHelper = new ViewPagerHelper();
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, float positionOffset, int positionOffsetPixels) {
                if (vpHelper.state == -1&&callback!=null)
                    callback.selected(vp.getCurrentItem());
                vpHelper.log("onPageScrolled:" + position +
                        "\t positionOffset:" + positionOffset + "\t positionOffsetPixels:" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                vpHelper.log("onPageSelected:" + position);
                callback.selected(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                vpHelper.log("state:" + state);
                vpHelper.state = state;
            }
        });
        return vpHelper;
    }


    public interface SelectPosCallback {
        void selected(int position);
    }

    private void log(String str) {
        if (1 == 2)
            Log.i("ViewPagerUtils", str);
    }

}
