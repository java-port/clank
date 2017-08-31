@Converted(kind = Converted.Kind.MANUAL_ADDED)
public UserDefinedConversionSequence() {
  this.Before = new StandardConversionSequence();
  this.EllipsisConversion = false;
  this.HadMultipleCandidates = false;
  this.After = new StandardConversionSequence();
  this.ConversionFunction = null;
  this.FoundConversionFunction = new DeclAccessPair();
}

@Override
public UserDefinedConversionSequence clone() {
  return new UserDefinedConversionSequence().$assign(this);
}
