@Converted(kind = Converted.Kind.MANUAL_ADDED)
public TemplateIdAnnotation() {
  this.SS = new CXXScopeSpec();
  this.TemplateKWLoc = new SourceLocation();
  this.TemplateNameLoc = new SourceLocation();
  this.Operator = OverloadedOperatorKind.OO_None;
  this.Template = new OpaquePtr<>();
  this.Kind = TemplateNameKind.TNK_Non_template;
  this.LAngleLoc = new SourceLocation();
  this.RAngleLoc = new SourceLocation();
}