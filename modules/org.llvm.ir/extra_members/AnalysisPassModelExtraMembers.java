public @Override void swap(NativeSwappable RHS) {
  AnalysisPassModel<IRUnitT, PassT> other = (AnalysisPassModel<IRUnitT, PassT>) RHS;
  PassT old = this.Pass;
  this.Pass = other.Pass;
  other.Pass = old;
}
