@Override
public type$ref<TemplateArgumentLoc> star$ref() {
  throw new UnsupportedOperationException("Not supported yet.");
}

@Override
public TemplateArgumentLocContainerIterator clone() {
  return new TemplateArgumentLocContainerIterator(Container, Index);
}

@Override
public boolean $eq(Object other) {
  return $eq_TemplateArgumentLocContainerIterator$ArgLocContainer$C(
          (TemplateArgumentLocContainerIterator)this, 
          (TemplateArgumentLocContainerIterator)other
         );
}
