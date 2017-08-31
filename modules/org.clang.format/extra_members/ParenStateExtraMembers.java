public ParenState() { }

@Override
public ParenState $assign(ParenState $Prm0) {
  this.Indent = $Prm0.Indent;
  this.IndentLevel = $Prm0.IndentLevel;
  this.LastSpace = $Prm0.LastSpace;
  this.NestedBlockIndent = $Prm0.NestedBlockIndent;
  this.FirstLessLess = $Prm0.FirstLessLess;
  this.QuestionColumn = $Prm0.QuestionColumn;
  this.ColonPos = $Prm0.ColonPos;
  this.StartOfFunctionCall = $Prm0.StartOfFunctionCall;
  this.StartOfArraySubscripts = $Prm0.StartOfArraySubscripts;
  this.NestedNameSpecifierContinuation = $Prm0.NestedNameSpecifierContinuation;
  this.CallContinuation = $Prm0.CallContinuation;
  this.VariablePos = $Prm0.VariablePos;
  this.BreakBeforeClosingBrace = $Prm0.BreakBeforeClosingBrace;
  this.AvoidBinPacking = $Prm0.AvoidBinPacking;
  this.BreakBeforeParameter = $Prm0.BreakBeforeParameter;
  this.NoLineBreak = $Prm0.NoLineBreak;
  this.LastOperatorWrapped = $Prm0.LastOperatorWrapped;
  this.ContainsLineBreak = $Prm0.ContainsLineBreak;
  this.ContainsUnwrappedBuilder = $Prm0.ContainsUnwrappedBuilder;
  this.AlignColons = $Prm0.AlignColons;
  this.ObjCSelectorNameFound = $Prm0.ObjCSelectorNameFound;
  this.HasMultipleNestedBlocks = $Prm0.HasMultipleNestedBlocks;
  this.NestedBlockInlined = $Prm0.NestedBlockInlined;
  return this;
}

@Override
public ParenState clone() {
  ParenState res = new ParenState();
  res.$assign(this);
  return res;
}
