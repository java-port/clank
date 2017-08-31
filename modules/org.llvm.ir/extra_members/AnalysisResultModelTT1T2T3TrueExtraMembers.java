private final Class<PassT> clazzT;

public @Override void swap(NativeSwappable RHS) {
  AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT> other = 
          (AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT>) RHS;
  assert this.clazzT == other.clazzT;
  ResultT myOldResult = this.Result;
  this.Result = other.Result;
  other.Result = myOldResult;
}