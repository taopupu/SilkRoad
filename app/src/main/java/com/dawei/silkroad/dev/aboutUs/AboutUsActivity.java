package com.dawei.silkroad.dev.aboutUs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.about_us));
        onBack(get(R.id.title_back));
        TextView tv_content = get(R.id.tv_content);
        tv_content.setText("           丝路汇是一家致力于互联网与实体店线上线下交易的专业文化产业平台，是一家由政府主导的文化产业类的跨境交易电子商务平台,由西安高新大渭文化科技商贸有限公司进行运营。\n" +
                "丝路汇即将开设8个功能板块，即开通艺术家官网、在线开店、国际文化、艺术鉴赏、私人订制、在线拍卖、跨境交易、创业孵化。以及e丝绸之路、精品门店、特色中国等主类导航，包括了民族服饰、特色餐饮、主题旅游、工艺礼品、珠宝玉石、书画作品、珍品藏品、 非遗文化等文化商品类别。\n" +
                "如果您有作品需要出售不管是艺术家还是店铺都可以入驻我们平台。\n" +
                "欢迎您致电：029-89568973  了解我们。\n");
    }
}
