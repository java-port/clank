FILE_NAME = StdVectorUInt
CLASS_SUFFIX =
MAIN_CLASS = std.vectorUInt
TYPE = int
BOXED_TYPE = Integer
ARRAY_TYPE = int
NEW_ZERO_ARRAY = new$uint(0)
COPY_OF_ARRAY = copyOf$uint
POINTER_TYPE = uint$ptr
POINTER_FACTORY_MTD = create_uint$ptr
REFERENCE_TYPE = uint$ref
REFERENCE_FACTORY_MTD = create_uint$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator
ITERATOR_INTERFACE = uint$iterator<iterator>
GENERIC_ITERATOR = uint$iterator<?>
JAVA_ITERATOR = JavaIteratorUInt
NATIVE_CONTAINER = NativeContainerUInt
REV_ITERATOR_TYPE = std.reverse_iteratorUInt
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DEFAULT_VALUE = 0
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
SUPPLIER = int
RESIZE_WITH_SUPPLIER = // No supplier => no version of resize with supplier
DEFVAL_WITH_SUPPLIER = return defaultValue
USE_OF_SUPPLIER = Supplier
ELEMENT_BOOL_PREDICATE=NativeCallback.UIntBoolPredicate
