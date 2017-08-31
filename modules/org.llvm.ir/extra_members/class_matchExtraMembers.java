public class_match(Class<ClassValue> cls) {
  this.cls = cls;
}

private final Class<ClassValue> cls;

public class_match(class_match other) {
  this.cls = other.cls;
}

@Override
public class_match clone() {
  return new class_match(this);
}
