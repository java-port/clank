public Attachment(int MDKind, TypedTrackingMDRef<MDNode> Node) {
  this.MDKind = MDKind;
  this.Node = Node;
}

@Override public Attachment clone() { 
  return new Attachment(this); 
}
