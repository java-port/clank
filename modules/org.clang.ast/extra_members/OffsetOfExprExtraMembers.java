@Override 
public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
  return numTrailingObjects((OverloadToken<OffsetOfNode>)null); 
}

@Override
public final type$ptr<?> $TrailingObjects() {
  return super.$this$plus1();
}

@Override
public final int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == OffsetOfNode.class
          || clazz == Expr.class;
  if (clazz == OffsetOfNode.class) {
    return 0;
  }
  return getNumTailingObject_OverloadToken$TrailingTy1();
}
