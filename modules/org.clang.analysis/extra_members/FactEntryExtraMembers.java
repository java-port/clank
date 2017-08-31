protected FactEntry(FactEntry $Prm0) {
  super($Prm0);
  this.LKind = $Prm0.LKind;
  this.AcquireLoc = new SourceLocation($Prm0.AcquireLoc);
  this.Asserted = $Prm0.Asserted;
  this.Declared = $Prm0.Declared;
}

@Override public abstract FactEntry clone();
