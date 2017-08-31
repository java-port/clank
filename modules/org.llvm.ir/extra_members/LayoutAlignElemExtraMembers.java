public LayoutAlignElem(byte AlignType, int TypeBitWidth, char ABIAlign, char PrefAlign) {
  this.AlignType = AlignType;
  this.TypeBitWidth = TypeBitWidth;
  this.ABIAlign = ABIAlign;
  this.PrefAlign = PrefAlign;
}

public LayoutAlignElem(byte AlignType, int TypeBitWidth, int ABIAlign, int PrefAlign) {
  this(AlignType, TypeBitWidth, $uint2ushort(ABIAlign), $uint2ushort(PrefAlign));
}

@Override
public LayoutAlignElem clone() {
  return new LayoutAlignElem(this.AlignType, this.TypeBitWidth, this.ABIAlign, this.PrefAlign);
}
