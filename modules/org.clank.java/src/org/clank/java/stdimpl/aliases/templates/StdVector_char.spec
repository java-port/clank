FILE_NAME = StdVectorChar
CLASS_SUFFIX =
MAIN_CLASS = std.vectorChar
TYPE = byte
BOXED_TYPE = Byte
ARRAY_TYPE = byte
NEW_ZERO_ARRAY = new$char(0)
COPY_OF_ARRAY = copyOf$char
POINTER_TYPE = char$ptr
POINTER_FACTORY_MTD = create_char$ptr
REFERENCE_TYPE = char$ref
REFERENCE_FACTORY_MTD = create_char$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator
ITERATOR_INTERFACE = char$iterator<iterator>
GENERIC_ITERATOR = char$iterator<?>
JAVA_ITERATOR = JavaIteratorChar
NATIVE_CONTAINER = NativeContainerChar
REV_ITERATOR_TYPE = std.reverse_iteratorChar
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DEFAULT_VALUE = 0
SB_APPEND_ELEMENT_I=out.append(element == 0 ? "<EOF>" : (char)element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
SUPPLIER = byte
RESIZE_WITH_SUPPLIER = // No supplier => no version of resize with supplier
DEFVAL_WITH_SUPPLIER = return defaultValue
USE_OF_SUPPLIER = Supplier
ELEMENT_BOOL_PREDICATE=NativeCallback.CharBoolPredicate
