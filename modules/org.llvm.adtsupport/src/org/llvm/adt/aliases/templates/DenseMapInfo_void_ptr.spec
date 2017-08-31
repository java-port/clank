FILE_NAME = DenseMapInfoVoid$Ptr
CLASS_SUFFIX = <TyPtr/*P*//* better to extend NativePointer, but in some place Object is used for void P*/>
IMPLEMENTS_DENSE_MAP_INFO=implements DenseMapInfo<TyPtr/*P*/>
TYPE_SUFFIX = <TyPtr/*P*/>
JAVA_CLASS_DESCRIPTION=\
DenseMapInfo<TypePtr *> where TypePtr is LibC-pointers (NativePointer derived)\n \
* (@see DenseMapInfoType$Ptr for usual classes)\n \
* We do not restrict template param, because "void *" is "Object P" in Java
TYPE = TyPtr/*P*/
RAW_TYPE = Object/*P*/
EXTRA_ASSERT_FOR_EMPTY_TOMBSTONE_KEYS=\
assert (emptyKey != null) : "emptyKey marker must be non null";\n    \
assert (tombstoneKey != null) : "tombstoneKey marker must be non null";
COMMENT_ALT=
DEFAULT_EMPTY_KEY=new Object/*P*/()
DEFAULT_TOMBSTONE_KEY=new Object/*P*/()
DEFAULT_HASH_VALUE_IMPL=return Native.$hashcode_ptr(Key); // use $hashcode for libc-pointers
DEFAULT_HASH_VALUE_ALT_IMPL=throw new UnsupportedOperationException("Override to support alternative Key types with hash same as Key");
DEFAULT_EQUAL_KEY_IMPL=return Native.$eq_ptr(LHS, RHS); // check if libc-pointers are equal by $eq_ptr
DEFAULT_EQUAL_ALT_KEY_IMPL=throw new UnsupportedOperationException("Override to support alternative Key types comparable with Key");
DEFAULT_POINTER_LIKE_IMPL = // need to $tryClone native$pointers\n    return false;
EXTRA_ASSERT_FOR_KEY=assert checkKey(Key);
EXTRA_ASSERT_FOR_ALT_KEY=
EXTRA_ASSERT_FOR_EQUAL_KEYS=\
assert checkKey(LHS);\n    \
assert checkKey(RHS);
CHECK_KEY_CLASS_IMPL=
