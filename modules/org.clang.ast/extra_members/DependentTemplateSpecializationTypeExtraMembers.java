private final type$ptr<TemplateArgument/*P*/> TemplateArguments;

@Override
public Iterator<TemplateArgument> iterator() {
  return new JavaIterator<TemplateArgument>(begin(), end());
}
