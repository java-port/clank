FILE_NAME = StdVectorUChar
CLASS_SUFFIX =
MAIN_CLASS = std.vectorUChar
TYPE = byte
BOXED_TYPE = Byte
ARRAY_TYPE = byte
NEW_ZERO_ARRAY = new$uchar(0)
COPY_OF_ARRAY = copyOf$uchar
POINTER_TYPE = uchar$ptr
POINTER_FACTORY_MTD = create_uchar$ptr
REFERENCE_TYPE = uchar$ref
REFERENCE_FACTORY_MTD = create_uchar$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator
ITERATOR_INTERFACE = uchar$iterator<iterator>
GENERIC_ITERATOR = uchar$iterator<?>
JAVA_ITERATOR = JavaIteratorUChar
NATIVE_CONTAINER = NativeContainerUChar
REV_ITERATOR_TYPE = std.reverse_iteratorUChar
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DEFAULT_VALUE = $$$TERM
SB_APPEND_ELEMENT_I=out.append(element == 0 ? "<EOF>" : (char)element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
SUPPLIER = byte
RESIZE_WITH_SUPPLIER = // No supplier => no version of resize with supplier
DEFVAL_WITH_SUPPLIER = return defaultValue
USE_OF_SUPPLIER = Supplier
ELEMENT_BOOL_PREDICATE=NativeCallback.UCharBoolPredicate
