public TemplateNameLocInfo() {
  this.NameLoc = new SourceLocation();
}

public TemplateNameLocInfo(TemplateNameLocInfo Other) {
  this.NameLoc = new SourceLocation(Other.NameLoc);
}

@Override
public TemplateNameLocInfo $assign(TemplateNameLocInfo value) {
  this.NameLoc.$assign(value.NameLoc);
  return this;
}

@Override
public TemplateNameLocInfo clone() {
  assert this.getClass() == TemplateNameLocInfo.class : "Why not overridden in " + this.getClass();
  return new TemplateNameLocInfo(this);
}
