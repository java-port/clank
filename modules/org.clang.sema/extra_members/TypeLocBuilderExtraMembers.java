/**
 * we interpose memcopy used in pushFullCopy to manipulate isPointerLike with minimal changes in code
 */
private static void memcpy(type$ptr to, type$ptr from, /*size_t*/int size) {
  std.memcpy(to, from, size, TypeLoc.DATA_DEEP_COPY);
}
