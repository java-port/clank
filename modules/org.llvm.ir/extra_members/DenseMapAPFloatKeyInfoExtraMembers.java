private static final DenseMapAPFloatKeyInfo $INFO = new DenseMapAPFloatKeyInfo();
private static final APFloat emptyKey = new APFloat(APFloat.Bogus, $int2ulong(1));
private static final APFloat tombstoneKey = new APFloat(APFloat.Bogus, $int2ulong(2));

public static DenseMapAPFloatKeyInfo $Info() { return $INFO; }

@Override public boolean isKeyPointerLike() { return false; }
