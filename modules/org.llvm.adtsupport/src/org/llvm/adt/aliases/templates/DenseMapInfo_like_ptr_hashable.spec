FILE_NAME = DenseMapInfoHashable$LikePtr
CLASS_SUFFIX = <TyPtr/*P*/ extends Native.NativeHashable>
IMPLEMENTS_DENSE_MAP_INFO=implements DenseMapInfo<TyPtr/*P*/>
TYPE_SUFFIX = <TyPtr/*P*/>
JAVA_CLASS_DESCRIPTION=\
DenseMapInfo<TypePtr *> where TypePtr is C++ pointer but not void$ptr (@see DenseMapInfoVoid$Ptr).
TYPE = TyPtr/*P*/
RAW_TYPE = Object/*P*/
EXTRA_ASSERT_FOR_EMPTY_TOMBSTONE_KEYS=\
assert (emptyKey != null) : "emptyKey marker must be non null";\n    \
assert (tombstoneKey != null) : "tombstoneKey marker must be non null";
COMMENT_ALT=
DEFAULT_EMPTY_KEY=new Object/*P*/()
DEFAULT_TOMBSTONE_KEY=new Object/*P*/()
DEFAULT_HASH_VALUE_IMPL=return Key.$hashcode();
DEFAULT_HASH_VALUE_ALT_IMPL=throw new UnsupportedOperationException("Override to support alternative Key types with hash same as Key");
DEFAULT_EQUAL_KEY_IMPL=return LHS == RHS; // java-class pointers are equal when java-references are equal
DEFAULT_EQUAL_ALT_KEY_IMPL=throw new UnsupportedOperationException("Override to support alternative Key types comparable with Key");
DEFAULT_POINTER_LIKE_IMPL = // never copy pointers\n    return true;
EXTRA_ASSERT_FOR_KEY=assert checkKey(Key);
EXTRA_ASSERT_FOR_ALT_KEY=
EXTRA_ASSERT_FOR_EQUAL_KEYS=\
assert checkKey(LHS);\n    \
assert checkKey(RHS);
CHECK_KEY_CLASS_IMPL=\
if (Key == null) return true;\n    \
if (Key instanceof void$ptr) {\n      \
  throw new IllegalArgumentException("for void$ptr [" + Key.getClass() + "] classes use DenseMapInfoVoid$Ptr");\n    \
}
