@Override public ActiveTemplateInstantiation clone() { 
  return new ActiveTemplateInstantiation().$assign(this); 
}

@Override
public boolean $eq(ActiveTemplateInstantiation other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  } 
  if (this.NumTemplateArgs != other.NumTemplateArgs) {
    return false;
  }
  if (this.Kind != other.Kind) {
    return false;
  }
  if (this.Template != other.Template) {
    return false;
  }
  if (this.Entity != other.Entity) {
    return false;
  }
  if (this.DeductionInfo != other.DeductionInfo) {
    return false;
  }
  if (this.PointOfInstantiation.$noteq(other.PointOfInstantiation)) {
    return false;
  }
  if (this.InstantiationRange.$noteq(other.InstantiationRange)) {
    return false;
  }
  if (!Native.$eq_ptr(this.TemplateArgs, other.TemplateArgs)) {
    return false;
  }
  return true;
}
