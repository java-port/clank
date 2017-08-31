public Writeback() { 
  this.Source = new LValue();
  this.Temporary = new Address();
  this.ToUse = null;
}

public Writeback(LValue Source, Address Temporary, Value ToUse) {
  this.Source = new LValue(Source);
  this.Temporary = new Address(Temporary);
  this.ToUse = ToUse;
}

@Override public Writeback clone() {
  return new Writeback(this.Source, this.Temporary, this.ToUse);
}

@Override public Writeback move() {
  return new Writeback(JD$Move.INSTANCE, this);
}
