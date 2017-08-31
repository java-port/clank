@Converted(kind = Converted.Kind.MANUAL_ADDED)
public LateInstantiatedAttribute() {}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public LateInstantiatedAttribute(LateInstantiatedAttribute Other) {
  this.TmplAttr = Other.TmplAttr;
  this.Scope = Other.Scope;
  this.NewDecl = Other.NewDecl;
}

@Override
public LateInstantiatedAttribute $assign(LateInstantiatedAttribute Other) {
  this.TmplAttr = Other.TmplAttr;
  this.Scope = Other.Scope;
  this.NewDecl = Other.NewDecl;
  return this;
}

@Override
public LateInstantiatedAttribute clone() {
  return new LateInstantiatedAttribute(this);
}