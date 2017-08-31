@Converted(kind = Converted.Kind.MANUAL_ADDED)
public TemplateSpecCandidate() {
  this.FoundDecl = new DeclAccessPair();
  this.Specialization = null;
  this.DeductionFailure = new DeductionFailureInfo();
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public TemplateSpecCandidate(TemplateSpecCandidate Other) {
  this.FoundDecl = new DeclAccessPair(Other.FoundDecl);
  this.Specialization = Other.Specialization;
  this.DeductionFailure = new DeductionFailureInfo(Other.DeductionFailure);
}

@Override
public TemplateSpecCandidate clone() {
  return new TemplateSpecCandidate(this);
}