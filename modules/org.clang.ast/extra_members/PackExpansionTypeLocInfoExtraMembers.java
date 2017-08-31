public PackExpansionTypeLocInfo() {
  EllipsisLoc = new SourceLocation();
}

public PackExpansionTypeLocInfo(PackExpansionTypeLocInfo $Prm0) {
  this.EllipsisLoc = new SourceLocation($Prm0.EllipsisLoc);
}

@Override
public PackExpansionTypeLocInfo clone() {
  return new PackExpansionTypeLocInfo(this);
}
