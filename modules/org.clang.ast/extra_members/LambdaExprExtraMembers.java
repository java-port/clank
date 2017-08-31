@Override 
public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() {
  return numTrailingObjects_OverloadToken$Stmt$P((OverloadToken<Stmt /*P*/>)null); 
}

@Override 
public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy2() { 
  return numTrailingObjects_OverloadTokenUInt((OverloadTokenUInt)null); 
}

@Override
public final type$ptr<?> $TrailingObjects() {
  return super.$this$plus1();
}

@Override
public final int getTrailingObjects$Offset(Class<?> clazz) {
  // Stmt /*P*/ , /*uint Integer,*/ VarDecl /*P*/ 
  assert clazz == Stmt.class
          || clazz == int.class
          || clazz == VarDecl.class;
  if (clazz == Stmt.class) {
    return 0;
  } else if (clazz == int.class) {
    return getNumTailingObject_OverloadToken$TrailingTy1();
  }
  return getNumTailingObject_OverloadToken$TrailingTy1() + getNumTailingObject_OverloadToken$TrailingTy2();
}
