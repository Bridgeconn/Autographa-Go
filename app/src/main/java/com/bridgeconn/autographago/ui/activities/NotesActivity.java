package com.bridgeconn.autographago.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bridgeconn.autographago.R;
import com.bridgeconn.autographago.models.NotesModel;
import com.bridgeconn.autographago.ormutils.AllMappers;
import com.bridgeconn.autographago.ormutils.AllSpecifications;
import com.bridgeconn.autographago.ormutils.AutographaRepository;
import com.bridgeconn.autographago.ormutils.Mapper;
import com.bridgeconn.autographago.ormutils.Specification;
import com.bridgeconn.autographago.ui.adapters.NotesAdapter;
import com.bridgeconn.autographago.utils.Constants;
import com.bridgeconn.autographago.utils.SharedPrefs;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class NotesActivity extends AppCompatActivity implements View.OnClickListener {

    private Realm realm;
    private ImageView mIvNewNote;
    private RecyclerView mRecyclerView;
    private NotesAdapter mAdapter;
    private ArrayList<NotesModel> mNotesModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(SharedPrefs.getFontSize().getResId(), true);
        super.onCreate(savedInstanceState);

        realm = Realm.getDefaultInstance();

        setContentView(R.layout.activity_notes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

//        getNotesFromDB();

        mIvNewNote = (ImageView) findViewById(R.id.iv_new_note);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_notes);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new NotesAdapter(this, mNotesModels);
        mRecyclerView.setAdapter(mAdapter);

        mIvNewNote.setOnClickListener(this);
    }

    private void getNotesFromDB() {
        mNotesModels.clear();
        ArrayList<NotesModel> models = query(new AllSpecifications.AllNotes(), new AllMappers.NotesMapper());
        for (NotesModel model : models) {
            mNotesModels.add(model);
        }
        for (int i=0; i<mNotesModels.size(); i++) {
            Log.i(Constants.DUMMY_TAG, "OPEN == " + mNotesModels.get(i).getTitle());
            for (int j=0; j<mNotesModels.get(i).getVerseIds().size(); j++) {
                Log.i(Constants.DUMMY_TAG, mNotesModels.get(i).getVerseIds().get(j).getBookId() + " :: " + mNotesModels.get(i).getVerseIds().get(j).getChapterNumber() + " :: " + mNotesModels.get(i).getVerseIds().get(j).getVerseNumber());
            }
        }
    }

    private ArrayList<NotesModel> query(Specification<NotesModel> specification, Mapper<NotesModel, NotesModel> mapper) {
        RealmResults<NotesModel> realmResults = specification.generateResults(realm);

        ArrayList<NotesModel> resultsToReturn = new ArrayList<>();

        for (NotesModel result : realmResults) {
            resultsToReturn.add(mapper.map(result));
        }

        return resultsToReturn;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_new_note: {
                Intent intent = new Intent(this, EditNoteActivity.class);
                startActivity(intent);
                break;
            }
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
    protected void onDestroy() {
        super.onDestroy();

        realm.close();
    }

    @Override
    protected void onResume() {
        super.onResume();

        getNotesFromDB();
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void refreshList(int position) {
        new AutographaRepository<NotesModel>().remove(new AllSpecifications.NotesById(mNotesModels.get(position).getTimestamp()));
        mNotesModels.remove(position);
//        mAdapter.notifyDataSetChanged();
        mAdapter.notifyItemRemoved(position);
        // TODO fix this, item deleted but not from display
    }
}