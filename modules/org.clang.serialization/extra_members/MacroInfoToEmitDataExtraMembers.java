public MacroInfoToEmitData() {
}

public MacroInfoToEmitData(IdentifierInfo Name, MacroInfo MI, int ID) {
  this.Name = Name;
  this.MI = MI;
  this.ID = ID;
}

@Override
public MacroInfoToEmitData $assign(MacroInfoToEmitData $Prm0) {
  this.Name = $Prm0.Name;
  this.MI = $Prm0.MI;
  this.ID = $Prm0.ID;
  return this;
}

@Override
public MacroInfoToEmitData clone() {
  return new MacroInfoToEmitData(Name, MI, ID);
}
