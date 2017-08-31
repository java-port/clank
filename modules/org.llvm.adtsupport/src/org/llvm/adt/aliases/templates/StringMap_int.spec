FILE_NAME = StringMapInt
CLASS_SUFFIX = 
CLASS_NAME = StringMapInt
ENTRY = StringMapEntryInt
ENTRY_CLASS = StringMapEntryInt
ITERATOR = StringMapIteratorInt
ALLOCATOR_TYPE = Allocator
VALUE_TYPE = int
VALUE_CLASS = Class<Long>
VALUE_REFERENCE = int$ref
CREATE_ENTRY_STRING = StringMapEntryInt.Create
PAIR_TYPE = std.pairTypeInt<StringRef>
ASSERT_DEFAULT_VALUE=true
IS_DATA_POINTER_LIKE = false
SET_IMPL=return (GetOrCreateValue(Key, 0).second = Val);
SET_IMPL_KEY_LEN=return (GetOrCreateValue(Key, strlen(Key), 0).second = Val);
