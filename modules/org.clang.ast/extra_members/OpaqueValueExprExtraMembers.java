@Converted(kind = Converted.Kind.MANUAL_ADDED)
public OpaqueValueExpr() {
  this.SourceExpr = null;
  this.Loc = new SourceLocation();
}

private OpaqueValueExpr(OpaqueValueExpr $Prm0) {
  super($Prm0);
  this.SourceExpr = $Prm0.SourceExpr;
  this.Loc = new SourceLocation($Prm0.Loc);
}

@Override
public OpaqueValueExpr clone() {
  return new OpaqueValueExpr(this);
}
