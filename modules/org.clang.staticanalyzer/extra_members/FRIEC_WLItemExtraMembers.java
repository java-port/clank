public FRIEC_WLItem() {
  this.N = null;
  this.I = null;
  this.E = null;
}

protected FRIEC_WLItem(FRIEC_WLItem $Prm0) {
  this.N = $Prm0.N;
  this.I = $Clone($Prm0.I);
  this.E = $Clone($Prm0.E);
}

@Override public FRIEC_WLItem clone() {
  return new FRIEC_WLItem(this);
}
