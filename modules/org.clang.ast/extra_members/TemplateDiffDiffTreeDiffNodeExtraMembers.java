public /*inline*/ DiffNode(final DiffNode /*&*/$Prm0) {
  // : Kind(static_cast<DiffNode &&>().Kind), NextNode(static_cast<DiffNode &&>().NextNode), ChildNode(static_cast<DiffNode &&>().ChildNode), ParentNode(static_cast<DiffNode &&>().ParentNode), FromArgInfo(static_cast<DiffNode &&>().FromArgInfo), ToArgInfo(static_cast<DiffNode &&>().ToArgInfo), Same(static_cast<DiffNode &&>().Same) 
  //START JInit
  this.Kind = $Prm0.Kind;
  this.NextNode = $Prm0.NextNode;
  this.ChildNode = $Prm0.ChildNode;
  this.ParentNode = $Prm0.ParentNode;
  this.FromArgInfo = new TemplateArgumentInfo($Prm0.FromArgInfo);
  this.ToArgInfo = new TemplateArgumentInfo($Prm0.ToArgInfo);
  this.Same = $Prm0.Same;
  //END JInit
}

@Override public DiffNode clone() {
  return new DiffNode(this);
}

@Override public DiffNode move() {
  return new DiffNode(JD$Move.INSTANCE, this);
}
