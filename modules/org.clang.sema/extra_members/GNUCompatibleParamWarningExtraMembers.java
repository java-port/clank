public GNUCompatibleParamWarning() {
  this.PromotedType = new QualType();
}

public GNUCompatibleParamWarning(ParmVarDecl OldParm, ParmVarDecl NewParm, QualType PromotedType) {
  this.OldParm = OldParm;
  this.NewParm = NewParm;
  this.PromotedType = new QualType(PromotedType);
}

@Override public GNUCompatibleParamWarning clone() {
  return new GNUCompatibleParamWarning(this.OldParm, this.NewParm, this.PromotedType);
}
