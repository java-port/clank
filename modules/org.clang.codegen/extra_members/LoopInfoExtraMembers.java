public LoopInfo() { 
  this.Attrs = new LoopAttributes();
}

private LoopInfo(LoopInfo $Prm0) { 
  this.LoopID = $Prm0.LoopID;
  this.Header = $Prm0.Header;
  this.Attrs = new LoopAttributes($Prm0.Attrs);
}

@Override public LoopInfo clone() {
  return new LoopInfo(this);
}
