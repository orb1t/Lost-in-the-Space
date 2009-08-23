package org.limewire.ui.swing.search;

public enum SearchViewType {
    LIST(0), TABLE(1);

    /**
     * The explicit id of the type. Not an ordinal because it is serialized over
     * multiple sessions.
     */
    private final int id;

    SearchViewType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Returns the search view type for the given search view id. If non match,
     * LIST type is returned by default. This is used to save values in the
     * SearchSettings.SEARCH_VIEW_TYPE_ID.
     */
    public static SearchViewType forId(int id) {
        for(SearchViewType type : values()) {
            if(type.getId() == id) {
                return type;
            }
        }
        return LIST;
    }
}