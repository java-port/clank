// Special class to unfold ObjCDictionaryLiteral_KeyValuePair which has two 'Stmt /*P*/' fields
// into iterator with doubled number of 'Stmt /*P*/' elements
private static final class StmtPtrStmtPtrIterator implements type$iterator<StmtPtrStmtPtrIterator, Stmt /*P*/ > {
  private final type$ptr<ObjCDictionaryLiteral_KeyValuePair /*P*/> delegate;
  private boolean onValue;

  private StmtPtrStmtPtrIterator(StmtPtrStmtPtrIterator $Prm0) {
    this.delegate = $Clone($Prm0.delegate);
    this.onValue = $Prm0.onValue;
  }

  private StmtPtrStmtPtrIterator(type$ptr<ObjCDictionaryLiteral_KeyValuePair /*P*/> delegate) {
    this.delegate = delegate;
    this.onValue = false;
  }

  @Override
  public Stmt/*P*/ $star() {
    final ObjCDictionaryLiteral_KeyValuePair $star = delegate.$star();
    return onValue ? $star.Value : $star.Key;
  }

  @Override
  public type$ref<Stmt/*P*/> star$ref() {
    return new type$ptr$inout<Stmt>(this) {
      final ObjCDictionaryLiteral_KeyValuePair $star = delegate.$star();
      final boolean $onValue = onValue;
      @Override
      protected Stmt $star$impl() {
        return $onValue ? $star.Value : $star.Key;
      }
    };
  }

  @Override public StmtPtrStmtPtrIterator $preInc() {
    if (onValue) {
      delegate.$preInc();
    }
    onValue = !onValue;
    return this;
  }

  @Override public boolean $eq(Object RHS) {
    StmtPtrStmtPtrIterator other = (StmtPtrStmtPtrIterator) RHS;
    return this.onValue == other.onValue && delegate.$eq(other.delegate);
  }

  @Override public StmtPtrStmtPtrIterator clone() {
    return new StmtPtrStmtPtrIterator(this);
  }

  @Override
  public String toString() {
    return "on " + (onValue ? "Value" : "Key") + " element of: " + this.delegate;
  }
}
  
@Override
public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy1() {
  return numTrailingObjects((OverloadToken<ObjCDictionaryLiteral_KeyValuePair>) null);
}

@Override
public int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == ObjCDictionaryLiteral_KeyValuePair.class || 
          clazz == ObjCDictionaryLiteral_ExpansionData.class : "Unexpected class " + clazz;
  if (clazz == ObjCDictionaryLiteral_KeyValuePair.class) {
    return 0;
  } else {
    assert clazz == ObjCDictionaryLiteral_ExpansionData.class : "Unexpected class " + clazz;
    return getNumTailingObject_OverloadToken$TrailingTy1();
  }
}
