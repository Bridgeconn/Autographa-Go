package com.bridgeconn.autographago.models;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SearchModel extends RealmObject implements Parcelable {//}, Serializable {

    private String bookId;
    private String bookName;
    private int chapterNumber;
    private String verseNumber;
    private String text;
    private long timeStamp;
    @PrimaryKey
    private String searchId;

    public SearchModel() {
    }

    public SearchModel(SearchModel searchModel) {
        bookId = searchModel.getBookId();
        bookName = searchModel.getBookName();
        chapterNumber = searchModel.getChapterNumber();
        verseNumber = searchModel.getVerseNumber();
        text = searchModel.getText();
        timeStamp = searchModel.getTimeStamp();
        searchId = searchModel.getSearchId();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getVerseNumber() {
        return verseNumber;
    }

    public void setVerseNumber(String verseNumber) {
        this.verseNumber = verseNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bookId);
        dest.writeString(this.bookName);
        dest.writeInt(this.chapterNumber);
        dest.writeString(this.verseNumber);
        dest.writeString(this.text);
        dest.writeLong(this.timeStamp);
        dest.writeString(this.searchId);
    }

    protected SearchModel(Parcel in) {
        this.bookId = in.readString();
        this.bookName = in.readString();
        this.chapterNumber = in.readInt();
        this.verseNumber = in.readString();
        this.text = in.readString();
        this.timeStamp = in.readLong();
        this.searchId = in.readString();
    }

    public static final Creator<SearchModel> CREATOR = new Creator<SearchModel>() {
        @Override
        public SearchModel createFromParcel(Parcel source) {
            return new SearchModel(source);
        }

        @Override
        public SearchModel[] newArray(int size) {
            return new SearchModel[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SearchModel &&
                this.bookId != null &&
                this.bookId.equals(((SearchModel) obj).bookId) &&
                this.chapterNumber == ((SearchModel) obj).chapterNumber &&
                this.verseNumber.equals(((SearchModel) obj).verseNumber);
    }

    @Override
    public int hashCode() {
        return (this.getBookId()+ " " + this.getChapterNumber()+ " " + this.getVerseNumber()).hashCode();
    }
}