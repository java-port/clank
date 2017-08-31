@Converted(kind = Converted.Kind.MANUAL_ADDED)
private /*uint*/int Kind;

@Override
public TemplateArgument clone() {
  assert this.getClass() == TemplateArgument.class : "derived class must override clone " + this.getClass();
  return new TemplateArgument(this);
}

public /*inline*/ TemplateArgument(type$ptr<?> This$Mem, final /*const*/ TemplateArgument /*&*/ $Prm0) {
  // : Unnamed_field(.) 
  //START JInit
  TrailingObjectsUtils.$putThisAndShift(this, This$Mem);
  this.Unnamed_field = new Unnamed_union6($Prm0.Unnamed_field);
  //END JInit
}
