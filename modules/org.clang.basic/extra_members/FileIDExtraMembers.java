public static final FileID DEFAULT = new FileID();

public static Comparator<FileID> COMPARATOR = new Comparator<FileID>() {
  @Override
  public int compare(FileID o1, FileID o2) {
    return o1.ID-o2.ID;
  }
};
