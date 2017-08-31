public AttributedLocInfo() {
  OperandParens = new SourceRange();
  AttrLoc = new SourceLocation();
}

public AttributedLocInfo(AttributedLocInfo $Prm0) {
  this.OperandParens = new SourceRange($Prm0.OperandParens);
  AttrLoc = new SourceLocation($Prm0.AttrLoc);
  Unnamed_field.ExprOperand = $Prm0.Unnamed_field.ExprOperand;
  Unnamed_field.EnumOperandLoc = $Prm0.Unnamed_field.EnumOperandLoc;
}

@Override
public AttributedLocInfo clone() {
  assert this.getClass() == AttributedLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new AttributedLocInfo(this);
}
