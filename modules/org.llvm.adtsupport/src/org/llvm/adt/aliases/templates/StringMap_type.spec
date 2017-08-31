FILE_NAME = StringMap
CLASS_SUFFIX = <ValueTy>
CLASS_NAME = StringMap<ValueTy>
ENTRY = StringMapEntry<ValueTy>
ENTRY_CLASS = StringMapEntry
ITERATOR = StringMapIterator<ValueTy>
ALLOCATOR_TYPE = Allocator
VALUE_TYPE = ValueTy
VALUE_CLASS = Class<ValueTy>
VALUE_REFERENCE = type$ref<ValueTy>
CREATE_ENTRY_STRING = StringMapEntry.<Allocator, ValueTy>Create
PAIR_TYPE = std.pair<StringRef, ValueTy>
ASSERT_DEFAULT_VALUE=NativeTrace.assertDefaultValue(defaultValue)
IS_DATA_POINTER_LIKE = (defaultValue == null)
SET_IMPL=return (GetOrCreateValue(Key, null).second = (isDataPointerLike ? Val : $tryClone(Val)));
SET_IMPL_KEY_LEN=return (GetOrCreateValue(Key, strlen(Key), null).second = (isDataPointerLike ? Val : $tryClone(Val)));
