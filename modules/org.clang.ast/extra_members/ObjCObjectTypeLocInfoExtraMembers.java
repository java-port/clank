public ObjCObjectTypeLocInfo() {
  TypeArgsLAngleLoc = new SourceLocation();
  TypeArgsRAngleLoc = new SourceLocation();
  ProtocolLAngleLoc = new SourceLocation();
  ProtocolRAngleLoc = new SourceLocation();
  HasBaseTypeAsWritten = false;
}

public ObjCObjectTypeLocInfo(ObjCObjectTypeLocInfo $Prm0) {
  TypeArgsLAngleLoc = new SourceLocation($Prm0.TypeArgsLAngleLoc);
  TypeArgsRAngleLoc = new SourceLocation($Prm0.TypeArgsRAngleLoc);
  ProtocolLAngleLoc = new SourceLocation($Prm0.ProtocolLAngleLoc);
  ProtocolRAngleLoc = new SourceLocation($Prm0.ProtocolRAngleLoc);
  HasBaseTypeAsWritten = $Prm0.HasBaseTypeAsWritten;
}

@Override
public ObjCObjectTypeLocInfo clone() {
  return new ObjCObjectTypeLocInfo(this);
}
