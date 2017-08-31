@Override
public Selector clone() {
  return new Selector(this);
}

public static final Comparator<Selector> COMPARATOR = new Comparator<Selector>() {
  @Override
  public int compare(Selector o1, Selector o2) {
    // JAVA: slow version of compare
    if (o1.$eq(o2)) {
      return 0;
    }
    if (o1.$InfoPtr == o2.$InfoPtr) {
      return Unsigned.$compare_uchar(o1.$InfoPtrBits, o2.$InfoPtrBits);
    }
    return Native.compare$JavaRef(o1.$InfoPtr, o2.$InfoPtr);
  }
};
