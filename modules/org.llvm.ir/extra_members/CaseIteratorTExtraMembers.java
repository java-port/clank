protected CaseIteratorT(CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> $Prm0) {
  this.SI = $Prm0.SI;
  this.Index = $Prm0.Index;
}

protected CaseIteratorT(JD$Move _dparam, CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> $Prm0) {
  this.SI = $Prm0.SI;
  this.Index = $Prm0.Index;
}

@Override
public CaseIteratorT clone() {
  return new CaseIteratorT(this);
}
