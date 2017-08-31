private DefMacroDirective /*P*/ LatestLocalAndAmbiguous$Ptr;
private boolean LatestLocalAndAmbiguous$Bool;

@Override
public MacroDefinition $assign(MacroDefinition value) {
  this.LatestLocalAndAmbiguous$Ptr = value.LatestLocalAndAmbiguous$Ptr;
  this.LatestLocalAndAmbiguous$Bool = value.LatestLocalAndAmbiguous$Bool;
  this.ModuleMacros.$assign(value.ModuleMacros);
  return this;
}

@Override
public MacroDefinition clone() {
  return new MacroDefinition(this);
}

@Override
public boolean $eq(MacroDefinition other) {
  return this.LatestLocalAndAmbiguous$Bool == other.LatestLocalAndAmbiguous$Bool  
          && this.LatestLocalAndAmbiguous$Ptr == other.LatestLocalAndAmbiguous$Ptr  
          && this.ModuleMacros.$eq(other.ModuleMacros);
}

public String toString() {
  return "" + "LatestLocalAndAmbiguous={" + LatestLocalAndAmbiguous$Bool + "|" + LatestLocalAndAmbiguous$Ptr // NOI18N
            + "}, ModuleMacros=" + ModuleMacros; // NOI18N
}
