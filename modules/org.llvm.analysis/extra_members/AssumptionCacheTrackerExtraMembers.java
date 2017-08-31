public static final/*char*/Class<AssumptionCacheTracker> ID = AssumptionCacheTracker.class; // Pass identification, replacement for typeid

private static class/*struct*/ DenseMapInfoFunctionCallbackVH implements org.llvm.adt.DenseMapInfo<FunctionCallbackVH> {

  private static final DenseMapInfoFunctionCallbackVH $INFO = new DenseMapInfoFunctionCallbackVH();

  public static DenseMapInfoFunctionCallbackVH $Info() {
    return $INFO;
  }
  private static final FunctionCallbackVH emptyKey = new FunctionCallbackVH((Value)null);
  private static final FunctionCallbackVH tombstoneKey = new FunctionCallbackVH((Value)null);

  @Override public /*inline*/ FunctionCallbackVH getEmptyKey() {
    return emptyKey;
  }

  @Override public /*inline*/ FunctionCallbackVH getTombstoneKey() {
    return tombstoneKey;
  }

  @Override public /*uint*/ int getHashValue(final /*const*/ FunctionCallbackVH /*&*/ Val) {
    assert Val != emptyKey : "must not be called for emptyKey";
    assert Val != tombstoneKey : "must not be called for tombstoneKey";
    return DenseMapInfo$LikePtr.$Info().getHashValue(Val.$Value$P());
  }

  @Override public boolean isEqual(final /*const*/ FunctionCallbackVH /*&*/ LHS, final /*const*/ FunctionCallbackVH /*&*/ RHS) {
    assert LHS != emptyKey : "LHS: must not be called for emptyKey";
    assert LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";
    assert RHS != emptyKey : "RHS: must not be called for emptyKey";
    assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";
    return DenseMapInfo$LikePtr.$Info().isEqual(LHS.$Value$P(), RHS.$Value$P());
  }

  @Override public /*uint*/ int getHashValueAlt(final /*const*/ Object /*&*/ Val) {
    assert Val != emptyKey.$Value$P() : "must not be called for emptyKey";
    assert Val != tombstoneKey.$Value$P() : "must not be called for tombstoneKey";
    return DenseMapInfo$LikePtr.$Info().getHashValue((Value/*P*/)Val);
  }

  @Override public boolean isEqualAlt(final /*const*/ Object /*&*/ LHS, final /*const*/ FunctionCallbackVH /*&*/ RHS) {
    assert LHS != emptyKey.$Value$P() : "LHS: must not be called for emptyKey";
    assert LHS != tombstoneKey.$Value$P() : "LHS: must not be called for tombstoneKey";
    assert RHS != emptyKey : "RHS: must not be called for emptyKey";
    assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";
    return DenseMapInfo$LikePtr.$Info().isEqual((Value/*P*/)LHS, RHS.$Value$P());
  }

  @Override public boolean isKeyPointerLike() {
    return false;
  }
}
