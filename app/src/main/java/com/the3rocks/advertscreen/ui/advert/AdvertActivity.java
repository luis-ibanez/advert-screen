package com.the3rocks.advertscreen.ui.advert;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.the3rocks.advertscreen.AdvertApplication;
import com.the3rocks.advertscreen.R;
import com.the3rocks.advertscreen.di.components.AdvertComponent;
import com.the3rocks.advertscreen.di.components.DaggerAdvertComponent;
import com.the3rocks.advertscreen.di.modules.ActivityModule;
import com.the3rocks.advertscreen.domain.model.Attribute;
import com.the3rocks.advertscreen.domain.model.AttributeLine;
import com.the3rocks.advertscreen.ui.BaseActivity;
import com.the3rocks.advertscreen.util.StringUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.view.View.GONE;

public class AdvertActivity extends BaseActivity implements AdvertPresenter.View {

    @Inject
    AdvertPresenter presenter;

    // Product Component for dagger
    private AdvertComponent advertComponent;

    private static boolean active = false;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.advert_title)
    TextView title;

    @BindView(R.id.linesLayout)
    LinearLayout linesLayout;

    @BindView(R.id.attributes_space)
    LinearLayout attributesLayout;

    @BindView(R.id.description_space)
    LinearLayout descriptionLayout;

    @BindView(R.id.address_line)
    View addressLine;

    @BindView(R.id.advert_ref)
    TextView advertRef;

    @BindView(R.id.map)
    ImageView map;

    @BindView(R.id.contact)
    TextView contact;

    @BindView(R.id.posting)
    TextView posting;

    @BindView(R.id.phone_button)
    Button phoneButton;

    @BindView(R.id.sms_button)
    Button smsButton;

    private String advertUrl;
    private MenuItem favouriteMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component().inject(this);
        presenter.setView(this);
        presenter.start();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_advert;
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
    }

    public AdvertComponent component() {
        if (advertComponent == null) {
            advertComponent = DaggerAdvertComponent.builder()
                    .applicationComponent(((AdvertApplication) getApplication()).getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return advertComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.advert_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favourite) {
            presenter.changeFavourite();
            this.favouriteMenuItem = item;
        } else if (id == R.id.action_share) {
            shareAdvertIfPossible();
        }

        return super.onOptionsItemSelected(item);
    }

    private void shareAdvertIfPossible() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, advertUrl);
        startActivity(intent);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(GONE);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(int errorStringResource) {
        //TODO: Error
    }

    @Override
    public boolean isReady() {
        return active;
    }

    @Override
    public void hideTitle() {
        collapsingToolbar.setTitle("");
        title.setVisibility(GONE);
    }

    @Override
    public void showTitle(String title) {
        collapsingToolbar.setTitle(title);
        this.title.setVisibility(View.VISIBLE);
        this.title.setText(title);
    }

    @Override
    public void hideImages() {
        viewPager.setVisibility(GONE);
    }

    @Override
    public void showImages(List<String> images) {
        viewPager.setVisibility(View.VISIBLE);

        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getBaseContext(), images);
        viewPager.setAdapter(imagePagerAdapter);
    }

    @Override
    public void hideAttributes() {
        attributesLayout.setVisibility(GONE);
    }

    @Override
    public void showAttributes(List<Attribute> attributtes) {
        attributesLayout.setVisibility(View.VISIBLE);
        for (Attribute attribute : attributtes) {
            for (int i = 0; i < attribute.getAttributeLines().size(); i++) {
                AttributeLine attributeLine = attribute.getAttributeLines().get(i);
                String icon = "";
                if (i == 0) {
                    icon = attribute.getIcon();
                }
                attributesLayout.addView(inflateLine(attributesLayout, icon,
                        attributeLine.getLabel(), attributeLine.getText()));
                attributesLayout.addView(inflateSeparator(attributesLayout));
            }
        }
    }

    private View inflateSeparator(ViewGroup parent) {
        return getLayoutInflater().inflate(R.layout.separator_attributes, parent, false);
    }

    private View inflateLine(ViewGroup parent, String iconUrl, String key, String value) {
        View view = getLayoutInflater().inflate(R.layout.advert_line, parent, false);
        if (!StringUtils.isNullOrEmpty(iconUrl)) {
            ImageView iconView = ((ImageView) view.findViewById(R.id.icon));
            Picasso.with(getBaseContext()).load(R.mipmap.ic_format_list_bulleted).into(iconView);
        }
        if (!StringUtils.isNullOrEmpty(key)) {
            ((TextView) view.findViewById(R.id.key)).setText(key);
        }
        if (!StringUtils.isNullOrEmpty(value)) {
            ((TextView) view.findViewById(R.id.value)).setText(value);
        }
        return view;
    }

    @Override
    public void hideDescription() {
        descriptionLayout.setVisibility(GONE);
    }

    @Override
    public void showDescription(String description) {
        descriptionLayout.setVisibility(View.VISIBLE);
        descriptionLayout.addView(inflateDescriptionLine(descriptionLayout, description));
    }

    private View inflateDescriptionLine(ViewGroup parent, String description) {
        View view = getLayoutInflater().inflate(R.layout.advert_description, parent, false);
        ImageView iconView = ((ImageView) view.findViewById(R.id.icon));
        Picasso.with(getBaseContext()).load(R.mipmap.ic_format_align_left).into(iconView);

        if (!StringUtils.isNullOrEmpty(description)) {
            ((TextView) view.findViewById(R.id.description)).setText(description);
        }
        return view;
    }

    @Override
    public void hideAddressLine() {
        addressLine.setVisibility(GONE);
    }

    @Override
    public void showAddressLine(String address, String price) {
        addressLine.setVisibility(View.VISIBLE);

        if (address != null) {
            ImageView icon = (ImageView) addressLine.findViewById(R.id.icon);
            TextView key = (TextView) addressLine.findViewById(R.id.key);
            icon.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.mipmap.ic_map_marker));
            key.setText(address);
        }

        if (price != null) {
            TextView value = (TextView) addressLine.findViewById(R.id.value);
            value.setText(price);
        }

    }

    @Override
    public void hideContact() {
        phoneButton.setVisibility(GONE);
        smsButton.setVisibility(GONE);
    }

    @Override
    public void showContact(final String phone, final String sms) {
        if(!StringUtils.isNullOrEmpty(phone)){
            phoneButton.setVisibility(View.VISIBLE);
            phoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchPhoneIntent(phone);
                }
            });

        }

        if(!StringUtils.isNullOrEmpty(sms)){
            smsButton.setVisibility(View.VISIBLE);
            phoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchSmsIntent(sms);
                }
            });
        }
    }

    @Override
    public void hideMap() {
        map.setVisibility(GONE);
    }

    @Override
    public void showMap(String mapImageUrl) {
        map.setVisibility(View.VISIBLE);
        Picasso.with(getBaseContext()).load(mapImageUrl).into(map);
    }

    @Override
    public void showIsFavourite(boolean isFavourite) {
        favouriteMenuItem.setIcon(isFavourite ? R.mipmap.ic_heart : R.mipmap.ic_heart_outline);
    }

    @Override
    public void showAdvertRef(long advertId) {
        advertRef.setText(String.format(getResources().getString(R.string.ad_ref_text), advertId));
    }

    @Override
    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl;
    }

    @Override
    public void setContact(String name) {
        contact.setText(getResources().getString(R.string.contact_text, name));
    }

    @Override
    public void setPostingSince(String postingSince) {
        posting.setText(postingSince);
    }

    public void launchPhoneIntent(String phoneIntent) {
        Uri call = Uri.parse("tel:" + phoneIntent);
        Intent dial = new Intent(Intent.ACTION_DIAL, call);
        startActivity(dial);
    }

    public void launchSmsIntent(String smsIntent) {
        Intent sms = new Intent(Intent.ACTION_VIEW);
        sms.setData(Uri.parse("sms:"+smsIntent));
        startActivity(sms);
    }
}
