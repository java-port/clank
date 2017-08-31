public /*inline*/ ConversionFixItGenerator(final ConversionFixItGenerator /*&&*/$Prm0) {
  // : Hints(static_cast<ConversionFixItGenerator &&>().Hints), NumConversionsFixed(static_cast<ConversionFixItGenerator &&>().NumConversionsFixed), Kind(static_cast<ConversionFixItGenerator &&>().Kind), CompareTypes(static_cast<ConversionFixItGenerator &&>().CompareTypes) 
  //START JInit
  this.Hints = new std.vector<FixItHint>($Prm0.Hints);
  this.NumConversionsFixed = $Prm0.NumConversionsFixed;
  this.Kind = $Prm0.Kind;
  this.CompareTypes = $tryClone($Prm0.CompareTypes);
  //END JInit
}

@Override
public ConversionFixItGenerator $assign(ConversionFixItGenerator $Prm0) {
  this.Hints.$assign($Prm0.Hints);
  this.NumConversionsFixed = $Prm0.NumConversionsFixed;
  this.Kind = $Prm0.Kind;
  this.CompareTypes = $tryClone($Prm0.CompareTypes);
  return /*Deref*/this;
}

@Override
public ConversionFixItGenerator clone() {
  return new ConversionFixItGenerator(this);
}
