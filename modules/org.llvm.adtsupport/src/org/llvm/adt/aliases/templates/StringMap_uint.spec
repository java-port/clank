FILE_NAME = StringMapUInt
CLASS_SUFFIX = 
CLASS_NAME = StringMapUInt
ENTRY = StringMapEntryUInt
ENTRY_CLASS = StringMapEntryUInt
ITERATOR = StringMapIteratorUInt
ALLOCATOR_TYPE = Allocator
VALUE_TYPE = int
VALUE_CLASS = Class<Integer>
VALUE_REFERENCE = uint$ref
CREATE_ENTRY_STRING = StringMapEntryUInt.Create
PAIR_TYPE = std.pairTypeUInt<StringRef>
ASSERT_DEFAULT_VALUE=true
IS_DATA_POINTER_LIKE = false
SET_IMPL=return (GetOrCreateValue(Key, 0).second = Val);
SET_IMPL_KEY_LEN=return (GetOrCreateValue(Key, strlen(Key), 0).second = Val);
