@Override public DeclarationName clone() { return new DeclarationName(this.$Ptr, $uchar2uint(this.$PtrBits)); }

@Override public int $hashcode() { return DenseMapInfoPair.combineTwoHashes(System.identityHashCode(this.$Ptr), this.$PtrBits); }

@Override
public boolean $less(Object obj) {
  return compare(this, (DeclarationName) obj) < 0;
}

public static final DeclarationName DEFAULT = new DeclarationName();

public static final Comparator<DeclarationName> COMPARATOR = new Comparator<DeclarationName>() {
  @Override
  public int compare(DeclarationName o1, DeclarationName o2) {
    if (o1.$less(o2)) {
      return -1;
    } else if (o2.$less(o1)) {
      return 1;
    }
    return 0;
  }
};
