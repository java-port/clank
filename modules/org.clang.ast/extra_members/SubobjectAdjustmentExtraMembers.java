public SubobjectAdjustment() {
  this.Kind = Unnamed_enum.DerivedToBaseAdjustment;
}

private SubobjectAdjustment(SubobjectAdjustment $Prm0) {
  this.Kind = $Prm0.Kind;
  this.Unnamed_field1.Field = $Prm0.Unnamed_field1.Field;
  this.Unnamed_field1.Ptr.MPT = $Prm0.Unnamed_field1.Ptr.MPT;
  this.Unnamed_field1.Ptr.RHS = $Prm0.Unnamed_field1.Ptr.RHS;
  this.Unnamed_field1.DerivedToBase.BasePath = $Prm0.Unnamed_field1.DerivedToBase.BasePath;
  this.Unnamed_field1.DerivedToBase.DerivedClass = $Prm0.Unnamed_field1.DerivedToBase.DerivedClass;
}

@Override public SubobjectAdjustment clone() {
  return new SubobjectAdjustment(this);
}
