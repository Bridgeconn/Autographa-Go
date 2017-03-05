package com.bridgeconn.autographago.utils;

import com.bridgeconn.autographago.R;
import com.bridgeconn.autographago.models.AllBooksModel;

public class Constants {

    public static final String TAG = "AutographaGo";
    public static final String DUMMY_TAG = "abcd";

    public static final String API_BASE_URL = "https://raw.githubusercontent.com/friendsofagape/Autographa_Repo/master/Bibles/";
    public static final String META_DATA_FILE_NAME = "package.json";
    public static final String USFM_ZIP_FILE_NAME = "Archive.zip";
    public static final String APPEND_URL_FILE = "English/ULB/01-GEN.usfm";

    public static final String STORAGE_DIRECTORY = "/appname-external-data-cache/";

    public interface VersionNames {
        String UDB = "Unlocked Dynamic Bible";
        String ULB = "Unlocked Literal Bible";
    }

    public interface VersionCodes {
        String UDB = "UDB";
        String ULB = "ULB";
    }

    public interface Markers {
        String MARKER_BOOK_NAME = "\\id";
        String MARKER_CHAPTER_NUMBER = "\\c";
        String MARKER_VERSE_NUMBER = "\\v";
        String MARKER_NEW_PARAGRAPH = "\\p";
        String MARKER_SECTION_HEADING = "\\s";
        String MARKER_SECTION_HEADING_ONE = "\\s1";
        String MARKER_SECTION_HEADING_TWO = "\\s2";
        String MARKER_SECTION_HEADING_THREE = "\\s3";
        String MARKER_SECTION_HEADING_FOUR = "\\s4";
        String MARKER_CHUNK = "\\s5";
    }

    public interface Styling {
        String SPLIT_SPACE = "\\s+";
        String NEW_LINE = "\n";
        String NEW_LINE_WITH_TAB_SPACE = "\n    ";
        String MARKER_Q = "\\q";
        String REGEX_NUMBERS = "[^0-9]";
        String TAB_SPACE = "    ";
        String REGEX_ESCAPE = "\\";
        String CHAR_COLON = ":";
    }

    public static final String SHARE_TEXT_TYPE = "text/plain";

    public static final AllBooksModel CONTAINER = new AllBooksModel();

    public enum ParagraphMarker implements Comparable<ParagraphMarker> {
        V, P, S5, S4, S3, S2, S1;
    }

    public interface Tabs {
        String BOOK = "BOOK";
        String CHAPTER = "CHAPTER";
        String VERSE = "VERSE";
    }

    public interface TextEditor {
        String BOLD = "BOLD";
        String ITALICS = "ITALICS";
        String UNDERLINE = "UNDERLINE";
    }

    public static String [] UsfmFileNames = {
            "01-GEN.usfm",
            "02-EXO.usfm",
            "03-LEV.usfm",
            "04-NUM.usfm",
            "05-DEU.usfm",
            "06-JOS.usfm",
            "07-JDG.usfm",
            "08-RUT.usfm",
            "09-1SA.usfm",
            "10-2SA.usfm",
            "11-1KI.usfm",
            "12-2KI.usfm",
            "13-1CH.usfm",
            "14-2CH.usfm",
            "15-EZR.usfm",
            "16-NEH.usfm",
            "17-EST.usfm",
            "18-JOB.usfm",
            "19-PSA.usfm",
            "20-PRO.usfm",
            "21-ECC.usfm",
            "22-SNG.usfm",
            "23-ISA.usfm",
            "24-JER.usfm",
            "25-LAM.usfm",
            "26-EZK.usfm",
            "27-DAN.usfm",
            "28-HOS.usfm",
            "29-JOL.usfm",
            "30-AMO.usfm",
            "31-OBA.usfm",
            "32-JON.usfm",
            "33-MIC.usfm",
            "34-NAM.usfm",
            "35-HAB.usfm",
            "36-ZEP.usfm",
            "37-HAG.usfm",
            "38-ZEC.usfm",
            "39-MAL.usfm",
            "41-MAT.usfm",
            "42-MRK.usfm",
            "43-LUK.usfm",
            "44-JHN.usfm",
            "45-ACT.usfm",
            "46-ROM.usfm",
            "47-1CO.usfm",
            "48-2CO.usfm",
            "49-GAL.usfm",
            "50-EPH.usfm",
            "51-PHP.usfm",
            "52-COL.usfm",
            "53-1TH.usfm",
            "54-2TH.usfm",
            "55-1TI.usfm",
            "56-2TI.usfm",
            "57-TIT.usfm",
            "58-PHM.usfm",
            "59-HEB.usfm",
            "60-JAS.usfm",
            "61-1PE.usfm",
            "62-2PE.usfm",
            "63-1JN.usfm",
            "64-2JN.usfm",
            "65-3JN.usfm",
            "66-JUD.usfm",
            "67-REV.usfm"
    };

