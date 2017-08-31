// we don't create FunctionType here because any type requires LLVMContext intstance
protected final Object/*P*/ emptyKey = new String("FunctionType.EmptyKey");
protected final Object/*P*/ tombstoneKey = new String("FunctionType.TombstoneKey");
private static final FunctionTypeKeyInfo $INFO = new FunctionTypeKeyInfo();

public static FunctionTypeKeyInfo $Info() { return $INFO; }

@Override public boolean isKeyPointerLike() { return true; }

@Override public /*static uint*/int getHashValueAlt(final /*const*/ Object/*KeyTy*/ /*&*/ Key) {
  return getHashValue((KeyTy)Key);
}

@Override public /*static*/ boolean isEqualAlt(final /*const*/ Object/*KeyTy*/ /*&*/ LHS, /*const*/ FunctionType /*P*/ RHS) {
  return isEqual((KeyTy)LHS, RHS);
}
