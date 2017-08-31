FILE_NAME = StringMapBool
CLASS_SUFFIX = 
CLASS_NAME = StringMapBool
ENTRY = StringMapEntryBool
ENTRY_CLASS = StringMapEntryBool
ITERATOR = StringMapIteratorBool
ALLOCATOR_TYPE = Allocator
VALUE_TYPE = boolean
VALUE_CLASS = Class<Boolean>
VALUE_REFERENCE = bool$ref
CREATE_ENTRY_STRING = StringMapEntryBool.Create
PAIR_TYPE = std.pairTypeBool<StringRef>
ASSERT_DEFAULT_VALUE=true
IS_DATA_POINTER_LIKE = false
SET_IMPL=return (GetOrCreateValue(Key, false).second = Val);
SET_IMPL_KEY_LEN=return (GetOrCreateValue(Key, strlen(Key), false).second = Val);
