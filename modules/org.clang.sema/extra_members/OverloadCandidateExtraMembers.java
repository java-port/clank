@Override
public OverloadCandidate $assign(OverloadCandidate $Prm0) {
  this.Function = $Prm0.Function;
  this.FoundDecl.$assign($Prm0.FoundDecl);
  this.BuiltinTypes.$assign($Prm0.BuiltinTypes);
  this.Surrogate = $Prm0.Surrogate;
  this.Conversions = $Prm0.Conversions;
  this.Fix.$assign($Prm0.Fix);
  this.NumConversions = $Prm0.NumConversions;
  this.Viable = $Prm0.Viable;
  this.IsSurrogate = $Prm0.IsSurrogate;
  this.IgnoreObjectArgument = $Prm0.IgnoreObjectArgument;
  this.FailureKind = $Prm0.FailureKind;
  this.ExplicitCallArguments = $Prm0.ExplicitCallArguments;
  this.Unnamed_field12.$assign($Prm0.Unnamed_field12);
  return /*Deref*/this;
}

@Override public OverloadCandidate clone() { 
  return new OverloadCandidate(this); 
}

@Override public OverloadCandidate move() {
  return new OverloadCandidate(JD$Move.INSTANCE, this);
}
