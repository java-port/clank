public PointerAlignElem(int ABIAlign, int PrefAlign, int TypeByteWidth, int AddressSpace) {
  this.ABIAlign = ABIAlign;
  this.PrefAlign = PrefAlign;
  this.TypeByteWidth = TypeByteWidth;
  this.AddressSpace = AddressSpace;
}


@Override
public PointerAlignElem $assign(PointerAlignElem $Prm0) {
  this.ABIAlign = $Prm0.ABIAlign;
  this.PrefAlign = $Prm0.PrefAlign;
  this.TypeByteWidth = $Prm0.TypeByteWidth;
  this.AddressSpace = $Prm0.AddressSpace;
  return /*Deref*/this;
}

@Override
public PointerAlignElem clone() {
  return new PointerAlignElem(this.ABIAlign, this.PrefAlign, this.TypeByteWidth, this.AddressSpace);
}
