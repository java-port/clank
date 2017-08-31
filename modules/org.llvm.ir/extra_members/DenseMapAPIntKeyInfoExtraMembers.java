private static final DenseMapAPIntKeyInfo $INFO = new DenseMapAPIntKeyInfo();
private static final APInt emptyKey; 
static {
  emptyKey = new APInt((ulong$ptr/*uint64_t P*/ )null, 0);
  emptyKey.VAL = $int2ulong(0);
}
private static final APInt tombstoneKey; 
static {
  tombstoneKey = new APInt((ulong$ptr/*uint64_t P*/ )null, 0);
  tombstoneKey.VAL = $int2ulong(0);
}

public static DenseMapAPIntKeyInfo $Info() { return $INFO; }

@Override public boolean isKeyPointerLike() { return false; }
