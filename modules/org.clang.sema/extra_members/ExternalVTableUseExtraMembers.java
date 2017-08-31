@Override
public ExternalVTableUse $assign(ExternalVTableUse $Prm0) {
  this.Record = $Prm0.Record;
  this.Location.$assign($Prm0.Location);
  this.DefinitionRequired = $Prm0.DefinitionRequired;
  return this;
}

@Override
public ExternalVTableUse clone() {
  return new ExternalVTableUse().$assign(this);
}
