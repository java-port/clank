FILE_NAME = DenseMapInfoStringRef
CLASS_SUFFIX = 
IMPLEMENTS_DENSE_MAP_INFO=implements DenseMapInfo<org.llvm.adt.StringRef>
TYPE_SUFFIX = 
JAVA_CLASS_DESCRIPTION=\
DenseMapInfo<StringRef> specialization.
TYPE = org.llvm.adt.StringRef
RAW_TYPE = Object
EXTRA_ASSERT_FOR_EMPTY_TOMBSTONE_KEYS=\
assert (emptyKey != null) : "emptyKey marker must be non null";\n    \
assert (tombstoneKey != null) : "tombstoneKey marker must be non null";
COMMENT_ALT=
DEFAULT_EMPTY_KEY=new org.llvm.adt.StringRef()
DEFAULT_TOMBSTONE_KEY=new org.llvm.adt.StringRef()
DEFAULT_HASH_VALUE_IMPL=return org.llvm.support.llvm.HashString(Key);
DEFAULT_HASH_VALUE_ALT_IMPL=throw new UnsupportedOperationException("Override to support alternative Key types with hash same as Key");
DEFAULT_EQUAL_KEY_IMPL=return org.llvm.support.llvm.$eq_StringRef(LHS, RHS); 
DEFAULT_EQUAL_ALT_KEY_IMPL=throw new UnsupportedOperationException("Override to support alternative Key types comparable with Key");
DEFAULT_POINTER_LIKE_IMPL = return false;
EXTRA_ASSERT_FOR_KEY=assert checkKey(Key);
EXTRA_ASSERT_FOR_ALT_KEY=
EXTRA_ASSERT_FOR_EQUAL_KEYS=\
assert checkKey(LHS);\n    \
assert checkKey(RHS);
CHECK_KEY_CLASS_IMPL=assert Key != null;\n