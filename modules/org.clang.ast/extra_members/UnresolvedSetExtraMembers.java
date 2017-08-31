public UnresolvedSet(int InlineCapacity) {
  this.Decls = new SmallVector<>(InlineCapacity);
}
  
public UnresolvedSet(JD$Move _dparam, UnresolvedSet other) {
  this.Decls = other.Decls;
}

public UnresolvedSet() {
  this.Decls = new SmallVector<>(0);
}
  
public UnresolvedSet $assignMove(UnresolvedSet other) {
  this.Decls.$assignMove(other.Decls);
  return /*Deref*/this;
}

@Override
public void $destroy() {
  Decls.$destroy();
}

@Override protected SmallVectorImpl<DeclAccessPair> /*&*/ decls() {
  return this.Decls;
}

@Override protected /*const*/ SmallVectorImpl<DeclAccessPair> /*&*/ decls$Const() /*const*/ {
  return this.Decls;
}