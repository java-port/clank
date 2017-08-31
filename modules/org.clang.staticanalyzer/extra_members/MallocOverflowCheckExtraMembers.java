public /*inline*/ MallocOverflowCheck /*&*/ $assign(final MallocOverflowCheck /*&&*/$Prm0) {
  this.mulop = $Prm0.mulop;
  this.variable = $Prm0.variable;
  this.maxVal.$assign($Prm0.maxVal);
  return /*Deref*/this;
}

MallocOverflowCheck() {
  this.mulop = null;
  this.variable = null;
  this.maxVal = new APSInt();
}

@Override public MallocOverflowCheck clone() {
  return new MallocOverflowCheck().$assign(this);
}
