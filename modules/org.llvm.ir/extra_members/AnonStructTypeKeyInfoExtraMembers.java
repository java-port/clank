// we don't create StructType here because any type requires LLVMContext intstance
protected final Object/*P*/ emptyKey = new String("StructType.EmptyKey");
protected final Object/*P*/ tombstoneKey = new String("StructType.TombstoneKey");
private static final AnonStructTypeKeyInfo $INFO = new AnonStructTypeKeyInfo();

public static AnonStructTypeKeyInfo $Info() { return $INFO; }

@Override public boolean isKeyPointerLike() { return true; }

@Override public final /*static*/ boolean isEqualAlt(final /*const*/ Object/*KeyTy*/ /*&*/ LHS, /*const*/ StructType /*P*/ RHS) {
  return isEqual((KeyTy)LHS, RHS);
}

@Override public final /*static uint*/int getHashValueAlt(final /*const*/ Object/*KeyTy*/ /*&*/ Key) {
  return getHashValue((KeyTy)Key);
}
