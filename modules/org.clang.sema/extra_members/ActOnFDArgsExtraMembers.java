public ActOnFDArgs(Declarator D) {
  this.D = D;
}
  
//  private boolean AddToScope;
public final bool$ref AddToScope$Ref = new bool$ref() {
  @Override public boolean $deref() { return AddToScope; }
  @Override public boolean $set(boolean value) { return AddToScope = value; }
};

public ActOnFDArgs(Scope S, Declarator D, MutableArrayRef<TemplateParameterList> TemplateParamLists, boolean AddToScope) {
  this.S = S;
  this.D = D;
  this.TemplateParamLists = $tryClone(TemplateParamLists);
  this.AddToScope = AddToScope;
}  
