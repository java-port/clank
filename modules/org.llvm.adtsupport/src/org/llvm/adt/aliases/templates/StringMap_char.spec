FILE_NAME = StringMapChar
CLASS_SUFFIX = 
CLASS_NAME = StringMapChar
ENTRY = StringMapEntryChar
ENTRY_CLASS = StringMapEntryChar
ITERATOR = StringMapIteratorChar
ALLOCATOR_TYPE = Allocator
VALUE_TYPE = byte
VALUE_CLASS = Class<Byte>
VALUE_REFERENCE = char$ref
CREATE_ENTRY_STRING = StringMapEntryChar.Create
PAIR_TYPE = std.pairTypeChar<StringRef>
ASSERT_DEFAULT_VALUE=true
IS_DATA_POINTER_LIKE = false
SET_IMPL=return (GetOrCreateValue(Key, (byte)0).second = Val);
SET_IMPL_KEY_LEN= return (GetOrCreateValue(Key, strlen(Key), (byte)0).second = Val);
