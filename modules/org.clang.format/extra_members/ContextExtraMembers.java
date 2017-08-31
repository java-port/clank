private Context() { }

@Override
public Context $assign(Context value) {
  this.ContextKind = value.ContextKind;
  this.BindingStrength = value.BindingStrength;
  this.IsExpression = value.IsExpression;
  this.LongestObjCSelectorName = value.LongestObjCSelectorName;
  this.ColonIsForRangeExpr = value.ColonIsForRangeExpr;
  this.ColonIsDictLiteral = value.ColonIsDictLiteral;
  this.ColonIsObjCMethodExpr = value.ColonIsObjCMethodExpr;
  this.FirstObjCSelectorName = value.FirstObjCSelectorName;
  this.FirstStartOfName = value.FirstStartOfName;
  this.CanBeExpression = value.CanBeExpression;
  this.InTemplateArgument = value.InTemplateArgument;
  this.InCtorInitializer = value.InCtorInitializer;
  this.CaretFound = value.CaretFound;
  this.IsForEachMacro = value.IsForEachMacro;
  return this;
}

@Override
public Context clone() {
  Context res = new Context();
  res.$assign(this);
  return res;
}
