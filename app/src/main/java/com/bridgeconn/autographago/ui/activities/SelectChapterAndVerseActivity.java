package com.bridgeconn.autographago.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bridgeconn.autographago.R;
import com.bridgeconn.autographago.ui.customviews.TabLayoutHelper;
import com.bridgeconn.autographago.ui.fragments.BookFragment;
import com.bridgeconn.autographago.ui.fragments.ChapterFragment;
import com.bridgeconn.autographago.ui.fragments.VerseFragment;
import com.bridgeconn.autographago.utils.Constants;
import com.bridgeconn.autographago.utils.SharedPrefs;
import com.bridgeconn.autographago.utils.UtilFunctions;

import java.util.ArrayList;

public class SelectChapterAndVerseActivity extends AppCompatActivity {

    private ArrayList<String> Tabs = new ArrayList<>();
    private ViewPagerAdapter mAdapter;
    private TabLayoutHelper mTabLayoutHelper;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private boolean mOpenBook, mSelectVerse;
    private String bookId, verseNumber;
    private int chapterNumber;

    public interface OnItemClickListener {
        void onItemClick(int position, String bookId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(SharedPrefs.getFontSize().getResId(), true);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_chapter_and_verse);

        UtilFunctions.applyReadingMode();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Intent intent = getIntent();

        bookId = intent.getStringExtra(Constants.Keys.BOOK_ID);
        chapterNumber = intent.getIntExtra(Constants.Keys.CHAPTER_NO, 1);
        verseNumber = intent.getStringExtra(Constants.Keys.VERSE_NO);

        if (intent.getBooleanExtra(Constants.Keys.SELECT_VERSE_FOR_NOTE, false)) {
            Tabs.add(Constants.BookTabs.BOOK);
        }
        mSelectVerse = intent.getBooleanExtra(Constants.Keys.SELECT_VERSE_FOR_NOTE, false);
        mOpenBook = intent.getBooleanExtra(Constants.Keys.OPEN_BOOK, false);

        Tabs.add(Constants.BookTabs.CHAPTER);
        Tabs.add(Constants.BookTabs.VERSE);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        if (bookId != null) {

            getSupportActionBar().setTitle(getString(R.string.title_books));

            mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), Tabs, bookId, mOpenBook, mSelectVerse, chapterNumber);
            mViewPager.setAdapter(mAdapter);

            mTabLayoutHelper = new TabLayoutHelper(mTabLayout, mViewPager);
            mTabLayoutHelper.setAutoAdjustTabModeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mViewPager.getAdapter() == null) {
            return;
        }
        if (mTabLayoutHelper != null) {
            mTabLayoutHelper.release();
            mTabLayoutHelper = null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mViewPager.getAdapter() == null) {
            return;
        }
        if (mTabLayoutHelper == null) {
            mTabLayoutHelper = new TabLayoutHelper(mTabLayout, mViewPager);
            mTabLayoutHelper.setAutoAdjustTabModeEnabled(true);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mViewPager.getAdapter() == null) {
            return;
        }
        if (mTabLayoutHelper != null) {
            mTabLayoutHelper.release();
            mTabLayoutHelper = null;
        }
    }

    static BookFragment bookFragment;
    static ChapterFragment chapterFragment;
    static VerseFragment verseFragment;

    private static class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private ArrayList<String> TabsList;
        private String mBookId;
        private boolean mOpenBook;
        private boolean mSelectVerse;
        private int mChapterNum;

        public ViewPagerAdapter(FragmentManager fragmentManager, ArrayList<String> tabs, String bookId, boolean openBook, boolean selectVerse, int chapterNum) {
            super(fragmentManager);
            TabsList = tabs;
            mBookId = bookId;
            mOpenBook = openBook;
            mSelectVerse = selectVerse;
            mChapterNum = chapterNum;
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(Constants.Keys.OPEN_BOOK, mOpenBook);
            bundle.putBoolean(Constants.Keys.SELECT_VERSE_FOR_NOTE, mSelectVerse);
            bundle.putString(Constants.Keys.BOOK_ID, mBookId);
            if (getPageTitle(position).equals(Constants.BookTabs.BOOK)) {
                bookFragment = new BookFragment();
                bookFragment.setArguments(bundle);
                return bookFragment;
            } else if (getPageTitle(position).equals(Constants.BookTabs.CHAPTER)) {
                chapterFragment = new ChapterFragment();
                bundle.putInt(Constants.Keys.CHAPTER_NO, mChapterNum);
                chapterFragment.setArguments(bundle);
                return chapterFragment;
            } else {
                verseFragment = new VerseFragment();
                bundle.putInt(Constants.Keys.CHAPTER_NO, mChapterNum);
                verseFragment.setArguments(bundle);
                return verseFragment;
            }
        }

        @Override
        public int getCount() {
            return TabsList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TabsList.get(position);
        }

    }

    public void openVersePage(int chapterNumber, String bookId) {
        if (mTabLayout == null) {
            return;
        }
        mTabLayout.getTabAt(mTabLayout.getSelectedTabPosition() + 1).select();
        verseFragment.onItemClick(chapterNumber, bookId);
    }

    public void openChapterPage(int bookPosition, String bookId) {
        if (mTabLayout == null) {
            return;
        }
        mTabLayout.getTabAt(mTabLayout.getSelectedTabPosition() + 1).select();
        chapterFragment.onItemClick(bookPosition, bookId);
    }

    public void reattachFragment() {
        mAdapter.notifyDataSetChanged();
    }

    public int getSelectedChapter() {
        return chapterFragment.getSelectedChapterNumber();
    }

    public String getSelectedBook() {
        return bookFragment.getSelectedBookId();
    }
}