    public interface USFMFiles {
        String GENESIS = "01-GEN.usfm";
        String EXODUS = "02-EXO.usfm";
        String LEVITICUS = "03-LEV.usfm";
        String NUMBERS = "04-NUM.usfm";
        String DEUTERONOMY = "05-DEU.usfm";
        String JOSHUA = "06-JOS.usfm";
        String JUDGES = "07-JDG.usfm";
        String RUTH = "08-RUT.usfm";
        String _1_SAMUEL = "09-1SA.usfm";
        String _2_SAMUEL = "10-2SA.usfm";
        String _1_KINGS = "11-1KI.usfm";
        String _2_KINGS = "12-2KI.usfm";
        String _1_CHRONICLES = "13-1CH.usfm";
        String _2_CHRONICLES = "14-2CH.usfm";
        String EZRA = "15-EZR.usfm";
        String NEHEMIAH = "16-NEH.usfm";
        String ESTHER = "17-EST.usfm";
        String JOB = "18-JOB.usfm";
        String PSALMS = "19-PSA.usfm";
        String PROVERBS = "20-PRO.usfm";
        String ECCLESIASTES = "21-ECC.usfm";
        String SONG_OF_SOLOMON = "22-SNG.usfm";
        String ISAIAH = "23-ISA.usfm";
        String JEREMIAH = "24-JER.usfm";
        String LAMENTATIONS = "25-LAM.usfm";
        String EZEKIEL = "26-EZK.usfm";
        String DANIEL = "27-DAN.usfm";
        String HOSEA = "28-HOS.usfm";
        String JOEL = "29-JOL.usfm";
        String AMOS = "30-AMO.usfm";
        String OBADIAH = "31-OBA.usfm";
        String JONAH = "32-JON.usfm";
        String MICAH = "33-MIC.usfm";
        String NAHUM = "34-NAM.usfm";
        String HABAKKUK = "35-HAB.usfm";
        String ZEPHANIAH = "36-ZEP.usfm";
        String HAGGAI = "37-HAG.usfm";
        String ZECHARIAH = "38-ZEC.usfm";
        String MALACHI = "39-MAL.usfm";
        String MATTHEW_S_GOSPEL = "41-MAT.usfm";
        String MARK_S_GOSPEL = "42-MRK.usfm";
        String LUKE_S_GOSPEL = "43-LUK.usfm";
        String JOHN_S_GOSPEL = "44-JHN.usfm";
        String ACTS = "45-ACT.usfm";
        String ROMANS = "46-ROM.usfm";
        String _1_CORINTHIANS = "47-1CO.usfm";
        String _2_CORINTHIANS = "48-2CO.usfm";
        String GALATIANS = "49-GAL.usfm";
        String EPHESIANS = "50-EPH.usfm";
        String PHILIPPIANS = "51-PHP.usfm";
        String COLOSSIANS = "52-COL.usfm";
        String _1_THESSALONIANS = "53-1TH.usfm";
        String _2_THESSALONIANS = "54-2TH.usfm";
        String _1_TIMOTHY = "55-1TI.usfm";
        String _2_TIMOTHY = "56-2TI.usfm";
        String TITUS = "57-TIT.usfm";
        String PHILEMON = "58-PHM.usfm";
        String HEBREWS = "59-HEB.usfm";
        String JAMES = "60-JAS.usfm";
        String _1_PETER = "61-1PE.usfm";
        String _2_PETER = "62-2PE.usfm";
        String _1_JOHN = "63-1JN.usfm";
        String _2_JOHN = "64-2JN.usfm";
        String _3_JOHN = "65-3JN.usfm";
        String JUDE = "66-JUD.usfm";
        String REVELATION = "67-REV.usfm";
    }

    public interface MarkerTypes {
        String SECTION_HEADING_ONE = "s1";
        String SECTION_HEADING_TWO = "s2";
        String SECTION_HEADING_THREE = "s3";
        String SECTION_HEADING_FOUR = "s4";
        String CHUNK = "s5";
        String PARAGRAPH = "p";
        String VERSE = "v";
    }

    public interface Keys {
        String POSITION = "position";
        String TAB_NAME = "tabName";
        String BOOK_ID = "bookId";
        String SCREEN_MODE = "screenMode";
        String CHAPTER_NO = "chapter_number";
        String VERSE_NO = "verse_number";
        String VERSE_MODELS = "verse_models";
        String VERSE_SET = "verse_set";
        String SELECT_VERSE_FOR_NOTE = "select_verse_for_note";
        String OPEN_BOOK = "open_book";
        String VERSE_NOTE_MODEL = "verse_note_model";
        String SAVED_NOTE_TIMESTAMP = "saved_note_timestamp";
        String NOTES_MODEL = "notes_model";

        String READING_MODE_CHANGE = "reading_mode_change";
        String TEXT_SIZE_CHANGED = "text_size_changed";

        String LANGUAGE = "language";
        String VERSION = "version";
        String VERSION_NAME = "version_name";
    }

    public interface RequestCodes {
        int EDIT_NOTES = 0;
        int SETTINGS = 1;
        int PERMISSION_STORAGE = 2;
        int APP_SETTINGS_STORAGE = 3;
    }

    public interface PrefKeys {
        String LAST_READ_BOOK_ID = "last_read_book";
        String LAST_READ_CHAPTER = "last_read_chapter";
        String LAST_READ_VERSE = "last_read_verse";

        String LAST_READ = "last_read";

        String FONT_SIZE = "font_size";
        String READING_MODE = "reading_mode";

        String LAST_OPEN_LANGUAGE_CODE = "last_open_language_code";
        String LAST_OPEN_VERSION_CODE = "last_open_version_code";
    }

    public enum ReadingMode {
        Day(0, "Day"),
        Night(1, "Night");

        private int value;
        private String title;

        public int getValue() {
            return value;
        }

        public String getTitle() {
            return title;
        }

        ReadingMode(int value, String title) {
            this.value = value;
            this.title = title;
        }
    }

    public enum FontSize {
        XSmall(R.style.FontSize_XSmall, "XSmall"),
        Small(R.style.FontSize_Small, "Small"),
        Medium(R.style.FontSize_Medium, "Medium"),
        Large(R.style.FontSize_Large, "Large"),
        XLarge(R.style.FontSize_XLarge, "XLarge");

        private int resId;
        private String title;

        public int getResId() {
            return resId;
        }

        public String getTitle() {
            return title;
        }

        FontSize(int resId, String title) {
            this.resId = resId;
            this.title = title;
        }
    }
}