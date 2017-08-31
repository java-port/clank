public String toJavaString() {
  return str().toJavaString();
}

private static String getKindName(/*NodeKind*/char kind) {
  switch (kind) {
    case NodeKind.NullKind:
      return "NullKind";
    case NodeKind.EmptyKind:
      return "EmptyKind";
    case NodeKind.TwineKind:
      return "TwineKind";
    case NodeKind.CStringKind:
      return "CStringKind";
    case NodeKind.StdStringKind:
      return "StdStringKind";
    case NodeKind.StringRefKind:
      return "StringRefKind";
    case NodeKind.SmallStringKind:
      return "SmallStringKind";
    case NodeKind.CharKind:
      return "CharKind";
    case NodeKind.DecUIKind:
      return "DecUIKind";
    case NodeKind.DecIKind:
      return "DecIKind";
    case NodeKind.DecULKind:
      return "DecULKind";
    case NodeKind.DecLKind:
      return "DecLKind";
    case NodeKind.DecULLKind:
      return "DecULLKind";
    case NodeKind.DecLLKind:
      return "DecLLKind";
    case NodeKind.UHexKind:
      return "UHexKind";
    default:
      llvm_unreachable_internal("Unknown " + $ushort2uint(kind));
      return "Unknown " + $ushort2uint(kind);
  }
}
