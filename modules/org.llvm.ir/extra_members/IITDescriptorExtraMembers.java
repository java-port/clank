public IITDescriptor() {
  this.Kind = IITDescriptorKind.Void; 
  this.Unnamed_field1 = new Unnamed_union1(0);
}

public IITDescriptor(IITDescriptorKind Kind, int Field) {
  this.Kind = Kind;
  this.Unnamed_field1 = new Unnamed_union1(Field);
}
