public VarDefinition() {
  throw new UnsupportedOperationException("Why it is called?");
}

@Override
public VarDefinition $assign(final /*const*/ VarDefinition /*&*/ $Prm0) {
  this.Dec = $Prm0.Dec;
  this.Exp = $Prm0.Exp;
  this.Ref = $Prm0.Ref;
  this.Ctx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >($Prm0.Ctx);
  return this;
}

@Override
public VarDefinition clone() {
  return new VarDefinition(this);
}
