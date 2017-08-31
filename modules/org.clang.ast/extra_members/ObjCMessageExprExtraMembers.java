@Override
public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy1() {
  return numTrailingObjects((OverloadToken<Object/*void P*/>) null);
}

@Override
public type$ptr<Object> getTrailingObjects$VoidPtr() {
  return (type$ptr<Object>) super.$this$plus1();
}

@Override
public </*typename*/ T> type$ptr</*const*/ T /*P*/> getTrailingObjects(Class<T> clazz) {
  assert clazz == SourceLocation.class;
  return (type$ptr</*const*/ T /*P*/>) getTrailingObjects$VoidPtr().$add(getNumTailingObject_OverloadToken$TrailingTy1());
}
