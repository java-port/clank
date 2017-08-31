public ObjCDictionaryElement(Expr Key, Expr Value, SourceLocation EllipsisLoc, OptionalUInt NumExpansions) {
  this.Key = Key;
  this.Value = Value;
  this.EllipsisLoc = EllipsisLoc;
  this.NumExpansions = NumExpansions;
}

public ObjCDictionaryElement(final ObjCDictionaryElement /*&&*/$Prm0) {
  this.Key = $Prm0.Key;
  this.Value = $Prm0.Value;
  this.EllipsisLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.EllipsisLoc);
  this.NumExpansions = new OptionalUInt(JD$Move.INSTANCE, $Prm0.NumExpansions);
}

public ObjCDictionaryElement() {
  this.EllipsisLoc = new SourceLocation();
  this.NumExpansions = new OptionalUInt();
}

@Override
public ObjCDictionaryElement clone() {
  return new ObjCDictionaryElement(this);
}
