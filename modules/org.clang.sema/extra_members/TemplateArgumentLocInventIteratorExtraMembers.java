public TemplateArgumentLocInventIterator(TemplateArgumentLocInventIterator<Derived, InputIterator> other) {
  this.Self = other.Self;
  this.Iter = $tryClone(other.Iter);
}
@Override
public type$ref<TemplateArgumentLoc> star$ref() {
  throw new UnsupportedOperationException("Not supported yet.");
}

@Override
public TemplateArgumentLocInventIterator clone() {
  return new TemplateArgumentLocInventIterator(Self, Iter);
}

@Override
public boolean $eq(Object other) {
  return $eq_TemplateArgumentLocInventIterator$Derived$InputIterator$C(this, (TemplateArgumentLocInventIterator) other);
}

@Override
public boolean $noteq(Object other) {
  return $noteq_TemplateArgumentLocInventIterator$Derived$InputIterator$C(this, (TemplateArgumentLocInventIterator) other);
}
